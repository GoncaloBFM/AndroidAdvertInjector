package aptoide.injector.modifier.textrw;

/**
 * Text file reader/writer interface
 *
 * @author      Gonçalo M.
 */
public interface ITextRW extends ITextParser{

	/**
	 * Sets a new content
	 * @param content The new content
	 */
	void setFileContent(String content);

	/**
	 * Appends content
	 * @param string Content to append
	 * @return The entire updated content
	 */
	String appendToFileContent(String string);

	/**
	 * Prepends (if you don't know what that means is go to the dictionary... jeez) content
	 * @param string Content to append
	 * @return The entire updated content
	 */
	String prependToFileContent(String string);

	/**
	 * Replaces a a part of the content matched by a string or a regular expression
	 * @param stringToReplace Content to search for or regular expression to match
	 * @param stringToAdd Content to add
	 * @param useRegex True if stringToReplace is a regular expression, False if it is just a normal string
	 * @return The entire updated content
	 */
	public String replaceFileContent(String stringToReplace, String stringToAdd, boolean useRegex);

	/**
	 * Removes a a part of the content matched by a string or a regular expression
	 * @param stringToRemove Content to search for or regular expression to match
	 * @param useRegex True if stringToRemove is a regular expression, False if it is just a normal string
	 * @return The entire updated content
	 */
	public String removeFileContent(String stringToRemove, boolean useRegex);

	/**
	 * Writes the update content to the file
	 * @throws FileException File could not be written
	 */
	void writeFile() throws FileException;
}
