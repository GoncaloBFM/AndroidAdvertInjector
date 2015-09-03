package aptoide.injector.external_processor;

/**
 * Used when a process is interrupted
 *
 * @author      Gonçalo M.
 */
public class ProcessWasInterruptedException extends ExternalProcessorException {
	public ProcessWasInterruptedException(String s) {
		super(s);
	}
	public ProcessWasInterruptedException(String s, Exception e) {
		super(s, e);
	}
}
