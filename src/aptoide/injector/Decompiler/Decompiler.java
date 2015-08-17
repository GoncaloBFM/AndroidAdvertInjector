package aptoide.injector.Decompiler;

import aptoide.injector.ExternalProcessor.ExternalProcessException;
import aptoide.injector.ExternalProcessor.ExternalProcessor;
import aptoide.injector.ExternalProcessor.LogType;
import aptoide.injector.Paths;

/**
 * Created by gbfm on 8/10/15.
 */

public class Decompiler implements IDecompiler {

	private static final String DECOMPILER_PATH = Paths.COMPILER_DIRECTORY;
	private static final String DECOMPILER = Paths.COMPILER_FULL_PATH;

	private static final LogType LOG_TYPE = LogType.COMPLETE;

	@Override
	public String decompile(String apk, String destination) throws DecompilerException {
		ProcessBuilder process = new ProcessBuilder(DECOMPILER, "d", "-f", "-o", destination, "-p", DECOMPILER_PATH, apk);
		try {
			return ExternalProcessor.execute(process, LOG_TYPE);
		} catch (ExternalProcessException e) {
			throw new DecompilerException(e);
		}
	}

}
