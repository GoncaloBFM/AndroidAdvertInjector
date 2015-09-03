package aptoide.injector.modifier.loaders;

import aptoide.injector.modifier.xmlrw.IXMLParser;
import aptoide.injector.modifier.xmlrw.XMLException;
import aptoide.injector.modifier.xmlrw.XMLParser;
import aptoide.injector.modifier.xmlrw.XMLPathException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;

/**
 * Basic values loader class (can be used for storing settings)
 * Loads values from a XML file
 * The XML file can only be composed of a root node
 * (name or properties of the root node are not important) and
 * its nodes, each corresponding to a pair key value formed by the properties
 * 'name' and 'value' respectively (node names are also not important)
 *
 *
 * @author      Gonçalo M.
 */
public class ValuesLoader implements ILoader {

	private static final String VALUES_NODES  = "/*/*";

	private static final String NAME_ATTRIBUTE = "name";
	private static final String VALUE_ATTRIBUTE = "value";

	private IXMLParser configFile;

	/**
	 * Creates a new ValuesLoader based on a XML file
	 * (for more information on the structure of the XML file read the header)
	 * @param valuesFilePath path to the XML file to read
	 * @throws LoaderException Could not load values file
	 */
	public ValuesLoader(String valuesFilePath) throws LoaderException {
		try {
			this.configFile = new XMLParser(valuesFilePath);
		} catch (XMLException e) {
			throw new LoaderException("Could not load values file", e);
		}
	}

	@Override
	public  HashMap<String, String> loadValues() throws LoaderException {
		NodeList configurationNodes;
		HashMap<String, String> result = new HashMap<String, String>();
		try {
			configurationNodes = this.configFile.getNodes(VALUES_NODES);
		} catch (XMLPathException e) {
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
