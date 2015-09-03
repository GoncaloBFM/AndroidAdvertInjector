package aptoide.injector.decompiler;

/**
 * Used when the APK decompiler fails
 *
 * @author      Gonçalo M.
 */
public interface IDecompiler {

	/**
	 * Decompiles a designated APK into a directory
	 * @param apk APK to decompile
	 * @param destination Destination for the decompiled files
	 * @throws DecompilerException Could not decompile the APK
	 */
	void decompile(String apk, String destination) throws DecompilerException;
}
