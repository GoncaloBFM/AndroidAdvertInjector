package aptoide.injector.Modifier;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

/**
 * Created by gbfm on 8/12/15.
 */
public abstract class XMLParser {

	protected Document document;
	protected XPath xpath;
	protected DocumentBuilder builder;
	protected String filePath;

	public XMLParser(String pathToPublicIdFile) throws IOException, SAXException, ParserConfigurationException {
		this.filePath = pathToPublicIdFile;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		this.builder = factory.newDocumentBuilder();
		this.document = this.builder.parse(pathToPublicIdFile);
		XPathFactory xPathfactory = XPathFactory.newInstance();
		this.xpath = xPathfactory.newXPath();

	}
}
