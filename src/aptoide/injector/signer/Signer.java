package aptoide.injector.signer;

import aptoide.injector.Paths;
import aptoide.injector.external_processor.ExternalProcessor;
import aptoide.injector.external_processor.ExternalProcessorException;

/**
 * Apk signer
 *
 * @author      Gonçalo M.
 */
public class Signer implements ISigner{

	private static final String SIGNER_FULL_PATH = Paths.SIGNER_FULL_PATH;
	private static final String PEM_FULL_PATH = Paths.PEM_FULL_PATH;
	private static final String PK8_FULL_PATH = Paths.PK8_FULL_PATH;

	@Override
	public void sign(String apk, String destination) throws SignerException {
		ProcessBuilder process = new ProcessBuilder("java", "-jar", SIGNER_FULL_PATH, PEM_FULL_PATH, PK8_FULL_PATH, apk, destination);
		try {
			ExternalProcessor.execute(process, Signer.class.getSimpleName());
		} catch (ExternalProcessorException e) {
			throw new SignerException("Could not sign the APK", e);
		}
	}

}
