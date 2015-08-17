package aptoide.injector.Recompiler;

/**
 * Created by gbfm on 8/13/15.
 */
public interface IRecompiler {
	public String recompile(String decompiled, String destination) throws RecompilerException;
}
