package aptoide.injector.Modifier;

import java.io.*;

/**
 * Created by gbfm on 8/13/15.
 */
public interface ITextRW {

	String getCurrentFileContent();

	void setFileContent(String content);

	String appendToFileContent(String string);

	String prependToFileContent(String string);

	String replaceFileContent(String stringToReplace, String stringToAdd);

	String removeFileContent(String stringToRemove);

	void writeFile() throws IOException;
}
