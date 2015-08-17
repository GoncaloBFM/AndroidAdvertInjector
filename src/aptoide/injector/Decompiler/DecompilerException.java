package aptoide.injector.Decompiler;

import aptoide.injector.ExternalProcessor.ExternalProcessException;

/**
 * Created by gbfm on 8/10/15.
 */
public class DecompilerException extends Exception {
	public DecompilerException(String s) {
		super(s);
	}

	public DecompilerException(Exception e) {
		super(e);
	}
}
