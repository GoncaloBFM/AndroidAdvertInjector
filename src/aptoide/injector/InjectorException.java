package aptoide.injector;

/**
 * Used when the code injector fails
 *
 * @author      Gonçalo M.
 */
public class InjectorException extends RuntimeException {
	public InjectorException(String s, Exception e) {
		super(s, e);
	}
}
