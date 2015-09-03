package aptoide.injector.signer;

/**
 * Used when the APK signer fails
 *
 * @author      Gonçalo M.
 */
public class SignerException extends RuntimeException{
	public SignerException(String s) {
		super(s);
	}
	public SignerException(String s, Exception e) {
		super(s, e);
	}

}
