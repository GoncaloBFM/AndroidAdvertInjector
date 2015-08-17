package aptoide.injector.Modifier;

/**
 * Created by gbfm on 8/11/15.
 */
public interface IModifier{
	void modifyCode(String decompiledDirectory) throws ModifierException;
}
