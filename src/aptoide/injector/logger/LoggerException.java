package aptoide.injector.logger;

/**
 * Used when the logger setup failed
 *
 * @author      Gonçalo M.
 */
public class LoggerException extends RuntimeException {
	public LoggerException(String s) {
		super(s);
	}

	public LoggerException(String s, Exception e) {
		super(s, e);
	}
}
