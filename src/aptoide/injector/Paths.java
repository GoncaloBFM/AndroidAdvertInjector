package aptoide.injector;

import java.io.File;

/**
 * @author      Gonçalo M.
 */
public class Paths {

	//Tools
	public static final String TOOLS_DIRECTORY = "Tools";

	//Compiler
	public static final String COMPILER_DIRECTORY = TOOLS_DIRECTORY + File.separator + "Compiler";
	public static final String COMPILER_FULL_PATH = COMPILER_DIRECTORY + File.separator + "apktool";

	//signer
	public static final String SIGNER_DIRECTORY = TOOLS_DIRECTORY + File.separator + "Signer";
	public static final String SIGNER_FULL_PATH = SIGNER_DIRECTORY + File.separator + "signapk.jar";
	public static final String PEM_FULL_PATH = SIGNER_DIRECTORY + File.separator + "certificate.pem";
	public static final String PK8_FULL_PATH= SIGNER_DIRECTORY + File.separator + "key.pk8";

	//Resources
	public static final String RESOURCES_DIRECTORY = "ResourceFiles";
	public static final String FILES_TO_ADD_FULL_DIRECTORY_PATH = RESOURCES_DIRECTORY + File.separator + "FilesToAdd";
	public static final String ADDENDUM_FILES_FULL_DIRECTORY_PATH = RESOURCES_DIRECTORY + File.separator + "AddendumFiles";
	public static final String LOADER_FILES_FULL_DIRECTORY_PATH = RESOURCES_DIRECTORY + File.separator + "LoaderFiles";
	public static final String CONFIGURATION_FILES_FULL_DIRECTORY_PATH = RESOURCES_DIRECTORY + File.separator + "ConfigurationFiles";
	public static final String VALUES_FILE_FULL_PATH = LOADER_FILES_FULL_DIRECTORY_PATH + File.separator + "values.xml";
	public static final String XML_ADDENDUM_FULL_DIRECTORY_PATH = ADDENDUM_FILES_FULL_DIRECTORY_PATH + File.separator + "XML";
	public static final String PUBLIC_IDS_ADDENDUM_FULL_DIRECTORY_PATH = ADDENDUM_FILES_FULL_DIRECTORY_PATH + File.separator + "PublicIds";
	public static final String FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH = PUBLIC_IDS_ADDENDUM_FULL_DIRECTORY_PATH + File.separator + "public_ids_to_add.xml";

	//Target Directories
	public static final String ROOT_TARGET_DIRECTORY = "Destination";
	public static final String DECOMPILER_TARGET_FULL_DIRECTORY_PATH = ROOT_TARGET_DIRECTORY + File.separator + "ModifiedDecompiled";
	public static final String DECOMPILER_ORIGINAL_TARGET_FULL_DIRECTORY_PATH = ROOT_TARGET_DIRECTORY + File.separator + "OriginalDecompiled";
	public static final String RECOMPILER_TARGET_FULL_DIRECTORY_PATH = ROOT_TARGET_DIRECTORY + File.separator + "Recompiled";
	public static final String RECOMPILED_APK_FULL_PATH = RECOMPILER_TARGET_FULL_DIRECTORY_PATH + File.separator + "recompiled.apk";

	//Logger
	public static final String LOGGER_CONFIGURATION_FILE_FULL_PATH = "ConfigurationFiles" + File.separator + "logger.properties";

}