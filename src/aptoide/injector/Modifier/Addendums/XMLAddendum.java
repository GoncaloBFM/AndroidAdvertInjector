package aptoide.injector.Modifier.Addendums;

/**
 * Created by gbfm on 8/11/15.
 */
import aptoide.injector.Modifier.XMLRW.*;
import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.xpath.*;
import java.io.*;
import java.util.LinkedList;

public class XMLAddendum  extends BaseXMLAddendum implements IAddendum {

	private static final String ADDENDUM_TARGET_FILE_XPATH = "/*/@file";

	private static final String MODIFICATION_ADD_NODE = "add";
	private static final String MODIFICATION_REMOVE_NODE = "remove";
	private static final String MODIFICATION_REPLACE_NODE = "replace";

	private static final String XPATH_ATTRIBUTE = "xpath";

	public XMLAddendum(String addendumFile, String path) throws AddendumException {
		super(addendumFile, path);
		try {
			this.targetFile = new XMLRW(this.path + File.separator + this.addendum.getString(ADDENDUM_TARGET_FILE_XPATH));
		} catch (Exception e) {
			throw new AddendumException("Could not load target file", e);
		}
	}

	public LinkedList<Node> apply() throws AddendumException{
		NodeList addendumNones = null;
		LinkedList<Node> result = new LinkedList<Node>();
		try {
			addendumNones = this.addendum.getNodes(ADDENDUM_NODES);
		} catch (XPathExpressionException e) {
			throw new AddendumException("Could not get addendum nodes", e);
		}

		for (int i = 0; i < addendumNones.getLength(); i++) {
			Node node = addendumNones.item(i);
			result.add(node);
			try {
				this.modificationSelector(node);
			} catch (Exception e) {
				throw new AddendumException("Could not apply entry no." + i, e);
			}
		}
		return result;
	}

	private void modificationSelector(Node node) throws XPathException, IOException, SAXException {
		String type = node.getNodeName();
		String xpath = node.getAttributes().getNamedItem(XPATH_ATTRIBUTE).getNodeValue();
		if (type.equals(MODIFICATION_ADD_NODE)) {
			this.targetFile.addNodesToPath(node.getChildNodes(), xpath);
		} else if (type.equals(MODIFICATION_REMOVE_NODE)) {
			this.targetFile.removeNodesInPath(xpath);
		} else if (type.equals(MODIFICATION_REPLACE_NODE)) {
			this.targetFile.replaceNodesInPath(node.getChildNodes(), xpath);
		}
	}


}