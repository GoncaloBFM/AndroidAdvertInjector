package aptoide.injector.Signer;

/**
 * Created by gbfm on 8/14/15.
 */
public interface ISigner {
	public String sign(String apk, String destination) throws SignerException;
}
