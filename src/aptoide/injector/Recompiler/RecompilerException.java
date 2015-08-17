package aptoide.injector.Recompiler;

import aptoide.injector.ExternalProcessor.ExternalProcessException;
import aptoide.injector.ExternalProcessor.ExternalProcessor;

/**
 * Created by gbfm on 8/13/15.
 */
public class RecompilerException extends Exception {
	public RecompilerException(String s) {
		super(s);
	}

	public RecompilerException(Exception e) {
		super(e);
	}
}
