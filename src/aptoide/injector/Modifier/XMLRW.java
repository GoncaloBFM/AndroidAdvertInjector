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
public class XMLRW extends XMLParser implements IXMLRW {

	public XMLRW(String pathToPublicIdFile) throws IOException, SAXException, ParserConfigurationException {
		super(pathToPublicIdFile);
	}

	@Override
	public void writeChanges() throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.transform(new DOMSource(this.document), new StreamResult(new File(this.filePath)));
	}

	@Override
	public void addNodes(NodeList nodeList, Node parentNode , boolean addedNodesAreFromOtherDocument) throws IOException, SAXException, XPathExpressionException {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nodeToAdd = nodeList.item(i);
			if (addedNodesAreFromOtherDocument) {
				nodeToAdd = this.document.importNode(nodeToAdd, true);
			}
			parentNode.appendChild(nodeToAdd);
		}
	}

	@Override
	public void removeNode(Node node) throws ManifestAddendumException {
		Node parentNode = node.getParentNode();
		if (parentNode == null) {
			throw new ManifestAddendumException("Couldn't remove the node because no parent node was found");
		}

		parentNode.removeChild(node);
	}

	@Override
	public Node importNode(Node node) {
		return this.document.importNode(node, true);
	}

	@Override
	public void replaceNodes(NodeList nodesToAdd, Node nodeToRemove, boolean addedNodesAreFromOtherDocument) throws ManifestAddendumException {
		Node parentNode = nodeToRemove.getParentNode();
		if (parentNode == null) {
			throw new ManifestAddendumException("Couldn't replace the node because no parent node was found");
		}

		parentNode.removeChild(nodeToRemove);
		for (int i = 0; i < nodesToAdd.getLength(); i++) {
			Node nodeToAdd = nodesToAdd.item(i);
			if (addedNodesAreFromOtherDocument) {
				nodeToAdd = this.document.importNode(nodeToAdd, true);
			}
			parentNode.appendChild(nodeToAdd);
		}
	}
}


