package aptoide.injector;

import aptoide.injector.auxiliar.FileManager;
import aptoide.injector.decompiler.Decompiler;
import aptoide.injector.decompiler.DecompilerException;
import aptoide.injector.decompiler.IDecompiler;
import aptoide.injector.logger.LoggerException;
import aptoide.injector.modifier.IModifier;
import aptoide.injector.modifier.Modifier;
import aptoide.injector.modifier.ModifierException;
import aptoide.injector.recompiler.IRecompiler;
import aptoide.injector.recompiler.Recompiler;
import aptoide.injector.recompiler.RecompilerException;
import aptoide.injector.signer.ISigner;
import aptoide.injector.signer.Signer;
import aptoide.injector.signer.SignerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Injector used to recompile a designated APK, modify it,
 * recompile it with a new name and signs it according to the resource files
 *
 * The Injector is using ApkTool (@link http://ibotpeaches.github.io/Apktool/) to
 * facilitate APK decompilation and recompilation.
 * Because of this the Injector only works on Java 7 (JRE 1.7) or higher
 *
 * @author      Gonçalo M.
 */
public class Injector {
	private static final String DECOMPILER_TARGET_FULL_DIRECTORY_PATH = Paths.DECOMPILER_TARGET_FULL_DIRECTORY_PATH;
	private static final String DECOMPILER_ORIGINAL_TARGET_FULL_DIRECTORY_PATH = Paths.DECOMPILER_ORIGINAL_TARGET_FULL_DIRECTORY_PATH;
	private static final String RECOMPILED_APK_FULL_PATH = Paths.RECOMPILED_APK_FULL_PATH;
	private static final String LOGGER_CONFIGURATION_FILE_FULL_PATH = Paths.LOGGER_CONFIGURATION_FILE_FULL_PATH;
	private static final String ROOT_TARGET_DIRECTORY = Paths.ROOT_TARGET_DIRECTORY;

	private static final Logger Log = Logger.getLogger(Injector.class.getName());

	private IDecompiler decompiler;
	private IRecompiler recompiler;
	private ISigner signer;
	private IModifier modifier;

	public Injector() throws LoggerException{
		this.decompiler = new Decompiler();
		this.recompiler = new Recompiler();
		this.modifier = new Modifier();
		this.signer = new Signer();

		FileManager.enforceDirectoryExistence(LOGGER_CONFIGURATION_FILE_FULL_PATH);
		this.setupLogger();
	}

	/**
	 * Sets up the project logger
	 * @throws LoggerException Could not setup the project logger
	 */
	private void setupLogger() throws LoggerException {
		FileManager.enforceDirectoryExistence(LOGGER_CONFIGURATION_FILE_FULL_PATH);
		try {
			FileInputStream configFile = new FileInputStream(LOGGER_CONFIGURATION_FILE_FULL_PATH);
			LogManager.getLogManager().readConfiguration(configFile);
		} catch (IOException e) {
			throw new LoggerException("Couldn't setup logger", e);
		}
	}

	/**
	 * Creates a backup of the original files resulting from the decompiled APK
	 * @return True if the backup was successful, false if not
	 */
	private boolean backupDecompile() throws IOException {
		Log.info("Making backup of original decompiled files to directory " + DECOMPILER_ORIGINAL_TARGET_FULL_DIRECTORY_PATH);
		File originalDecompile = new File(DECOMPILER_ORIGINAL_TARGET_FULL_DIRECTORY_PATH);
		FileManager.enforceDirectoryExistence(originalDecompile);
		FileManager.purgeDirectory(originalDecompile);
		FileManager.mergeCopyDirectory(new File(DECOMPILER_TARGET_FULL_DIRECTORY_PATH), originalDecompile, false);
		Log.info("Backup successful");
		return true;
	}

	/**
	 * Tries to decompile a designated APK, modify it, recompiled it with a new name and sign it
	 * @param apkFullPath APK to decompile
	 * @param destinationFullPath Destination of the recompiled, signed APK
	 *
	 */
	public boolean inject(String apkFullPath, String destinationFullPath) {


		if (!FileManager.fileExists(apkFullPath)) {
			Log.severe("Target APK  not found");
			return false;
		}

		if (!FileManager.getFileExtension(apkFullPath).equals("apk")) {
			Log.severe("Target file is not an APK");
			return false;
		}

		try {
			if (FileManager.enforceDirectoryExistence(ROOT_TARGET_DIRECTORY)) {
				FileManager.purgeDirectory(ROOT_TARGET_DIRECTORY);
			}
		} catch (IOException e) {
			Log.severe("Could not create directories for decompiled files");
			return false;
		}

		Log.info("Starting APK code injection on " + apkFullPath);


		try {
			this.uncheckedDecompile(apkFullPath, DECOMPILER_TARGET_FULL_DIRECTORY_PATH);
			this.backupDecompile();
			this.uncheckedModify(DECOMPILER_TARGET_FULL_DIRECTORY_PATH);
			this.uncheckedRecompile(DECOMPILER_TARGET_FULL_DIRECTORY_PATH, RECOMPILED_APK_FULL_PATH);
			this.uncheckedSign(RECOMPILED_APK_FULL_PATH, destinationFullPath);
		} catch (LoggerException | DecompilerException | RecompilerException | IOException | SignerException | ModifierException e) {
			Log.log(Level.SEVERE, "Code injection failed", e);
			return false;
		}

		Log.info("The code injection was a success");

		return true;
	}

	/**
	 * Decompiles a designated APK into a directory
	 * @param apkFullPath APK to decompile
	 * @param decompiledDestination Destination for the decompiled files
	 * @return True if the decompile was successful false if not
	 */
	public boolean decompile(String apkFullPath, String decompiledDestination) {
		if (!FileManager.fileExists(apkFullPath)) {
			Log.severe("APK to decompile not found");
			return false;
		}

		try {
			this.decompiler.decompile(apkFullPath, decompiledDestination);
		} catch (DecompilerException e) {
			Log.log(Level.SEVERE, "Could not decompile APK", e);
			return false;
		}
		return true;
	}

	/**
	 * Decompiles a designated APK into a directory
	 * @param apkFullPath APK to decompile
	 * @param decompiledDestination Destination for the decompiled files
	 * @throws DecompilerException Could not decompile the APK
	 */
	private void uncheckedDecompile(String apkFullPath, String decompiledDestination) throws DecompilerException{
		Log.info("Decompiling...");
		this.decompiler.decompile(apkFullPath, decompiledDestination);
		Log.info("Decompile successful");
	}

	/**
	 * Modifies the decompiled files according to the resource files
	 * @param decompiledDestination Path to the files to modify
	 * @return True if the files were correctly modified
	 */
	public boolean modify(String decompiledDestination) {
		if (!FileManager.isDirectory(decompiledDestination)) {
			Log.severe("Directory with files to modify not found");
			return false;
		}

		try {
			this.uncheckedModify(decompiledDestination);
			return true;
		} catch (ModifierException e) {
			Log.log(Level.SEVERE, "Could not fully modify the files", e);
			return false;
		}
	}

	/**
	 * Modifies the decompiled files according to the resource files
	 * @param decompiledDestination Path to the files to modify
	 * @exception ModifierException Could not modify the APK
	 */
	private void uncheckedModify(String decompiledDestination) throws ModifierException{
		Log.info("Starting modification of decompiled files...");
		this.modifier.modifyCode(decompiledDestination);
		Log.info("The modifications were successful");
	}

	/**
	 * Recompiles a decompiled APK's files into an APK
	 * @param decompiledDestination APK files to recompile
	 * @param recompiledDestination Destination for the recompiled APK
	 * @return True if the recompile was successful, false if not
	 */
	public boolean recompile(String decompiledDestination, String recompiledDestination){
		if (!FileManager.isDirectory(decompiledDestination)) {
			Log.severe("Directory with decompiled files not found");
			return false;
		}

		try {
			this.uncheckedRecompile(decompiledDestination, recompiledDestination);
			return true;
		} catch (RecompilerException e) {
			Log.log(Level.SEVERE, "Could not recompile the APK", e);
			return false;
		}
	}

	/**
	 * Recompiles a decompiled APK's files into an APK
	 * @param decompiledDestination APK files to recompile
	 * @param recompiledDestination Destination for the recompiled APK
	 * @exception RecompilerException Could not recompile the APK
	 */
	private void uncheckedRecompile(String decompiledDestination, String recompiledDestination) throws RecompilerException{
		Log.info("Recompiling...");
		this.recompiler.recompile(decompiledDestination, recompiledDestination);
		Log.info("Recompiling successful");
	}

	/**
	 * Creates a signed copy of an APK in a target directory
	 * @param unsignedDestination Path to APK file to sign
	 * @param signedDestination Destination for the signed APK
	 * @return True if the signing was successful false if not
	 */
	public boolean sign(String unsignedDestination, String signedDestination) {
		if (!FileManager.fileExists(unsignedDestination)) {
			Log.severe("APK to sign not found");
			return false;
		}

		try {
			this.uncheckedSign(unsignedDestination, signedDestination);
			return true;
		}catch (SignerException e) {
			Log.log(Level.SEVERE, "Could not sign the APK", e);
			return false;
		}
	}

	/**
	 * Creates a signed copy of an APK in a target directory
	 * @param unsignedDestination Path to APK file to sign
	 * @param signedDestination Destination for the signed APK
	 * @exception SignerException Could not sign the APK
	 */
	private void  uncheckedSign(String unsignedDestination, String signedDestination) throws SignerException{
		Log.info("Signing APK...");
		FileManager.createParentDirectoriesToFile(signedDestination);
		this.signer.sign(unsignedDestination, signedDestination);
		Log.info("Signing successful");
	}
}
