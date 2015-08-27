package aptoide.injector.Signer;

import aptoide.injector.Decompiler.DecompilerException;
import aptoide.injector.ExternalProcessor.ExternalProcessException;
import aptoide.injector.ExternalProcessor.ExternalProcessor;
import aptoide.injector.ExternalProcessor.LogType;
import aptoide.injector.Paths;

import java.time.chrono.IsoChronology;

/**
 * Apk signer
 *
 * @author      Gonçalo M.
 */
public class Signer implements ISigner{

	private static final String SIGNER_FULL_PATH = Paths.SIGNER_FULL_PATH;
	private static final String PEM_FULL_PATH = Paths.PEM_FULL_PATH;
	private static final String PK8_FULL_PATH = Paths.PK8_FULL_PATH;

	private static final LogType LOG_TYPE = LogType.COMPLETE;

	@Override
	public String sign(String apk, String destination) throws SignerException {
		ProcessBuilder process = new ProcessBuilder("java", "-jar", SIGNER_FULL_PATH, PEM_FULL_PATH, PK8_FULL_PATH, apk, destination);
		try {
			return ExternalProcessor.execute(process, LOG_TYPE);
		} catch (ExternalProcessException e) {
			throw new SignerException(e);
		}
	}

}
