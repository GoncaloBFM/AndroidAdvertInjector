package aptoide.injector.Modifier;

import aptoide.injector.Modifier.IXMLRW;
import aptoide.injector.Modifier.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;

/**
 * Created by gbfm on 8/12/15.
 */
public abstract class XMLRW extends XMLParser implements IXMLRW {

	protected static final String XPATH_TO_ADD_NODES = "/*/*";

	public XMLRW(String pathToPublicIdFile) throws IOException, SAXException, ParserConfigurationException {
		super(pathToPublicIdFile);
	}


	public void writeChanges() throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(this.document), new StreamResult(new File(this.filePath)));
	}

	protected void insertNodesFromFile(String filePath, Node parentNode) throws IOException, SAXException, XPathExpressionException {
		Document addendum = this.builder.parse(filePath);
		NodeList nodes = (NodeList) this.xpath.compile(XPATH_TO_ADD_NODES).evaluate(addendum, XPathConstants.NODESET);
		for (int i = 0; i < nodes.getLength(); i++) {
			Node importedNode = this.document.importNode(nodes.item(i), true);
			parentNode.appendChild(importedNode);
		}
	}
}


