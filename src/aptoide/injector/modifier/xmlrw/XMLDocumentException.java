package aptoide.injector.modifier.xmlrw;

/**
 * Exception thrown when a document is not found or could not be
 *
 * @author      Gonçalo M.
 */
public class XMLDocumentException extends XMLException{
	public XMLDocumentException(Exception e) {
		super(e);
	}

	public XMLDocumentException(String s, Exception e) {
		super(s, e);
	}
}
