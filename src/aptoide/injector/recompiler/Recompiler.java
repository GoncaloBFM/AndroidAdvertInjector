package aptoide.injector.recompiler;

import aptoide.injector.Paths;
import aptoide.injector.external_processor.ExternalProcessor;
import aptoide.injector.external_processor.ExternalProcessorException;

/**
 * Apk recompiler using ApkTool 2.0.1 (@link http://ibotpeaches.github.io/Apktool/)
 * The recompiler only works on Java 7 (JRE 1.7) or higher
 *
 * @author      Gonçalo M.
 */
public class Recompiler implements IRecompiler {

	private static final String DECOMPILER_PATH = Paths.COMPILER_DIRECTORY;
	private static final String RECOMPILER = Paths.COMPILER_FULL_PATH;

	@Override
	public void recompile(String decompiled, String destination) throws RecompilerException {
		ProcessBuilder process = new ProcessBuilder(RECOMPILER, "b", "-f", "-o", destination, "-p", DECOMPILER_PATH, decompiled);
		try {
			ExternalProcessor.execute(process, Recompiler.class.getSimpleName());
		} catch (ExternalProcessorException e) {
			throw new RecompilerException("Could not recompile the APK", e);
		}
	}
}
