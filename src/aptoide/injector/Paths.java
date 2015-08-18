package aptoide.injector;

import java.io.File;

/**
 * Created by gbfm on 8/13/15.
 */
public class Paths {

	//Tools
	public static final String TOOLS_DIRECTORY = "Tools";

	//Compiler
	public static final String COMPILER_DIRECTORY = TOOLS_DIRECTORY + File.separator + "Compiler";
	public static final String COMPILER_FULL_PATH = COMPILER_DIRECTORY + File.separator + "apktool";

	//Signer
	public static final String SIGNER_DIRECTORY = TOOLS_DIRECTORY + File.separator + "Signer";
	public static final String SIGNER_FULL_PATH = SIGNER_DIRECTORY + File.separator + "signapk.jar";
	public static final String PEM_FULL_PATH = SIGNER_DIRECTORY + File.separator + "certificate.pem";
	public static final String PK8_FULL_PATH= SIGNER_DIRECTORY + File.separator + "key.pk8";

	//Resources
	public static final String RESOURCES_DIRECTORY = "ResourceFiles";
	public static final String FILES_TO_ADD_FULL_DIRECTORY_PATH = RESOURCES_DIRECTORY + File.separator + "FilesToAdd";
	public static final String ADDENDUM_FILES_FULL_DIRECTORY_PATH = RESOURCES_DIRECTORY + File.separator + "AddendumFiles";
	public static final String MANIFEST_ADDENDUM_FULL_PATH = ADDENDUM_FILES_FULL_DIRECTORY_PATH + File.separator + "manifest.xml";
	public static final String FILE_WITH_PUBLIC_IDS_TO_ADD_FULL_PATH = ADDENDUM_FILES_FULL_DIRECTORY_PATH + File.separator + "public_ids_to_add.xml";

	//Files
	public static final String SMALI_DIRECTORY = "smali";
	public static final String LINKER_ACTIVITY_FULL_PATH = SMALI_DIRECTORY + File.separator + "aptoide" + File.separator + "cm" + File.separator + "adcolonydecompile" + File.separator + "ExtraActivity.smali";
	public static final String R_LAYOUT_FILE_NAME = "R$layout.smali";

	//Target Directories
	public static final String ROOT_TARGET_DIRECTORY = "Destination";
	public static final String DECOMPILER_TARGET_FULL_DIRECTORY_PATH = ROOT_TARGET_DIRECTORY + File.separator + "Decompiled";
	public static final String RECOMPILER_TARGET_FULL_DIRECTORY_PATH = ROOT_TARGET_DIRECTORY + File.separator + "Recompiled";
	public static final String RECOMPILED_APK_FULL_PATH = RECOMPILER_TARGET_FULL_DIRECTORY_PATH + File.separator + "recompiled.apk";

}