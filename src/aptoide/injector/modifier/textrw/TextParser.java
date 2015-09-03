package aptoide.injector.modifier.textrw;

import java.io.*;


/**
 * Basic text file parser
 *
 * @author      Gonçalo M.
 */
public class TextParser implements ITextParser{

	protected File file;
	protected String fileContent;


	/**
	 * Creates a TextParser from a file
	 * @param file File to create the text parser from
	 * @throws FileException Could not create a text parser from the specified file
	 */
	public TextParser(File file) throws FileException {
		this.file = file;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.file)));
			this.fileContent = this.buildString(reader);
		} catch (IOException e) {
			throw new FileException("Could not create TextParser", e);
		}
	}

	/**
	 * Creates a new TextParser from a file path
	 * @param fileName File path
	 * @throws FileException Could not open fil
	 */
	public TextParser(String fileName) throws FileException {
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
