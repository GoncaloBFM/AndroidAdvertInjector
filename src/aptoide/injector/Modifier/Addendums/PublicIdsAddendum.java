package aptoide.injector.Modifier.Addendums;

import aptoide.injector.Modifier.XMLRW.XMLParser;
import aptoide.injector.Modifier.XMLRW.XMLRW;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gbfm on 8/12/15.
 */
public class PublicIdsAddendum extends BaseXMLAddendum implements IAddendum {

	private static final String PARENT_NODE= "/*";
	private static final String NODES_ALREADY_THERE = "/*/*";
	private static final String ID_ATTRIBUTE_NAME = "id";
	private static final String TYPE_ATTRIBUTE_NAME = "type";
	private static final String NAME_ATTRIBUTE_NAME = "name";
	private IdGenerator idGenerator;

	public PublicIdsAddendum(String addendumFile, String pathToPublicIdFile) throws AddendumException {
		super(addendumFile, pathToPublicIdFile);

		try {
			this.targetFile = new XMLRW(pathToPublicIdFile);
			this.idGenerator = new IdGenerator(pathToPublicIdFile);
		} catch (Exception e) {
			throw new AddendumException("Could not load public ids file", e);
		}
	}


	@Override
	public LinkedList<Resource> apply() throws AddendumException {
		NodeList nodes = null;

		try {
			nodes = this.addendum.getNodes(ADDENDUM_NODES);
		} catch (XPathExpressionException e) {
			throw new AddendumException("Could not get nodes to from the addendum", e);
		}

		Node parentNode = null;
		try {
			parentNode = this.targetFile.getNode(PARENT_NODE);
		} catch (XPathExpressionException e) {
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
			} catch (XPathExpressionException e) {
				throw new AddendumException("Could not find new id for resource no." + i + " to add", e);
			}

			attributes.getNamedItem(ID_ATTRIBUTE_NAME).setNodeValue(newId);
			parentNode.appendChild(importedNode);

			newResourcesList.add(new Resource(newId, oldId, resourceType, resourceName));
		}

		return newResourcesList;
	}

	private class IdGenerator extends XMLParser {

		public IdGenerator(String pathToPublicIdFile) throws IOException, SAXException, ParserConfigurationException {
			super(pathToPublicIdFile);
		}

		HashMap<String, Long> idMap = new HashMap<String, Long>();

		private int lastIdBlock = 0;

		public String getIdForResource(String resource) throws XPathExpressionException {
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

		private long androidIdHexStringToLong(String androidId) {
			return Long.parseLong(androidId.substring(2), 16);
		}

		private String getAndroidIdHexStringFromNode(Node node) {
			return node.getAttributes().getNamedItem(ID_ATTRIBUTE_NAME).getNodeValue();
		}

		private String longToAndroidIdHexString(long id) {
			return  "0x" + Long.toHexString(id);
		}

		private long getAvailableIdForResource(String resourceType) throws XPathExpressionException {
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

		private long getNewIdBlock() {
			if (this.lastIdBlock == 0) {
				boolean found = false;
				do {
					try {
						Node node = PublicIdsAddendum.this.targetFile.getNode(NODES_ALREADY_THERE + "[@" + ID_ATTRIBUTE_NAME + "=\"" + this.getIdFromBlockValue(++this.lastIdBlock) + "\"]");
						found = node == null;
					} catch (XPathExpressionException e) {}
				} while (!found);
			} else {
				this.lastIdBlock++;
			}
			return this.androidIdHexStringToLong(this.getIdFromBlockValue(this.lastIdBlock));
		}

		private String getIdFromBlockValue(int blockValue) {
			return  "0x7f0" + blockValue + "0000" ;
		}
	}

}
