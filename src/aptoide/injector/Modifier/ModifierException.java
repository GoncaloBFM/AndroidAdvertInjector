package aptoide.injector.Modifier;

/**
 * Created by gbfm on 8/11/15.
 */
public class ModifierException extends Exception {
	public ModifierException(String s) {
		super(s);
	}

	public ModifierException(String s, Exception e) {
		super(s, e);
	}
}
