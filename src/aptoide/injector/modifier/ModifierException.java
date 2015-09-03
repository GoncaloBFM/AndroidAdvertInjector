package aptoide.injector.modifier;

import aptoide.injector.modifier.loaders.LoaderException;

/**
 * Used when the Modifier could not apply all the modifications
 *
 * @author      Gonçalo M.
 */
public class ModifierException extends RuntimeException {
	public ModifierException(String s) {
		super(s);
	}

	public ModifierException(String s, Exception e) {
		super(s, e);
	}

	public ModifierException(LoaderException e) {
		super(e);
	}
}
