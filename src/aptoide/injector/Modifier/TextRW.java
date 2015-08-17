package aptoide.injector.Modifier;

import aptoide.injector.Modifier.ITextRW;

import java.io.*;

/**
 * Created by gbfm on 8/12/15.
 */
public class TextRW implements ITextRW {

	private File file;
	private String fileContent;

	public TextRW(File file) throws IOException {
		this.file = file;
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.file)));
		this.fileContent = this.buildString(reader);
	}

	public TextRW(String fileName) throws IOException {
		this(new File(fileName));
	}

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
	public String getCurrentFileContent() {
		return this.fileContent;
	}

	@Override
	public void setFileContent(String content) {
		this.fileContent = content;
	}

	@Override
	public String appendToFileContent(String string) {
		this.fileContent += string;
		return this.fileContent;
	}

	@Override
	public String prependToFileContent(String string) {
		this.fileContent = string + this.fileContent;
		return this.fileContent;
	}

	@Override
	public String replaceFileContent(String stringToReplace, String stringToAdd) {
		this.fileContent = this.fileContent.replace(stringToReplace, stringToAdd);
		return this.fileContent;
	}

	@Override
	public String removeFileContent(String stringToRemove) {
		this.replaceFileContent(stringToRemove, "");
		return this.fileContent;
	}

	@Override
 	public void writeFile() throws IOException {
		this.file.delete();
		FileOutputStream fileStream = new FileOutputStream(this.file);
		fileStream.write(this.fileContent.getBytes());
		fileStream.flush();
		fileStream.close();
	}

}
