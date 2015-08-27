package aptoide.injector.Modifier.Loaders;

/**
 * Created by gbfm on 8/26/15.
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
