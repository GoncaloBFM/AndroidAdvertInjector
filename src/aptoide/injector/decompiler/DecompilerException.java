package aptoide.injector.decompiler;

import aptoide.injector.external_processor.ExternalProcessorException;

/**
 * Used when the APK decompiler fails
 *
 * @author      Gonçalo M.
 */
public class DecompilerException extends RuntimeException {
	public DecompilerException(String s) {
		super(s);
	}

	public DecompilerException(Exception e) {
		super(e);
	}

	public DecompilerException(String s, ExternalProcessorException e) {
		super(s, e);
	}
}
