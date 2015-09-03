package aptoide.injector.recompiler;

/**
 * Used when the APK recompiler fails
 *
 * @author      Gonçalo M.
 */
public class RecompilerException extends RuntimeException {
	public RecompilerException(String s) {
		super(s);
	}

	public RecompilerException(String s, Exception e) {
		super(s, e);
	}
}
