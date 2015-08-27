package aptoide.injector.Modifier.Addendums;

import aptoide.injector.Modifier.XMLRW.IXMLParser;
import aptoide.injector.Modifier.XMLRW.IXMLRW;

import javax.xml.transform.TransformerException;

/**
 * Created by gbfm on 8/21/15.
 */
public abstract class BaseXMLAddendum extends BaseAddendum implements IAddendum {

	protected IXMLRW targetFile;

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
		} catch (TransformerException e) {
			throw new AddendumException(e);
		}
	}
}
