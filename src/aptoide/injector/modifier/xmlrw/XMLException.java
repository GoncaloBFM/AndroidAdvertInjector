package aptoide.injector.modifier.xmlrw;

/**
 * Generic XML exception
 *
 * @author      Gonçalo M.
 */
public class XMLException extends RuntimeException {
	public XMLException(Exception e) {
		super(e);
	}

	public XMLException(String s, Exception e) {
		super(s, e);
	}

	public XMLException(String s) {
		super(s);
	}
}
