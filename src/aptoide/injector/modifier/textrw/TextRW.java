package aptoide.injector.modifier.textrw;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Text reader/writer
 *
 * @author      Gonçalo M.
 */
public class TextRW extends TextParser implements ITextRW {

	public TextRW(File file) throws FileException {
		super(file);
	}


	public TextRW(String file) throws FileException {
		super(file);
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
	public String replaceFileContent(String stringToReplace, String stringToAdd, boolean useRegex) {
		if (useRegex) {
			this.fileContent = this.fileContent.replaceAll(stringToReplace, stringToAdd);
		} else {
			this.fileContent = this.fileContent.replace(stringToReplace, stringToAdd);
		}
		return this.fileContent;
	}

	@Override
	public String removeFileContent(String stringToRemove, boolean useRegex) {
		this.replaceFileContent(stringToRemove, "", useRegex);
		return this.fileContent;
	}


	@Override
 	public void writeFile() throws FileException {
		this.file.delete();
		FileOutputStream fileStream;
		try {
			fileStream = new FileOutputStream(this.file);
			fileStream.write(this.fileContent.getBytes());
			fileStream.flush();
			fileStream.close();
		} catch (IOException e) {
			throw new FileException("Could not write file", e);
		}
	}

}
