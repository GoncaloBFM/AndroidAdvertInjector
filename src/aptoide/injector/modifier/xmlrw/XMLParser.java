package aptoide.injector.modifier.xmlrw;

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

	public XMLParser(String pathToXML) throws XMLDocumentException {

		this.filePath = pathToXML;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			this.document = this.builder.parse(this.filePath);
		} catch (IOException | SAXException | ParserConfigurationException e) {
			throw new XMLDocumentException("Could not load xml file", e);
		}
		XPathFactory xPathfactory = XPathFactory.newInstance();
		this.xpath = xPathfactory.newXPath();

	}

	@Override
	public NodeList getNodes(String path) throws XMLPathException {
		try {
			return (NodeList) this.xpath.compile(path).evaluate(this.document, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new XMLPathException("Could not get nodes from path \n" + path + "\non file\n" + this.filePath, e);
		}
	}

	@Override
	public Node getNode(String path) throws XMLPathException {
		try {
			return (Node) this.xpath.compile(path).evaluate(this.document, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			throw new XMLPathException("Could not get node from path \n" + path + "\non file\n" + this.filePath, e);
		}
	}

	@Override
	public String getString(String path) throws XMLPathException {
		try {
			return (String) this.xpath.compile(path).evaluate(this.document, XPathConstants.STRING);
		} catch (XPathExpressionException e) {
			throw new XMLPathException("Could not get string from path \n" + path + "\non file\n" + this.filePath, e);
		}
	}

	@Override
	public String getFilePath() {
		return this.filePath;
	}
}
