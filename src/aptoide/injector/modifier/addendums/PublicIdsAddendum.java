package aptoide.injector.modifier.addendums;

import aptoide.injector.modifier.xmlrw.XMLException;
import aptoide.injector.modifier.xmlrw.XMLParser;
import aptoide.injector.modifier.xmlrw.XMLPathException;
import aptoide.injector.modifier.xmlrw.XMLRW;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Addendum parser for the android public ids addendum
 *
 * @author      Gonçalo M.
 */
public class PublicIdsAddendum extends BaseXMLAddendum implements IAddendum {

	private static final String PARENT_NODE= "/*";
	private static final String NODES_ALREADY_THERE = "/*/*";
	private static final String ID_ATTRIBUTE_NAME = "id";
	private static final String TYPE_ATTRIBUTE_NAME = "type";
	private static final String NAME_ATTRIBUTE_NAME = "name";
	private IdGenerator idGenerator;

	/**
	 * Creates a PublicIdsAddendum based on the public ids addendum file and the path to the public ids file
	 * @param addendumFile Addendum file
	 * @param pathToPublicIdFile Path to the public ids file
	 * @throws AddendumException Could not load addendum file
	 */
	public PublicIdsAddendum(String addendumFile, String pathToPublicIdFile) throws AddendumException {
		super(addendumFile, pathToPublicIdFile);

		try {
			this.targetFile = new XMLRW(pathToPublicIdFile);
			this.idGenerator = new IdGenerator(pathToPublicIdFile);
		} catch (Exception e) {
			throw new AddendumException("Could not load public ids file", e);
		}
	}

	/**
	 * @see aptoide.injector.modifier.addendums.IAddendum for the full documentation
	 * @note When adding new resources new id's are also generated for them
	 */
	@Override
	public LinkedList<Resource> apply() throws AddendumException {
		NodeList nodes = null;

		try {
			nodes = this.addendum.getNodes(ADDENDUM_NODES);
		} catch (XMLException e) {
			throw new AddendumException("Could not get nodes to from the addendum", e);
		}

		Node parentNode = null;
		try {
			parentNode = this.targetFile.getNode(PARENT_NODE);
		} catch (XMLException e) {
			throw new AddendumException("Could not get parent node from public ids files", e);
		}

		LinkedList<Resource> newResourcesList = new LinkedList<Resource>();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node importedNode = this.targetFile.importNode(nodes.item(i));

			NamedNodeMap attributes = importedNode.getAttributes();
			String resourceType = attributes.getNamedItem(TYPE_ATTRIBUTE_NAME).getNodeValue();
			String resourceName = attributes.getNamedItem(NAME_ATTRIBUTE_NAME).getNodeValue();
			String oldId = attributes.getNamedItem(ID_ATTRIBUTE_NAME).getNodeValue();
			String newId = null;

			try {
				newId = this.idGenerator.getIdForResource(resourceType);
			} catch (XMLException e) {
				throw new AddendumException("Could not find new id for resource no." + i + " to add", e);
			}

			attributes.getNamedItem(ID_ATTRIBUTE_NAME).setNodeValue(newId);
			parentNode.appendChild(importedNode);

			newResourcesList.add(new Resource(newId, oldId, resourceType, resourceName));
		}

		return newResourcesList;
	}

	/**
	 * Class used to generate new id's
	 *
	 * @author      Gonçalo M.
	 */
	private class IdGenerator extends XMLParser {

		/**
		 * Creates a new IdGenerator for a specified public ids file
		 * @param pathToPublicIdFile Path to the public ids file
		 * @throws XMLException Malformed public ids file
		 */
		public IdGenerator(String pathToPublicIdFile) throws XMLException {
			super(pathToPublicIdFile);
		}

		HashMap<String, Long> idMap = new HashMap<String, Long>();

		private int lastIdBlock = 0;

		/**
		 * Generates a new id for a specific resource type, if the resource type is not found a new id block is generated
		 * @param resource Resource type
		 * @return The new id for the specified resource type
		 * @throws XMLException Could not generate the new id
		 */
		public String getIdForResource(String resource) throws XMLException {
			long id;
			if (this.idMap.get(resource) == null) {
				id = this.getAvailableIdForResource(resource) + 1;
				this.idMap.put(resource, id);
			} else {
				id = this.idMap.get(resource) + 1;
				this.idMap.put(resource, id);
			}
			return this.longToAndroidIdHexString(id);
		}

		/**
		 * Hex string to Long converter
		 * @param androidId Hex string
		 * @return The corresponding Long value
		 */
		private long androidIdHexStringToLong(String androidId) {
			return Long.parseLong(androidId.substring(2), 16);
		}

		/**
		 * Returns the hex id string from a node of the public ids file
		 * @param node Node of the public ids file
		 * @return The hex id string of the specified node of the public ids file
		 */
		private String getAndroidIdHexStringFromNode(Node node) {
			return node.getAttributes().getNamedItem(ID_ATTRIBUTE_NAME).getNodeValue();
		}

		/**
		 * Long to Hex string converter
		 * @param id Long value
		 * @return The corresponding Hex string
		 */
		private String longToAndroidIdHexString(long id) {
			return  "0x" + Long.toHexString(id);
		}

		/**
		 * Generates a new id for a specific resource type
		 * @param resourceType Resource type
		 * @return The new id for the specified resource type
		 * @throws XMLException Could not generate the new id
		 */
		private long getAvailableIdForResource(String resourceType) throws XMLException {
			NodeList nodes = PublicIdsAddendum.this.targetFile.getNodes(NODES_ALREADY_THERE + "[@" + TYPE_ATTRIBUTE_NAME + "=\"" + resourceType + "\"]");

			if (nodes.getLength() == 0) {
				return this.getNewIdBlock();
			}

			Long currentValue = this.androidIdHexStringToLong(this.getAndroidIdHexStringFromNode(nodes.item(0)));
			for (int i = 1; i < nodes.getLength(); i++) {
				long newValue = this.androidIdHexStringToLong(this.getAndroidIdHexStringFromNode(nodes.item(i)));
				if (newValue > currentValue) {
					currentValue = newValue;
				}
			}
			return  currentValue;
		}

		/**
		 * Generates a new id block for a new resource type
		 * @return The block value of the new resource typ
		 * @throws XMLException Could not generate the block of ids
		 */
		private long getNewIdBlock() {
			if (this.lastIdBlock == 0) {
				boolean found = false;
				do {
					try {
						Node node = PublicIdsAddendum.this.targetFile.getNode(NODES_ALREADY_THERE + "[@" + ID_ATTRIBUTE_NAME + "=\"" + this.getIdFromBlockValue(++this.lastIdBlock) + "\"]");
						found = node == null;
					} catch (XMLPathException e) {}
				} while (!found);
			} else {
				this.lastIdBlock++;
			}
			return this.androidIdHexStringToLong(this.getIdFromBlockValue(this.lastIdBlock));
		}

		/**
		 * Creates a android resource id from a id block value
		 * @param blockValue Id block value
		 * @return A string representation of an android resource id
		 */
		private String getIdFromBlockValue(int blockValue) {
			return  "0x7f0" + blockValue + "0000" ;
		}
	}

}
