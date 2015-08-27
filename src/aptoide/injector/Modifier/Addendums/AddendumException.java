package aptoide.injector.Modifier.Addendums;

import javax.xml.transform.TransformerException;

/**
 * Created by gbfm on 8/21/15.
 */
public class AddendumException extends Exception {
	public AddendumException(Exception e) {
		super(e);
	}

	public AddendumException(String s) {
		super(s);
	}

	public AddendumException(String s, Exception e) {
		super(s, e);
	}
}
