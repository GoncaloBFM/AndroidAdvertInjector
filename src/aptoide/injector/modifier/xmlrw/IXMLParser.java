package aptoide.injector.modifier.xmlrw;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * XML parser interface
 *
 * @author      Gonçalo M.
 */
public interface IXMLParser {

	/**
	 * Returns a list of nodes that match a XPath expression
	 * @param path XPath used to search for the nodes
	 * @return The list of nodes that match a XPath expression
	 * @throws XMLPathException Malformed XPath expression
	 */
	NodeList getNodes(String path) throws XMLPathException;

	/**
	 * Return the node that matches the XPath expression
	 * @param path XPath used to search for the node
	 * @return The node that matches the XPath expression
	 * @throws XMLPathException Malformed XPath expression
	 */
	Node getNode(String path) throws XMLPathException;

	/**
	 * Return the String that matches the XPath expression (used to get
	 * @param path XPath used to search for the node
	 * @return The node that matches the XPath expression
	 * @throws XMLPathException Malformed XPath expression
	 */
	String getString(String path) throws XMLPathException;

	/**
	 * Returns the file path for the file being parsed
	 * @return The file path for the file being parsed
	 */
	String getFilePath();
}
