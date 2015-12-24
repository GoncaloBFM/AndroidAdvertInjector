package aptoide.injector.modifier;

import aptoide.injector.Paths;
import aptoide.injector.auxiliar.FileManager;
import aptoide.injector.modifier.addendums.*;
import aptoide.injector.modifier.loaders.ILoader;
import aptoide.injector.modifier.loaders.LoaderException;
import aptoide.injector.modifier.loaders.ValuesLoader;
import aptoide.injector.modifier.textrw.FileException;
import aptoide.injector.modifier.textrw.ITextRW;
import aptoide.injector.modifier.textrw.TextRW;
import aptoide.injector.modifier.xmlrw.XMLException;
import aptoide.injector.modifier.xmlrw.XMLParser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Decompiled files modifier
 *
 * @author      Gonçalo M.
 */
public class Modifier implements IModifier {

	private static final String FILES_TO_ADD_FULL_DIRECTORY_PATH = Paths.FILES_TO_ADD_FULL_DIRECTORY_PATH;
	private static final String XML_ADDENDUM_FULL_DIRECTORY_PATH = Paths.XML_ADDENDUM_FULL_DIRECTORY_PATH;
	private static final String FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH = Paths.FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH;

	private static final String VALUES_FILE_FULL_PATH = Paths.VALUES_FILE_FULL_PATH;

	private static final String SMALI_EXTENSION = "smali";
	private static final String LINKER_ACTIVITY_STARTER_CONFIG_NAME = "linker_activity_starter";
	private static final String LINKER_ACTIVITY_NAME_CONFIG_NAME = "linker_activity_name";
	private static final String MANIFEST_PATH_CONFIG_NAME = "manifest_path";
	private static final String PUBLIC_IDS_PATH_CONFIG_NAME = "public_ids_path";
	private static final String XPATH_TO_LAUNCHER_ACTIVITY_ON_MANIFEST_CONFIG_NAME = "xpath_to_launcher_activity_on_manifest";

	private static final Logger Log = Logger.getLogger(Modifier.class.getName());


	@Override
	public void modifyCode(String decompiledDirectory) throws ModifierException {
		Log.info("Loading values file");
		HashMap<String, String> values = this.loadInjectorValues(VALUES_FILE_FULL_PATH);
		Log.info("Retrieving launcher activity");
 		String launchActivity = this.getCurrentLaunchActivityName(decompiledDirectory, values.get(MANIFEST_PATH_CONFIG_NAME), values.get(XPATH_TO_LAUNCHER_ACTIVITY_ON_MANIFEST_CONFIG_NAME));
		Log.info("Adding files");
		LinkedList<File> filesAdded = this.addFiles(decompiledDirectory);
		Log.info("Setting a new launcher activity");
		this.modifyLinkerActivity(decompiledDirectory, values.get(LINKER_ACTIVITY_STARTER_CONFIG_NAME), launchActivity, values.get(LINKER_ACTIVITY_NAME_CONFIG_NAME));
		Log.info("Adding resources to android XML files");
		this.modifyXML(decompiledDirectory);
		Log.info("Setting new id's for added resources");
		LinkedList<Resource> newResources = this.modifyPublicIds(decompiledDirectory, values.get(PUBLIC_IDS_PATH_CONFIG_NAME));
		this.replaceResources(filesAdded, newResources);
	}

	/**
	 * Replaces the added resource ids to match the new attributed ones in all the newly added code files.
	 * @param filesAdded Newly added smali files
	 * @param resourcesAdded Newly added resources
	 * @throws ModifierException Could not change the all of the resource ids
	 */
	private void replaceResources(LinkedList<File> filesAdded, LinkedList<Resource> resourcesAdded) throws ModifierException {
		for (File addedFile : filesAdded) {
			if (FileManager.getFileExtension(addedFile).equals(SMALI_EXTENSION)) {
				TextRW file;
				try {
					file = new TextRW(addedFile);
				} catch (FileException e) {
					throw new ModifierException("Could not change old resource id to the new one in one of the new files", e);
				}
				for (Resource resource : resourcesAdded) {
					file.replaceFileContent(resource.getOldId(), resource.getId(), false);
				}
				try {
					file.writeFile();
				} catch (FileException e) {
					throw new ModifierException("Could not write file after changing an old resource id to a new one", e);
				}
			}
		}

	}

