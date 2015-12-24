package aptoide.injector.modifier.xmlrw;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * XML reader/writer interface
 *
 * @author      Gonçalo M.
 */
public class XMLRW extends XMLParser implements IXMLRW {

	public XMLRW(String pathToPublicIdFile) throws XMLDocumentException {
		super(pathToPublicIdFile);
	}

	@Override
	public void writeChanges() throws XMLDocumentException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(this.document), new StreamResult(new File(this.filePath)));
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds nodes to a parent node
	 * @param nodeList Nodes to add
	 * @param parentNode Parent node to add the nodes to
	 * @param addedNodesAreFromOtherDocument True if the added nodes are from another document False if not
	 */
	protected void addNodes(NodeList nodeList, Node parentNode , boolean addedNodesAreFromOtherDocument) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nodeToAdd = nodeList.item(i);
			if (addedNodesAreFromOtherDocument) {
				nodeToAdd = this.document.importNode(nodeToAdd, true);
			}
			parentNode.appendChild(nodeToAdd);
		}
	}

	/**
	 * Removes a node from a document
	 * @param node Node to be removed
	 * @throws XMLPathException Could find parent of node to remove (node may be root)
	 */
	protected void removeNode(Node node) throws XMLPathException {
		Node parentNode = node.getParentNode();
		if (parentNode == null) {
			throw new XMLPathException("Couldn't remove the node because no parent node was found");
		}

		parentNode.removeChild(node);
	}

	@Override
	public Node importNode(Node node) {
		return this.document.importNode(node, true);
	}

	/**
	 * Replaces a node by a list of new nodes
	 * @param nodesToAdd New nodes
	 * @param nodeToRemove Node to be replaced
	 * @param addedNodesAreFromOtherDocument True if the added nodes are from another document False if not
	 * @throws XMLPathException Could find parent of node to remove (node may be root)
	 */
	protected void replaceNodes(NodeList nodesToAdd, Node nodeToRemove, boolean addedNodesAreFromOtherDocument) throws XMLPathException {
		Node parentNode = nodeToRemove.getParentNode();
		if (parentNode == null) {
			throw new XMLPathException("Couldn't replace the node because no parent node was found");
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

	@Override
	public void addNodesToPath(NodeList nodesToAppend, String parentNodePath) throws XMLPathException {
		NodeList parentNodes = this.getNodes(parentNodePath);
		for (int i = 0; i < parentNodes.getLength(); i++) {
			this.addNodes(nodesToAppend, parentNodes.item(i), true);
		}
	}

	@Override
	public void removeNodesInPath(String nodePath) throws  XMLPathException{
		NodeList nodeList = this.getNodes(nodePath);
		for (int i = 0; i < nodeList.getLength(); i++) {
			this.removeNode(nodeList.item(i));
		}
	}

	@Override
	public void replaceNodesInPath(NodeList nodesToAdd, String NodesToRemove) throws XMLPathException {
		NodeList removeList = this.getNodes(NodesToRemove);
		for (int i = 0; i < removeList.getLength(); i++) {
			this.replaceNodes(nodesToAdd, removeList.item(i), true);
		}
	}

}


