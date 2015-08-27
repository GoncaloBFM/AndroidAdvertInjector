package aptoide.injector.Modifier.TextRW;

import java.io.*;


/**
 * Basic text file parser
 *
 * @author      Gonçalo M.
 */
public class TextParser implements ITextParser{

	protected File file;
	protected String fileContent;


	public TextParser(File file) throws IOException {
		this.file = file;
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.file)));
		this.fileContent = this.buildString(reader);
	}

	/**
	 * Creates a new TextParser from a file path
	 * @param fileName File path
	 * @throws IOException Could not open fil
	 */
	public TextParser(String fileName) throws IOException {
		this(new File(fileName));
	}

	/**
	 * Dumps the entire BufferedReader into a string
	 * @param reader BufferedReader to dump
	 * @return The entire BufferedReader into a string
	 * @throws IOException Could not open file
	 */
	private String buildString(BufferedReader reader) throws IOException {
		StringBuilder builder = new StringBuilder();
		String line = "";

		while ((line = reader.readLine()) != null) {
			builder.append(line);
			builder.append("\n");
		}
		return builder.toString();
	}

	@Override
	public File getFile() {
		return this.file;
	}

	@Override
	public String getCurrentFileContent() {
		return this.fileContent;
	}
}
