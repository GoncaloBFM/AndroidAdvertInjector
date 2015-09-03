package aptoide.injector.modifier.addendums;

/**
 * Used when an addendum file could not be loaded or its modifications could not be applied
 *
 * @author      Gonçalo M.
 */
public class AddendumException extends RuntimeException {
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
