package aptoide.injector.Recompiler;

import aptoide.injector.ExternalProcessor.ExternalProcessException;
import aptoide.injector.ExternalProcessor.ExternalProcessor;
import aptoide.injector.ExternalProcessor.LogType;
import aptoide.injector.Paths;

/**
 * Created by gbfm on 8/13/15.
 */
public class Recompiler implements IRecompiler {

	private static final String DECOMPILER_PATH = Paths.COMPILER_DIRECTORY;
	private static final String RECOMPILER = Paths.COMPILER_FULL_PATH;

	private static final LogType LOG_TYPE = LogType.COMPLETE;

	@Override
	public String recompile(String decompiled, String destination) throws RecompilerException {
		ProcessBuilder process = new ProcessBuilder(RECOMPILER, "b", "-f", "-o", destination, "-p", DECOMPILER_PATH, decompiled);
		try {
			return ExternalProcessor.execute(process, LOG_TYPE);
		} catch (ExternalProcessException e) {
			throw new RecompilerException(e);
		}
	}
}
