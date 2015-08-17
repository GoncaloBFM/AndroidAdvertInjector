package aptoide.injector.Decompiler;

/**
 * Created by gbfm on 8/11/15.
 */
public interface IDecompiler {

	String decompile(String apk, String destination) throws DecompilerException;
}
