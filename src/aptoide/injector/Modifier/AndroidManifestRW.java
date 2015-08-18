package aptoide.injector.Modifier;

/**
 * Created by gbfm on 8/11/15.
 */
import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;

public class AndroidManifestRW extends XMLRW implements IAndroidManifestRW {

	private static final String MAIN_ACTIVITY_FILE_NAME = "/manifest/application/activity/intent-filter/category[@name=\"android.intent.category.LAUNCHER\"]/../../@name";
	private static final String MANIFEST_ADDENDUM_NODES = "/*/*";

	private static final String MODIFICATION_ADD_NODE = "add";
	private static final String MODIFICATION_REMOVE_NODE = "remove";
	private static final String MODIFICATIO_REPLACE_NODE = "replace";
	private static final String XPATH_ATTRIBUTE = "xpath";


	public AndroidManifestRW(String manifest) throws IOException, SAXException, ParserConfigurationException {
		super(manifest);
	}

	@Override
	public String getMainActivityName() throws XPathExpressionException {
		return this.getString(MAIN_ACTIVITY_FILE_NAME);
	}

	@Override
	public void parseManifestAddendum(String manifestAddendumFile) throws XPathExpressionException, IOException, SAXException, ManifestAddendumException, ParserConfigurationException {
		IXMLParser addendum = new XMLParser(manifestAddendumFile);
		NodeList addendumNones = addendum.getNodes(MANIFEST_ADDENDUM_NODES);
		for (int i = 0; i < addendumNones.getLength(); i++) {
			Node node = addendumNones.item(i);
			this.modificationSelector(node);
		}
	}

	private void modificationSelector(Node node) throws XPathExpressionException, ManifestAddendumException, IOException, SAXException {
		String type = node.getNodeName();
		String xpath = this.getXPathAttribute(node);
		if (type.equals(MODIFICATION_ADD_NODE)) {
			this.addNodesToManifest(node.getChildNodes(), xpath);
		} else if (type.equals(MODIFICATION_REMOVE_NODE)) {
			this.removeNodesFromManifest(xpath);
		} else if (type.equals(MODIFICATIO_REPLACE_NODE)) {
			this.replaceNodesFromManifest(node.getChildNodes(), xpath);
		}
	}

	private String getXPathAttribute(Node node) {
		return node.getAttributes().getNamedItem(XPATH_ATTRIBUTE).getNodeValue();
	}

	private void addNodesToManifest(NodeList nodesToAppend, String parentNodePath) throws XPathExpressionException, IOException, SAXException {
		NodeList parentNodes = this.getNodes(parentNodePath);
		for (int i = 0; i < parentNodes.getLength(); i++) {
			this.addNodes(nodesToAppend, parentNodes.item(i), true);
		}
	}

	private void removeNodesFromManifest(String nodePath) throws XPathExpressionException, ManifestAddendumException {
		NodeList nodeList = this.getNodes(nodePath);
		for (int i = 0; i < nodeList.getLength(); i++) {
			this.removeNode(nodeList.item(i));
		}
	}

	private void replaceNodesFromManifest(NodeList nodesToAdd, String NodesToRemove) throws XPathExpressionException, ManifestAddendumException {
		NodeList removeList = this.getNodes(NodesToRemove);
		for (int i = 0; i < removeList.getLength(); i++) {
			this.replaceNodes(nodesToAdd, removeList.item(i), true);
		}
	}


}