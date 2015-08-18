package aptoide.injector.Modifier;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gbfm on 8/12/15.
 */
public class AndroidPublicIdsRW extends XMLRW implements IAndroidPublicIdsRW {

	private static final String XPATH_TO_ADD_NODES = "/*/*";
	private static final String NODES= "/*";
	private static final String ID_ATTRIBUTE_NAME = "id";
	private static final String TYPE_ATTRIBUTE_NAME = "type";
	private static final String NAME_ATTRIBUTE_NAME = "name";
	private IdGenerator idGenerator;

	public AndroidPublicIdsRW(String pathToPublicIdFile) throws IOException, SAXException, ParserConfigurationException {
		super(pathToPublicIdFile);
		this.idGenerator = new IdGenerator(pathToPublicIdFile);
	}

	@Override
	public LinkedList<Resource> addResources(String filePath) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException {
		IXMLParser addendum = new XMLParser(filePath);
		NodeList nodes = addendum.getNodes(XPATH_TO_ADD_NODES);

		Node parentNode = this.getNode(NODES);
		LinkedList<Resource> newResourcesList = new LinkedList<Resource>();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node importedNode = this.importNode(nodes.item(i));

			NamedNodeMap attributes = importedNode.getAttributes();
			String resourceType = attributes.getNamedItem(TYPE_ATTRIBUTE_NAME).getNodeValue();
			String resourceName = attributes.getNamedItem(NAME_ATTRIBUTE_NAME).getNodeValue();
			String oldId = attributes.getNamedItem(ID_ATTRIBUTE_NAME).getNodeValue();
			String newId = this.idGenerator.getIdForResource(resourceType);

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
			return node.getAttributes().getNamedItem("id").getNodeValue();
		}

		private String longToAndroidIdHexString(long id) {
			return  "0x" + Long.toHexString(id);
		}

		private long getAvailableIdForResource(String resourceType) throws XPathExpressionException {
			NodeList nodes = AndroidPublicIdsRW.this.getNodes(NODES + "/*[@type=\"" + resourceType + "\"]");
			Long currentValue = this.androidIdHexStringToLong(this.getAndroidIdHexStringFromNode(nodes.item(0)));
			for (int i = 1; i < nodes.getLength(); i++) {
				long newValue = this.androidIdHexStringToLong(this.getAndroidIdHexStringFromNode(nodes.item(i)));
				if (newValue > currentValue) {
					currentValue = newValue;
				}
			}
			return  currentValue;
		}

	}

}
