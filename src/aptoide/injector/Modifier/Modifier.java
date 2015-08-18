package aptoide.injector.Modifier;

import aptoide.injector.Auxiliar.FileManager;
import aptoide.injector.Paths;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gbfm on 8/11/15.
 */
public class Modifier implements IModifier {

	private static final String FILES_TO_ADD_FULL_DIRECTORY_PATH = Paths.FILES_TO_ADD_FULL_DIRECTORY_PATH;
	private static final String MANIFEST_ADDENDUM_FULL_PATH = Paths.MANIFEST_ADDENDUM_FULL_PATH;
	private static final String FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH = Paths.FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH;

	private static final String ANDROID_MANIFEST_FILE = "AndroidManifest.xml";
	private static final String ANDROID_PUBLIC_IDS_FILE = "res" + File.separator + "values" + File.separator + "public.xml";

	private static final String LINKER_ACTIVITY_FULL_PATH = Paths.LINKER_ACTIVITY_FULL_PATH;
	private static final String LINKER_ACTIVITY_OLD_LINK = "aptoide/cm/adcolonydecompile/LinkActivity";

	private static final String R_LAYOUT_FILE_NAME = Paths.R_LAYOUT_FILE_NAME;
	private static final String R_RESOURCE_STARTING_STRING = ".field public static final ";
	private static final String R_RESOURCE_MIDDLE_STRING = ":I = ";
	private static final String R_RESOURCE_END_STRING = "\n";

	private static final String SMALI_EXTENSION = "smali";

	IAndroidManifestRW androidManifestRW;
	IAndroidPublicIdsRW androidPublicIdsRW;
	String mainActivityName;

	@Override
	public void modifyCode(String decompiledDirectory) throws ModifierException {
		LinkedList<File> filesAdded = this.addFiles(decompiledDirectory);
		this.modifyManifest(decompiledDirectory);
		LinkedList<Resource> newResources = this.modifyPublicIds(decompiledDirectory);
		this.modifyLinkerActivity(decompiledDirectory);
		this.modifyR(decompiledDirectory, newResources);
		this.replaceResources(filesAdded, newResources);
	}

	private void replaceResources(LinkedList<File> filesAdded, LinkedList<Resource> resourcesAdded) throws ModifierException {
		for (File addedFile : filesAdded) {
			if (FileManager.getFileExtension(addedFile).equals(SMALI_EXTENSION)) {
				TextRW file = null;
				try {
					file = new TextRW(addedFile);
				} catch (Exception e) {
					throw new ModifierException("Could not change old resource id to the new one in one of the new files", e);
				}
				for (Resource resource : resourcesAdded) {
					file.replaceFileContent(resource.getOldId(), resource.getId());
				}
				try {
					file.writeFile();
				} catch (Exception e) {
					throw new ModifierException("Could not write file after changing an old resource id to a new one", e);
				}
			}
		}

	}

	private void modifyLinkerActivity(String decompiledDirectory) throws ModifierException {
		ITextRW linkerFile;
		try {
			linkerFile = new TextRW(decompiledDirectory + File.separator + LINKER_ACTIVITY_FULL_PATH);
		} catch (Exception e) {
			throw new ModifierException("Could not load linker activity file", e);
		}

		linkerFile.replaceFileContent(LINKER_ACTIVITY_OLD_LINK, this.mainActivityName);

		try {
			linkerFile.writeFile();
		} catch (Exception e) {
			throw new ModifierException("Could not write linker file", e);
		}
	}

	private void modifyR(String decompiledDirectory, LinkedList<Resource> newResources) throws ModifierException {
		ITextRW rFile;

		File file = FileManager.findFile(new File(decompiledDirectory), R_LAYOUT_FILE_NAME);
		if (file == null) {
			throw new ModifierException("Could not find R file");
		}

		try {
			rFile = new TextRW(file.getAbsolutePath());
		} catch (Exception e) {
			throw new ModifierException("Could not load R file", e);
		}

		for (Resource resource : newResources) {
			rFile.prependToFileContent(R_RESOURCE_STARTING_STRING + resource.getName() + R_RESOURCE_MIDDLE_STRING + resource.getId() + R_RESOURCE_END_STRING);
		}

		try {
			rFile.writeFile();
		} catch (Exception e) {
			throw new ModifierException("Could not write R file", e);
		}
	}


	private String parseMainActivityName(String mainActivityName) {
		return mainActivityName.replace(".", "/");
	}

	private LinkedList<Resource> modifyPublicIds(String decompiledDirectory) throws ModifierException {
		LinkedList<Resource> addedResources;

		try {
			this.androidPublicIdsRW = new AndroidPublicIdsRW(decompiledDirectory + File.separator + ANDROID_PUBLIC_IDS_FILE);
		} catch (Exception e) {
			throw new ModifierException("Could not load public ids file", e);
		}

		try {
			addedResources = this.androidPublicIdsRW.addResources(FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH);
		} catch (Exception e) {
			throw new ModifierException("Could not add public id's", e);
		}

		try {
			this.androidPublicIdsRW.writeChanges();
		} catch (Exception e) {
			throw new ModifierException("Could not write public ids file", e);
		}

		return addedResources;
	}

	private void modifyManifest(String decompiledDirectory) throws ModifierException{
		try {
			this.androidManifestRW = new AndroidManifestRW(decompiledDirectory + File.separator + ANDROID_MANIFEST_FILE);
		} catch (Exception e) {
			throw new ModifierException("Could not load manifest", e);
		}

		try {
			this.mainActivityName = this.parseMainActivityName(this.androidManifestRW.getMainActivityName());
		} catch (Exception e) {
			throw new ModifierException("Could not load get main activity name", e);
		}

		try {
			this.androidManifestRW.parseManifestAddendum(MANIFEST_ADDENDUM_FULL_PATH);
		} catch (Exception e) {
			throw new ModifierException("Could not change manifest according to the addendum", e);
		}

		try {
			this.androidManifestRW.writeChanges();
		} catch (Exception e) {
			throw new ModifierException("Could not write manifest main activity", e);
		}
	}

	private LinkedList<File> addFiles(String decompiledDirectory) throws ModifierException {
		File decompileDirectory = new File(decompiledDirectory + File.separator);
		File injectDirectory = new File(FILES_TO_ADD_FULL_DIRECTORY_PATH);
		LinkedList<File> filesAdded;
		try {
			filesAdded = FileManager.mergeCopyDirectory(injectDirectory, decompileDirectory);
		} catch (IOException e) {
			throw new ModifierException("Could not add files", e);
		}
		return filesAdded;
	}



}
