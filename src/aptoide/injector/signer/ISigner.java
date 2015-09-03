package aptoide.injector.signer;

/**
 * Apk signer interface
 *
 * @author      Gonçalo M.
 */
public interface ISigner {

	/**
	 * Creates a signed copy of an APK in a target directory
	 * @param apk Path to APK file to sign
	 * @param destination Destination for the signed APK
	 * @throws SignerException Could not sign the APK
	 */
	public void sign(String apk, String destination) throws SignerException;
}
