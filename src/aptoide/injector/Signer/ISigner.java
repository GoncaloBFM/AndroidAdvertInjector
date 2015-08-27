package aptoide.injector.Signer;


public interface ISigner {
	public String sign(String apk, String destination) throws SignerException;
}
