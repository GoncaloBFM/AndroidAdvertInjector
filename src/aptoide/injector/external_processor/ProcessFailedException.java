package aptoide.injector.external_processor;

/**
 * Used when a process run by the ExternalProcessor had a non zero exit value
 *
 * @author      Gonçalo M.
 */
public class ProcessFailedException extends ExternalProcessorException {
	public ProcessFailedException(String s) {
		super(s);
	}
	public ProcessFailedException(String s, Exception e) {
		super(s, e);
	}
}
