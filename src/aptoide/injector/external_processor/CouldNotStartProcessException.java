package aptoide.injector.external_processor;

/**
 * Used when a process could not be started by the ExternalProcessor
 *
 * @author      Gonçalo M.
 */
public class CouldNotStartProcessException extends ExternalProcessorException {
	public CouldNotStartProcessException(String s) {
		super(s);
	}
	public CouldNotStartProcessException(String s, Exception e) {
		super(s, e);
	}
}
