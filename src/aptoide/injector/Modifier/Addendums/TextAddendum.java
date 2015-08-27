package aptoide.injector.Modifier.Addendums;

import aptoide.injector.Modifier.TextRW.ITextParser;
import aptoide.injector.Modifier.TextRW.ITextRW;
import aptoide.injector.Modifier.TextRW.TextParser;
import aptoide.injector.Modifier.TextRW.TextRW;
import aptoide.injector.Modifier.XMLRW.IXMLParser;
import aptoide.injector.Modifier.XMLRW.XMLParser;
import aptoide.injector.Modifier.XMLRW.XMLRW;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.jar.Attributes;

/**
 * Created by gbfm on 8/19/15.
 */
public class TextAddendum extends BaseAddendum implements IAddendum{

	private static final String MODIFICATION_ADD_NODE = "add";
	private static final String MODIFICATION_REMOVE_NODE = "remove";
	private static final String MODIFICATION_REPLACE_NODE = "replace";

	protected ITextRW targetFile;

	private static final String TYPE_ATTRIBUTE_NAME = "type";
	private static final String TYPE_TEXT = "text";
	private static final String TYPE_REGEX = "regex";

	private static final String WHERE_ATTRIBUTE_NAME = "where";
	private static final String WHERE_BOTTOM = "bottom";
	private static final String WHERE_TOP = "top";

	private static final String LOOKUP_ATTRIBUTE_NAME = "lookup";
	private static final String CONTENT_ATTRIBUTE_NAME = "content";

	private enum Type{IS_REGEX, IS_TEXT};
	private enum Where{BOTTOM, TOP};

	private static final String ADDENDUM_TARGET_FILE_XPATH = "/*/@file";

	private String pathToResourceFiles;

	public TextAddendum(String addendumFile, String pathToResourceFiles, String path) throws AddendumException {
		super(addendumFile, path);
		try {
			this.targetFile = new TextRW(this.path + File.separator + this.addendum.getString(ADDENDUM_TARGET_FILE_XPATH));
		} catch (Exception e) {
			throw new AddendumException("Could not load target file", e);
		}
		this.pathToResourceFiles = pathToResourceFiles;
	}

	@Override
	public String getTargetFile() {
		return this.targetFile.getFile().getAbsolutePath();
	}

	@Override
	public void writeChanges() throws AddendumException {
		try {
			this.targetFile.writeFile();
		} catch (IOException e) {
			throw new AddendumException(e);
		}
	}

	@Override
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

	private void modificationSelector(Node node) throws XPathException, IOException, SAXException, AddendumException {
		String modificationType = node.getNodeName();
		NamedNodeMap attributes = node.getAttributes();

		if (modificationType.equals(MODIFICATION_ADD_NODE)) {
			String type = attributes.getNamedItem(TYPE_ATTRIBUTE_NAME).getNodeValue();
			String lookup = attributes.getNamedItem(LOOKUP_ATTRIBUTE_NAME).getNodeValue();
			this.addText(type, lookup);

		} else if (modificationType.equals(MODIFICATION_REMOVE_NODE)) {
			String where = attributes.getNamedItem(WHERE_ATTRIBUTE_NAME).getNodeValue();
			String content = attributes.getNamedItem(CONTENT_ATTRIBUTE_NAME).getNodeValue();
			this.removeText(where, content);

		} else if (modificationType.equals(MODIFICATION_REPLACE_NODE)) {
			String type = attributes.getNamedItem(TYPE_ATTRIBUTE_NAME).getNodeValue();
			String lookup = attributes.getNamedItem(LOOKUP_ATTRIBUTE_NAME).getNodeValue();
			String content = attributes.getNamedItem(CONTENT_ATTRIBUTE_NAME).getNodeValue();
			this.replaceText(type, lookup, content);
		}
	}

	private void removeText(String typeAttribute, String lookupAttribute) throws AddendumException {
		Type type = this.parseTypeAttribute(typeAttribute);
		ITextParser lookup;
		try {
			lookup = new TextParser(this.pathToResourceFiles + File.separator + lookupAttribute);
		} catch (IOException e) {
			throw new AddendumException("Could not open lookup file " + lookupAttribute, e);
		}
		this.targetFile.removeFileContent(lookup.getCurrentFileContent(), type.equals(Type.IS_REGEX));
	}

	private void addText(String whereAttribute, String contentAttribute) throws AddendumException {
		Where where = this.parseWhereAttribute(whereAttribute);
		ITextParser content;
		try {
			content = new TextParser(this.pathToResourceFiles + File.separator + contentAttribute);
		} catch (IOException e) {
			throw new AddendumException("Could not open lookup file " + contentAttribute, e);
		}

		if (where.equals(Where.BOTTOM)) {
			this.targetFile.appendToFileContent(content.getCurrentFileContent());
		} else if (where.equals(Where.TOP)) {
			this.targetFile.prependToFileContent(content.getCurrentFileContent());
		}
	}

	private void replaceText(String typeAttribute, String lookupAttribute, String contentAttribute) throws AddendumException {
		Type type = this.parseTypeAttribute(typeAttribute);
		ITextParser lookup;
		ITextParser content;
		try {
			lookup = new TextParser(this.pathToResourceFiles + File.separator + lookupAttribute);
			content = new TextParser(this.pathToResourceFiles + File.separator + contentAttribute);
		} catch (IOException e) {
			throw new AddendumException("Could not open lookup file " + lookupAttribute + " or ", e);
		}
		this.targetFile.replaceFileContent(lookup.getCurrentFileContent(), content.getCurrentFileContent(), type.equals(Type.IS_REGEX));
	}

	private Type parseTypeAttribute(String type) throws AddendumException {
		if (type.equals(TYPE_REGEX)) {
			return Type.IS_REGEX;
		} else if(type.equals(TYPE_TEXT)) {
			return Type.IS_TEXT;
		} else {
			throw new AddendumException("'" + TYPE_ATTRIBUTE_NAME + "' " + "attribute can only have the values '" + TYPE_REGEX + "' or '" + TYPE_TEXT + "'");
		}
	}

	private Where parseWhereAttribute(String where) throws AddendumException {
		if (where.equals(WHERE_BOTTOM)) {
			return Where.BOTTOM;
		} else if(where.equals(WHERE_TOP)) {
			return Where.TOP;
		} else {
			throw new AddendumException("'" + WHERE_ATTRIBUTE_NAME + "' " + "attribute can only have the values '" + WHERE_BOTTOM + "' or '" + WHERE_TOP + "'");
		}
	}
}
