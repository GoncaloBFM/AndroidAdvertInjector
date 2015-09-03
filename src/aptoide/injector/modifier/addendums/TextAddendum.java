package aptoide.injector.modifier.addendums;

import aptoide.injector.modifier.textrw.*;
import aptoide.injector.modifier.xmlrw.XMLException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.LinkedList;

/**
 * Addendum parser for text files
 *
 * @author      Gonçalo M.
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

	private enum Type{IS_REGEX, IS_TEXT}
	private enum Where{BOTTOM, TOP}

	private static final String ADDENDUM_TARGET_FILE_XPATH = "/*/@file";

	private String pathToResourceFiles;

	/**
	 * Creates a TextAddendum based on an text addendum file, the root path to the resource files and the root path to the files to modify
	 * @param addendumFile Addendum file
	 * @param pathToResourceFiles Root path to the resource files
	 * @param path Root path to the files to modify
	 * @throws AddendumException Could not load addendum file
	 */
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
		} catch (FileException e) {
			throw new AddendumException(e);
		}
	}

	@Override
	public LinkedList<Node> apply() throws AddendumException{
		NodeList addendumNones = null;
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
			} catch (Exception e) {
				throw new AddendumException("Could not apply entry no." + i, e);
			}
		}
		return result;
	}

	/**
	 * Parses an addendum node, selects the type of modification the node points to and applies it
	 * @param node Node to parse
	 * @throws AddendumException Could not parse the node
	 */
	private void modificationSelector(Node node) throws  AddendumException {
		String modificationType = node.getNodeName();
		NamedNodeMap attributes = node.getAttributes();

		switch (modificationType) {
			case MODIFICATION_ADD_NODE: {
				String type = attributes.getNamedItem(TYPE_ATTRIBUTE_NAME).getNodeValue();
				String lookup = attributes.getNamedItem(LOOKUP_ATTRIBUTE_NAME).getNodeValue();
				this.addText(type, lookup);

				break;
			}
			case MODIFICATION_REMOVE_NODE: {
				String where = attributes.getNamedItem(WHERE_ATTRIBUTE_NAME).getNodeValue();
				String content = attributes.getNamedItem(CONTENT_ATTRIBUTE_NAME).getNodeValue();
				this.removeText(where, content);

				break;
			}
			case MODIFICATION_REPLACE_NODE: {
				String type = attributes.getNamedItem(TYPE_ATTRIBUTE_NAME).getNodeValue();
				String lookup = attributes.getNamedItem(LOOKUP_ATTRIBUTE_NAME).getNodeValue();
				String content = attributes.getNamedItem(CONTENT_ATTRIBUTE_NAME).getNodeValue();
				this.replaceText(type, lookup, content);
				break;
			}
		}
	}

	/**
	 * Uses the text contained in the file pointed to by the lookupFile and searches it in the target document,
	 * using the search type specified in the searchType. All matches are removed
	 * @param searchType Search type
	 * @param lookupFile Path to the file with the content to search for
	 * @throws AddendumException Could not remove content
	 */
	private void removeText(String searchType, String lookupFile) throws AddendumException {
		Type type = this.parseTypeAttribute(searchType);
		ITextParser lookup;
		try {
			lookup = new TextParser(this.pathToResourceFiles + File.separator + lookupFile);
		} catch (FileException e) {
			throw new AddendumException("Could not open lookup file " + lookupFile, e);
		}
		this.targetFile.removeFileContent(lookup.getCurrentFileContent(), type.equals(Type.IS_REGEX));
	}

	/**
	 * Adds the text contained in the file pointed to by the contentFile and ads it to the target document
	 * @param whereAdd Where to add the content
	 * @param contentFile Path to the file where the content to add resides
	 * @throws AddendumException Could not add content
	 */
	private void addText(String whereAdd, String contentFile) throws AddendumException {
		Where where = this.parseWhereAttribute(whereAdd);
		ITextParser content;
		try {
			content = new TextParser(this.pathToResourceFiles + File.separator + contentFile);
		} catch (FileException e) {
			throw new AddendumException("Could not open lookup file " + contentFile, e);
		}

		if (where.equals(Where.BOTTOM)) {
			this.targetFile.appendToFileContent(content.getCurrentFileContent());
		} else if (where.equals(Where.TOP)) {
			this.targetFile.prependToFileContent(content.getCurrentFileContent());
		}
	}

	/**
	 * Uses the text contained in the file pointed to by the lookupFile and searches it in the target document,
	 * using the search type specified in the searchType. All matches are replaced by the contents of the file pointed to by the contentFile
	 * @param lookupFile Path to the file with the content to search for
	 * @param contentFile Path to the file where the content to replace resides
	 * @throws AddendumException Could not replace the content
	 */
	private void replaceText(String searchType, String lookupFile, String contentFile) throws AddendumException {
		Type type = this.parseTypeAttribute(searchType);
		ITextParser lookup;
		ITextParser content;
		try {
			lookup = new TextParser(this.pathToResourceFiles + File.separator + lookupFile);
			content = new TextParser(this.pathToResourceFiles + File.separator + contentFile);
		} catch (FileException e) {
			throw new AddendumException("Could not open lookup file or content file", e);
		}
		this.targetFile.replaceFileContent(lookup.getCurrentFileContent(), content.getCurrentFileContent(), type.equals(Type.IS_REGEX));
	}

	/**
	 * Returns the type of search designated by the string
	 * @param type Type of search string to parse
	 * @return Type of search
	 * @throws AddendumException Could not parse the type of search
	 */
	private Type parseTypeAttribute(String type) throws AddendumException {
		switch (type) {
			case TYPE_REGEX:
				return Type.IS_REGEX;
			case TYPE_TEXT:
				return Type.IS_TEXT;
			default:
				throw new AddendumException("'" + TYPE_ATTRIBUTE_NAME + "' " + "attribute can only have the values '" + TYPE_REGEX + "' or '" + TYPE_TEXT + "'");
		}
	}

	/**
	 * Returns the where attribute designated by the string
	 * @param where Where attribute to parse
	 * @return Where pointer
	 * @throws AddendumException Could not parse the where attribute
	 */
	private Where parseWhereAttribute(String where) throws AddendumException {
		switch (where) {
			case WHERE_BOTTOM:
				return Where.BOTTOM;
			case WHERE_TOP:
				return Where.TOP;
			default:
				throw new AddendumException("'" + WHERE_ATTRIBUTE_NAME + "' " + "attribute can only have the values '" + WHERE_BOTTOM + "' or '" + WHERE_TOP + "'");
		}
	}
}
