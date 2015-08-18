package aptoide.injector.Modifier;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

/**
 * Created by gbfm on 8/18/15.
 */
public interface IXMLParser {

	NodeList getNodes(String path) throws XPathExpressionException;

	Node getNode(String path) throws XPathExpressionException;

	String getString(String path) throws XPathExpressionException;
}
