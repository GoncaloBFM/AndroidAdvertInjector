package aptoide.injector.Modifier.Loaders;

/**
 * Created by gbfm on 8/26/15.
 */
public interface ILoader {

	<E> E loadValues() throws LoaderException;

}
