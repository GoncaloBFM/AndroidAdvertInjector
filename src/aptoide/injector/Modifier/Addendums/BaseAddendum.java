package aptoide.injector.Modifier.Addendums;

import aptoide.injector.Modifier.TextRW.TextRW;
import aptoide.injector.Modifier.XMLRW.IXMLParser;
import aptoide.injector.Modifier.XMLRW.XMLParser;

import java.io.File;

/**
 * Created by gbfm on 8/21/15.
 */
public abstract class BaseAddendum implements IAddendum {
	protected static final String ADDENDUM_NODES = "/*/*";

	protected IXMLParser addendum;
	protected String path;

	public BaseAddendum(String addendumFile, String path) throws AddendumException {
		try {
			this.addendum = new XMLParser(addendumFile);
		} catch (Exception e) {
			throw new AddendumException("Could not load addendum file", e);
		}

		this.path = path;
	}

	public String getAddendumFile() {
		return this.addendum.getFilePath();
	}
}