	/**
	 * Returns the launcher activity name
	 * @param decompiledDirectory Directory with the decompiled files
	 * @param manifestPath Path to the android manifest
	 * @param xpathManifestToLauncherActivityName XPath to launcher activity
	 * @return The launcher activity name
	 * @throws ModifierException Could not get launcher activity name
	 */
	private String getCurrentLaunchActivityName(String decompiledDirectory, String manifestPath, String xpathManifestToLauncherActivityName) throws ModifierException {
		XMLParser manifestParser;
		try {
			manifestParser = new XMLParser(decompiledDirectory + File.separator + manifestPath);
			return manifestParser.getString(xpathManifestToLauncherActivityName).replace(".", "/");
		} catch (XMLException e ) {
			throw new ModifierException("Could not get launcher activity name", e);
		}
	}

	/**
	 * Loads injector basic settings
	 * @param valuesFilePath Path to the settings file
	 * @return HashMap with the basic settings
	 * @throws ModifierException Could not load settings values
	 */
	private HashMap<String, String> loadInjectorValues(String valuesFilePath) throws ModifierException {
		ILoader valuesLoader;

		try {
			valuesLoader = new ValuesLoader(valuesFilePath);
			return valuesLoader.loadValues();
		} catch (LoaderException e) {
			throw new ModifierException("Could not read values file", e);
		}
	}

	/**
	 * Modifies smali code in order to make the linker activity point to the original APK's launcher activity
	 * @param decompiledDirectory Directory with the decompiled files
	 * @param pathToLinkerLauncher Path to the linker activity launcher
	 * @param newLaunchActivity Name of the original APK's launcher activity
	 * @param oldLaunchActivity Name of the linker activity
	 * @throws ModifierException Could not change the linker activity
	 */
	private void modifyLinkerActivity(String decompiledDirectory, String pathToLinkerLauncher, String newLaunchActivity, String oldLaunchActivity) throws ModifierException {
		ITextRW linkerFile;

		try {
			linkerFile = new TextRW(decompiledDirectory + File.separator + pathToLinkerLauncher);
		} catch (FileException e) {
			throw new ModifierException("Could not load linker activity file", e);
		}

		linkerFile.replaceFileContent(oldLaunchActivity, newLaunchActivity, false);

		try {
			linkerFile.writeFile();
		} catch (FileException e) {
			throw new ModifierException("Could not write linker file", e);
		}
	}

	/**
	 * Generates new ids in the public ids files for the newly added resources
	 * @param decompiledDirectory Directory with the decompiled files
	 * @param publicIdsFile Path to the android public ids file
	 * @return List of resources added
	 * @throws ModifierException Could not add new ids to the public ids file
	 */
	private LinkedList<Resource> modifyPublicIds(String decompiledDirectory, String publicIdsFile) throws ModifierException {
		IAddendum publicIdsAddendum;

		LinkedList<Resource> addedResources;

		try {
			publicIdsAddendum = new PublicIdsAddendum(FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH, decompiledDirectory + File.separator + publicIdsFile);
			addedResources = publicIdsAddendum.apply();
			publicIdsAddendum.writeChanges();
		} catch (AddendumException e) {
			throw new ModifierException("Could not apply public ids addendum", e);
		}

		return addedResources;
	}

	/**
	 * Applies XML addendums to the decompiled files
	 * @param decompiledDirectory Directory with the decompiled files
	 * @throws ModifierException Could not apply all of the XML addendums
	 */
	private void modifyXML(String decompiledDirectory) throws ModifierException {

		File[] xmlAddendumFiles = new File(XML_ADDENDUM_FULL_DIRECTORY_PATH).listFiles();
		if (xmlAddendumFiles == null) {
			return;
		}

		for (File xmlAddendumFile : xmlAddendumFiles) {
			IAddendum addendum;
			try {
				addendum = new XMLAddendum(xmlAddendumFile.getAbsolutePath(), decompiledDirectory);
				addendum.apply();
				addendum.writeChanges();
			} catch (AddendumException e) {
				throw new ModifierException("Could not write file after applying " +  xmlAddendumFile.getName() + " addendum", e);
			}
		}
	}

	/**
	 * Adds the resource files to the decompiled files
	 * @param decompiledDirectory Directory with the decompiled files
	 * @return Added files
	 * @throws ModifierException Could not add the resource files
	 */
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
