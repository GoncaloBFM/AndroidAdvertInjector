package aptoide.injector.Modifier.Loaders;

import aptoide.injector.Modifier.Addendums.AddendumException;
import aptoide.injector.Modifier.XMLRW.IXMLParser;
import aptoide.injector.Modifier.XMLRW.XMLParser;
import aptoide.injector.Modifier.XMLRW.XMLRW;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gbfm on 8/26/15.
 */
public class ConfigurationsLoader implements ILoader {

	private static final String CONFIGURATION_NODES  = "/*/*";

	private static final String NAME_ATTRIBUTE = "name";
	private static final String VALUE_ATTRIBUTE = "value";

	private IXMLParser configFile;

	public ConfigurationsLoader(String configFilePath) throws LoaderException {
		try {
			this.configFile = new XMLParser(configFilePath);
		} catch (Exception e) {
			throw new LoaderException("Could not load configuration file", e);
		}
	}

	@Override
	public  HashMap<String, String> loadValues() throws LoaderException {
		NodeList configurationNodes = null;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			configurationNodes = this.configFile.getNodes(CONFIGURATION_NODES);
		} catch (XPathExpressionException e) {
			throw new LoaderException("Could not get loader nodes", e);
		}

		for (int i = 0; i < configurationNodes.getLength(); i++) {
			Node node = configurationNodes.item(i);
			NamedNodeMap attributes = node.getAttributes();
			result.put(attributes.getNamedItem(NAME_ATTRIBUTE).getNodeValue(), attributes.getNamedItem(VALUE_ATTRIBUTE).getNodeValue());
		}
		return result;
	}

}
