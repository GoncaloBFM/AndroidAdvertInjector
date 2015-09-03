package aptoide.injector.decompiler;

import aptoide.injector.Paths;
import aptoide.injector.external_processor.ExternalProcessor;
import aptoide.injector.external_processor.ExternalProcessorException;

/**
 * Apk decompiler using ApkTool (@link http://ibotpeaches.github.io/Apktool/)
 * The decompiler only works on Java 7 (JRE 1.7) or higher
 *
 * @author      Gonçalo M.
 */
public class Decompiler implements IDecompiler {

	private static final String DECOMPILER_PATH = Paths.COMPILER_DIRECTORY;
	private static final String DECOMPILER = Paths.COMPILER_FULL_PATH;


	@Override
	public void decompile(String apk, String destination) throws DecompilerException {
		ProcessBuilder process = new ProcessBuilder(DECOMPILER, "d", "-f", "-o", destination, "-p", DECOMPILER_PATH, apk);
		try {

			ExternalProcessor.execute(process, Decompiler.class.getSimpleName());
		} catch (ExternalProcessorException e) {
			throw new DecompilerException("Could not decompile the APK", e);
		}
	}

}
