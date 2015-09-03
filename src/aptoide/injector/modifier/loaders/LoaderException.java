package aptoide.injector.modifier.loaders;

/**
 * Exception thrown a loader fails the task of parsing the file or retrieving its contents
 *
 * @author      Gonçalo M.
 */
public class LoaderException extends Exception{

	public LoaderException(Exception e) {
		super(e);
	}

	public LoaderException(String s) {
		super(s);
	}

	public LoaderException(String s, Exception e) {
		super(s, e);
	}
}
