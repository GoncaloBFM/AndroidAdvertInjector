package aptoide.injector.modifier;

/**
 * Base interface for the decompiled files modifier
 *
 * @author      Gonçalo M.
 */
public interface IModifier{
	/**
	 * Modifies the decompiled code, adds files, applies the addendums
	 * @param decompiledDirectory Directory with the decompile APK files
	 * @throws ModifierException Could not apply all of the modifications
	 */
	void modifyCode(String decompiledDirectory) throws ModifierException;
}
