package aptoide.injector.Modifier.XMLRW;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * XML reader/writer interface
 *
 * @author      Gonçalo M.
 */
public interface IXMLRW extends IXMLParser{

	/**
	 * Writes the update content to the file
	 * @throws TransformerException Could not write changes to file
	 */
	void writeChanges() throws TransformerException;

	/**
	 * Imports a node from another document to this one (this
	 * has to be done if a node from another document is going
	 * to me put in this one)
	 * @param node Node to import
	 * @return The imported version of the node
	 */
	Node importNode(Node node);

	/**
	 * Add nodes as child nodes to any nodes pointed by the XPath expression
	 * (the added nodes can be from another document)
	 * @param nodesToAppend Nodes to append
	 * @param parentNodePath XPath to the parent nodes
	 * @throws XPathExpressionException Malformed XPath expression
	 */
	void addNodesToPath(NodeList nodesToAppend, String parentNodePath) throws XPathExpressionException;

	/**
	 * Remove all nodes and its children pointed by the XPath expression
	 * @param nodePath XPath to the nodes to remove
	 * @throws XPathExpressionException Malformed XPath expression
	 */
	void removeNodesInPath(String nodePath) throws XPathException;

	/**
	 * Replaces nodes pointed by the XPath expression by the given nodes
	 * (the added nodes can be from another document)
	 * @param nodesToAdd Nodes to add
	 * @param NodesToRemove XPath to the nodes to be removed
	 * @throws XPathExpressionException Malformed XPath expression
	 */
	void replaceNodesInPath(NodeList nodesToAdd, String NodesToRemove) throws XPathException;

}
