package aptoide.injector.Modifier;

import java.io.*;

/**
 * Created by gbfm on 8/13/15.
 */
public interface ITextRW {

	public String getCurrentFileContent();

	public void setFileContent(String content);

	public String appendToFileContent(String string);

	public String prependToFileContent(String string);

	public String replaceFileContent(String stringToReplace, String stringToAdd);

	public String removeFileContent(String stringToRemove);

	public void writeFile() throws IOException;
}
