package aptoide.injector.modifier.addendums;

import aptoide.injector.modifier.xmlrw.IXMLRW;
import aptoide.injector.modifier.xmlrw.XMLException;

/**
 * Abstract base class for parsing XML addendums
 * An XML addendum file is a file used to discriminate the change that have to be done to one or more XML files
 *
 * @author      Gonçalo M.
 */
public abstract class BaseXMLAddendum extends BaseAddendum implements IAddendum {

	protected IXMLRW targetFile;

	/**
	 * Loads the addendum file and the root path to the files to modify
	 * @param addendumFile Addendum file
	 * @param path Path to the files to modify
	 * @throws AddendumException Could not load addendum file
	 */
	public BaseXMLAddendum(String addendumFile, String path) throws AddendumException {
		super(addendumFile, path);
	}

	@Override
	public String getTargetFile() {
		return this.targetFile.getFilePath();
	}


	@Override
	public void writeChanges() throws AddendumException {
		try {
			this.targetFile.writeChanges();
		} catch (XMLException e) {
			throw new AddendumException(e);
		}
	}
}
