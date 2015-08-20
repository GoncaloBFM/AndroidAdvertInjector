package aptoide.injector.Modifier;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;

/**
 * Created by gbfm on 8/19/15.
 */
public class AndroidCodeRW extends TextRW{

	private static final String MANIFEST_ADDENDUM_NODES = "/*/*";
	private static final String MODIFICATION_ADD_NODE = "add";
	private static final String MODIFICATION_REMOVE_NODE = "remove";
	private static final String MODIFICATIO_REPLACE_NODE = "replace";

	public AndroidCodeRW(String file) throws IOException {
		super(file);
	}

	//@Override
	public void parseCodeAddendum(String codeAddendumFile) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		IXMLParser addendum = new XMLParser(codeAddendumFile);
		NodeList addendumNones = addendum.getNodes(MANIFEST_ADDENDUM_NODES);
		for (int i = 0; i < addendumNones.getLength(); i++) {
			Node node = addendumNones.item(i);
			//this.modificationSelector(node);
		}
	}

	private void modificationSelector(Node node) throws XPathExpressionException, ManifestAddendumException, IOException, SAXException {
		String type = node.getNodeName();
		//String xpath = this.getXPathAttribute(node);
		if (type.equals(MODIFICATION_ADD_NODE)) {
			//this.addNodesToManifest(node.getChildNodes(), xpath);
		} else if (type.equals(MODIFICATION_REMOVE_NODE)) {
			//this.removeNodesFromManifest(xpath);
		} else if (type.equals(MODIFICATIO_REPLACE_NODE)) {
			//this.replaceNodesFromManifest(node.getChildNodes(), xpath);
		}
	}

	private void addCodeToFile() {

	}

	private void removeCodeFromFile() {

	}

	private void replaceCodeInFile() {

	}

}
