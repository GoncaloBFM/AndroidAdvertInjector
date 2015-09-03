package aptoide.injector.auxiliar;

/**
 * Auxiliary static class used to create, parse and format strings
 *
 * @author      Gonçalo M.
 */
public class StringFormater {
	/**
	 * Creates a separator to format the output of the process
	 * @param title Title of the separator (can be left blank)
	 * @param separatorSize Number of characters in the separator including the title
	 * @param separatorChar Character used to draw the separator
	 * @return Separator string
	 */
	public static String createSeparator(String title, int separatorSize, String separatorChar) {
		return String.format("%-" + separatorSize +  "s", title).replace(" ", separatorChar);
	}
}
