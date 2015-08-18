package aptoide.injector.Modifier;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;

/**
 * Created by gbfm on 8/12/15.
 */
public interface IXMLRW {

	void writeChanges() throws TransformerException;

	void addNodes(NodeList nodeList, Node parentNode, boolean addedNodesAreFromOtherDocument) throws IOException, SAXException, XPathExpressionException;

	void removeNode(Node node) throws ManifestAddendumException;

	Node importNode(Node node);

	void replaceNodes(NodeList nodesToAdd, Node nodeToRemove, boolean addedNodesAreFromOtherDocument) throws ManifestAddendumException;
}
