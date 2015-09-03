package aptoide.injector.modifier.addendums;

import aptoide.injector.modifier.xmlrw.XMLException;
import aptoide.injector.modifier.xmlrw.XMLPathException;
import aptoide.injector.modifier.xmlrw.XMLRW;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.LinkedList;

/**
 * Addendum parser for text files
 *
 * @author      Gonçalo M.
 */
public class XMLAddendum  extends BaseXMLAddendum implements IAddendum {

	private static final String ADDENDUM_TARGET_FILE_XPATH = "/*/@file";

	private static final String MODIFICATION_ADD_NODE = "add";
	private static final String MODIFICATION_REMOVE_NODE = "remove";
	private static final String MODIFICATION_REPLACE_NODE = "replace";

	private static final String XPATH_ATTRIBUTE = "xpath";

	/**
	 * Creates a XMLAddendum based on an xml addendum file  and the root path to the files to modify
	 * @param addendumFile Addendum file
	 * @param path Root path to the files to modify
	 * @throws AddendumException Could not load addendum file
	 */
	public XMLAddendum(String addendumFile, String path) throws AddendumException {
		super(addendumFile, path);
		try {
			this.targetFile = new XMLRW(this.path + File.separator + this.addendum.getString(ADDENDUM_TARGET_FILE_XPATH));
		} catch (XMLException e) {
			throw new AddendumException("Could not load target file", e);
		}
	}

	@Override
	public LinkedList<Node> apply() throws AddendumException{
		NodeList addendumNones;
		LinkedList<Node> result = new LinkedList<Node>();
		try {
			addendumNones = this.addendum.getNodes(ADDENDUM_NODES);
		} catch (XMLException e) {
			throw new AddendumException("Could not get addendum nodes", e);
		}

		for (int i = 0; i < addendumNones.getLength(); i++) {
			Node node = addendumNones.item(i);
			result.add(node);
			try {
				this.modificationSelector(node);
			} catch (XMLException e) {
				throw new AddendumException("Could not apply entry no." + i, e);
			}
		}
		return result;
	}

	/**
	 * Parses an addendum node, selects the type of modification the node points to and applies it
	 * @param node Node to parse
	 * @throws XMLPathException Could not modify the target file according to the node specifications
	 */
	private void modificationSelector(Node node) throws XMLPathException {
		String type = node.getNodeName();
		String xpath = node.getAttributes().getNamedItem(XPATH_ATTRIBUTE).getNodeValue();
		switch (type) {
			case MODIFICATION_ADD_NODE:
				this.targetFile.addNodesToPath(node.getChildNodes(), xpath);
				break;
			case MODIFICATION_REMOVE_NODE:
				this.targetFile.removeNodesInPath(xpath);
				break;
			case MODIFICATION_REPLACE_NODE:
				this.targetFile.replaceNodesInPath(node.getChildNodes(), xpath);
				break;
		}
	}


}