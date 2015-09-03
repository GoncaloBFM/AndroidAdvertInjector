package aptoide.injector.modifier.xmlrw;

import javax.xml.xpath.XPathExpressionException;

/**
 * Exception thrown when a XPath expression is malformed
 *
 * @author      Gonçalo M.
 */
public class XMLPathException extends XMLException {
	public XMLPathException(Exception e) {
		super(e);
	}

	public XMLPathException(String s) {
		super(s);
	}

	public XMLPathException(String s, XPathExpressionException e) {
		super(s, e);
	}
}
