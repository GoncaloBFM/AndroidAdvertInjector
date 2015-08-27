package aptoide.injector.Modifier.XMLRW;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

/**
 * XML parser
 *
 * @author      Gonçalo M.
 */
public class XMLParser implements IXMLParser {

	protected Document document;
	protected XPath xpath;
	protected DocumentBuilder builder;
	protected String filePath;

	public XMLParser(String pathToPublicIdFile) throws IOException, SAXException, ParserConfigurationException {
		this.filePath = pathToPublicIdFile;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		this.builder = factory.newDocumentBuilder();
		this.document = this.builder.parse(this.filePath);
		XPathFactory xPathfactory = XPathFactory.newInstance();
		this.xpath = xPathfactory.newXPath();

	}

	@Override
	public NodeList getNodes(String path) throws XPathExpressionException {
		return (NodeList) this.xpath.compile(path).evaluate(this.document, XPathConstants.NODESET);
	}

	@Override
	public Node getNode(String path) throws XPathExpressionException {
		return (Node) this.xpath.compile(path).evaluate(this.document, XPathConstants.NODE);
	}

	@Override
	public String getString(String path) throws XPathExpressionException {
		return (String) this.xpath.compile(path).evaluate(this.document, XPathConstants.STRING);
	}

	@Override
	public String getFilePath() {
		return this.filePath;
	}
}
