package aptoide.injector.external_processor;

/**
 * Generic ExternalProcessor exception
 *
 * @author      Gonçalo M.
 */
public class ExternalProcessorException extends Exception{
	public ExternalProcessorException(String s) {
		super(s);

	}
	public ExternalProcessorException(String s, Exception e) {
		super(s, e);
	}
}
