package aptoide.injector.modifier.loaders;

/**
 * Basic file information loader interface
 *
 * @author      Gonçalo M.
 */
public interface ILoader {

	/**
	 * Loads information from a file and returns it
	 * @return File information
	 * @throws LoaderException Could not load the information from the file
	 */
	<E> E loadValues() throws LoaderException;

}
