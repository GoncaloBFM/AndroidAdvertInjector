package aptoide.injector.recompiler;

/**
 * Created by gbfm on 8/13/15.
 */
public interface IRecompiler {

	/**
	 * Recompiles a decompiled APK's files into an APK
	 * @param decompiled APK files to recompile
	 * @param destination Destination for the recompiled APK
	 * @throws RecompilerException Could not recompile the APK
	 */
	public void recompile(String decompiled, String destination) throws RecompilerException;
}
