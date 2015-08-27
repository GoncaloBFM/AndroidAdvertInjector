package aptoide.injector.Modifier;

import aptoide.injector.Auxiliar.FileManager;
import aptoide.injector.Modifier.Addendums.*;
import aptoide.injector.Modifier.Auxiliar.AndroidManifestParser;
import aptoide.injector.Modifier.Auxiliar.IAndroidManifestParser;
import aptoide.injector.Modifier.Loaders.ConfigurationsLoader;
import aptoide.injector.Modifier.Loaders.ILoader;
import aptoide.injector.Modifier.Loaders.LoaderException;
import aptoide.injector.Modifier.TextRW.ITextRW;
import aptoide.injector.Modifier.TextRW.TextRW;
import aptoide.injector.Paths;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by gbfm on 8/11/15.
 */
public class Modifier implements IModifier {

	private static final String FILES_TO_ADD_FULL_DIRECTORY_PATH = Paths.FILES_TO_ADD_FULL_DIRECTORY_PATH;
	private static final String XML_ADDENDUM_FULL_DIRECTORY_PATH = Paths.XML_ADDENDUM_FULL_DIRECTORY_PATH;
	private static final String FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH = Paths.FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH;

	private static final String ANDROID_PUBLIC_IDS_FILE = "res" + File.separator + "values" + File.separator + "public.xml";

	private static final String CONFIGURATION_FILE_FULL_PATH = Paths.CONFIGURATION_FILE_FULL_PATH;

	private static final String SMALI_EXTENSION = "smali";
	private static final String LINKER_ACTIVITY_STARTER_CONFIG_NAME = "linker_activity_starter";
	private static final String LINKER_ACTIVITY_NAME_CONFIG_NAME = "linker_activity_name";

	@Override
	public void modifyCode(String decompiledDirectory) throws ModifierException {
		HashMap<String, String> configurations;
		String launchActivity = this.getCurrentLaunchActivityName(decompiledDirectory);
		configurations = this.loadConfigurationValues(CONFIGURATION_FILE_FULL_PATH);
		LinkedList<File> filesAdded = this.addFiles(decompiledDirectory);
		this.modifyLinkerActivity(decompiledDirectory, configurations.get(LINKER_ACTIVITY_STARTER_CONFIG_NAME), launchActivity, configurations.get(LINKER_ACTIVITY_NAME_CONFIG_NAME));
		this.modifyXML(decompiledDirectory);
		LinkedList<Resource> newResources = this.modifyPublicIds(decompiledDirectory);
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
					file.replaceFileContent(resource.getOldId(), resource.getId(), false);
				}
				try {
					file.writeFile();
				} catch (Exception e) {
					throw new ModifierException("Could not write file after changing an old resource id to a new one", e);
				}
			}
		}

	}

	private String getCurrentLaunchActivityName(String  decompiledDirectory) throws ModifierException {
		IAndroidManifestParser androidManifestParser;
		try {
			androidManifestParser = new AndroidManifestParser(decompiledDirectory + File.separator + MANIFEST_FULL_PATH);
		} catch (Exception e) {
			throw new ModifierException("Could not load manifest", e);
		}
		try {
			return androidManifestParser.getLaunchActivityName().replace(".", "/");
		} catch (Exception e) {
			throw new ModifierException("Could not read manifest", e);
		}
	}

	private HashMap<String, String> loadConfigurationValues(String configurationFilePath) throws ModifierException {
		ILoader configurationLoader;

		try {
			configurationLoader = new ConfigurationsLoader(configurationFilePath);
		} catch (Exception e) {
			throw new ModifierException("Could not load configuration file", e);
		}

		try {
			return  configurationLoader.loadValues();
		} catch (LoaderException e) {
			throw new ModifierException("Could not read configuration file", e);
		}
	}

	private void modifyLinkerActivity(String decompiledDirectory, String pathToLinkerLaucher, String newLaunchActivity, String oldLaunchActivity) throws ModifierException {
		ITextRW linkerFile;

		try {
			linkerFile = new TextRW(decompiledDirectory + File.separator + pathToLinkerLaucher);
		} catch (Exception e) {
			throw new ModifierException("Could not load linker activity file", e);
		}

		linkerFile.replaceFileContent(oldLaunchActivity, newLaunchActivity, false);

		try {
			linkerFile.writeFile();
		} catch (Exception e) {
			throw new ModifierException("Could not write linker file", e);
		}
	}

	private LinkedList<Resource> modifyPublicIds(String decompiledDirectory) throws ModifierException {
		IAddendum publicIdsAddendum = null;

		LinkedList<Resource> addedResources;

		try {
			publicIdsAddendum = new PublicIdsAddendum(FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH, decompiledDirectory + File.separator + ANDROID_PUBLIC_IDS_FILE);
		} catch (AddendumException e) {
			throw new ModifierException("Could not load public ids file or its addendum file", e);
		}

		try {
			addedResources = publicIdsAddendum.apply();
		} catch (Exception e) {
			throw new ModifierException("Could not add public ids", e);
		}

		try {
			publicIdsAddendum.writeChanges();
		} catch (Exception e) {
			throw new ModifierException("Could not write public ids file", e);
		}

		return addedResources;
	}

	private void modifyXML(String decompiledDirectory) throws ModifierException {

		File[] xmlAddendumFiles = new File(XML_ADDENDUM_FULL_DIRECTORY_PATH).listFiles();
		if (xmlAddendumFiles == null) {
			return;
		}

		for (File xmlAddendumFile : xmlAddendumFiles) {
			IAddendum addendum = null;
			try {
				addendum = new XMLAddendum(xmlAddendumFile.getAbsolutePath(), decompiledDirectory);
			} catch (Exception e) {
				throw new ModifierException("Could not load " + xmlAddendumFile.getAbsolutePath() + " addendum file", e);
			}

			try {
				addendum.apply();
			} catch (Exception e) {
				throw new ModifierException("Could not change file according to " + addendum.getAddendumFile(), e);
			}

			try {
				addendum.writeChanges();
			} catch (Exception e) {
				throw new ModifierException("Could not write file after applying" +  addendum.getAddendumFile(), e);
			}

		}
	}

	private LinkedList<File> addFiles(String decompiledDirectory) throws ModifierException {
		File decompileDirectory = new File(decompiledDirectory + File.separator);
		File injectDirectory = new File(FILES_TO_ADD_FULL_DIRECTORY_PATH);
		LinkedList<File> filesAdded;
		try {
			filesAdded = FileManager.mergeCopyDirectory(injectDirectory, decompileDirectory, true);
		} catch (IOException e) {
			throw new ModifierException("Could not add files", e);
		}
		return filesAdded;
	}



}
