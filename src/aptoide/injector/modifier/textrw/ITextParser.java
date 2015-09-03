package aptoide.injector.modifier.textrw;

import java.io.File;


/**
 * Basic text file parser interface
 *
 * @author      Gonçalo M.
 */
public interface ITextParser {

	/**
	 * Returns the File object associated with the parser
	 * @return The File object associated with the parser
	 */
	public File getFile();

	/**
	 * Returns a string containing the current file content,
	 * if the file is changed but not written the return of
	 * this function will still reflect those changes
	 * @return String containing the current file content
	 */
	public String getCurrentFileContent();
}
