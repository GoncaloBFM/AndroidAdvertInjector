package aptoide.injector.modifier.addendums;

import aptoide.injector.modifier.xmlrw.IXMLParser;
import aptoide.injector.modifier.xmlrw.XMLException;
import aptoide.injector.modifier.xmlrw.XMLParser;

/**
 * Abstract base class for parsing addendum files
 * An addendum file is a file used to discriminate the change that have to be done to one or more files
 *
 * @author      Gonçalo M.
 */
public abstract class BaseAddendum implements IAddendum {
	protected static final String ADDENDUM_NODES = "/*/*";

	protected IXMLParser addendum;
	protected String path;

	/**
	 * Loads the addendum file and the root path to the files to modify
	 * @param addendumFile Addendum file
	 * @param path Path to the files to modify
	 * @throws AddendumException Could not load addendum file
	*/
	public BaseAddendum(String addendumFile, String path) throws AddendumException {
		try {
			this.addendum = new XMLParser(addendumFile);
		} catch (XMLException e) {
			throw new AddendumException("Could not load addendum file", e);
		}

		this.path = path;
	}

	/**
	 * Returns the addendum file
	 * @return The addendum file
	 */
	public String getAddendumFile() {
		return this.addendum.getFilePath();
	}
}
