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
	 * Creates the necessary directories for the project to run
	 * @throws IOException Could not create the directories
	 */
	private void createDirectories(String finalDestinationApk) throws IOException {
		FileManager.createParentDirectoriesToFile(finalDestinationApk);
		if (FileManager.enforceDirectoryExistence(ROOT_TARGET_DIRECTORY)) {
			FileManager.purgeDirectory(ROOT_TARGET_DIRECTORY);
		}

	}

	/**
	 * Creates a backup of the original files resulting from the decompiled APK
	 * @throws IOException Could not backup the decompiled files
	 */
	private void backupDecompile() throws IOException {
		File originalDecompile = new File(DECOMPILER_ORIGINAL_TARGET_FULL_DIRECTORY_PATH);
		FileManager.enforceDirectoryExistence(originalDecompile);
		try {
			FileManager.purgeDirectory(originalDecompile);
			FileManager.mergeCopyDirectory(new File(DECOMPILER_TARGET_FULL_DIRECTORY_PATH), originalDecompile, false);
		} catch (IOException e) {
			throw new IOException("Could not make a copy of the original decompile in directory " + DECOMPILER_ORIGINAL_TARGET_FULL_DIRECTORY_PATH);
		}
	}

	/**
	 * Decompiles a designated APK, modifies it, recompiles it with a new name and signs it (process referred to as injection)
	 * @param apkFullPath APK to decompile
	 * @param destinationFullPath Destination of the recompiled, signed APK
	 * @throws InjectorException Code injection failed
	 */
	public void inject(String apkFullPath, String destinationFullPath) throws InjectorException{
		try {
			this.tryInjection(apkFullPath, destinationFullPath);
		} catch (LoggerException | DecompilerException | RecompilerException | IOException | SignerException | ModifierException e) {
			Log.log(Level.SEVERE, e.getMessage(), e);
			throw new InjectorException("Injection failed", e);
		}
	}

	/**
	 * Wrapper method
	 * Tries to decompile a designated APK, modify it, recompiled it with a new name and sign it
	 * @param apkFullPath APK to decompile
	 * @param destinationFullPath Destination of the recompiled, signed APK
	 * @throws LoggerException Could not setup the logger
	 * @throws DecompilerException APK could not be decompiled
	 * @throws RecompilerException APK could not be recompiled
	 * @throws IOException Could not make backup of the original decompiled file
	 * @throws SignerException Could not sign the APK
	 * @throws ModifierException Could not modify the APK according to the resource files
	 */
	private void tryInjection(String apkFullPath, String destinationFullPath) throws DecompilerException, RecompilerException, IOException, SignerException, ModifierException {


		if (!FileManager.fileExists(apkFullPath)) {
			throw new IOException("Original APK file not found");
		}

		if (!FileManager.getFileExtension(apkFullPath).equals("apk")) {
			throw new IOException("Target file is not an APK");
		}

		this.createDirectories(destinationFullPath);

		Log.info("Starting APK code injection on " + apkFullPath);

		this.decompile(apkFullPath, DECOMPILER_TARGET_FULL_DIRECTORY_PATH);

		Log.info("Making backup of original decompiled files to directory " + DECOMPILER_ORIGINAL_TARGET_FULL_DIRECTORY_PATH);
		this.backupDecompile();
		Log.info("Backup successful");

		this.modifyFiles(DECOMPILER_TARGET_FULL_DIRECTORY_PATH);

		this.recompile(DECOMPILER_TARGET_FULL_DIRECTORY_PATH, RECOMPILED_APK_FULL_PATH);

		this.sign(RECOMPILED_APK_FULL_PATH, destinationFullPath);

		Log.info("The code injection was a success");
	}

	/**
	 * Decompiles a designated APK into a directory
	 * @param apkFullPath APK to decompile
	 * @param decompiledDestination Destination for the decompiled files
	 * @throws DecompilerException Could not decompile the APK
	 */
	public void decompile(String apkFullPath, String decompiledDestination) throws DecompilerException {
		Log.info("Decompiling...");
		this.decompiler.decompile(apkFullPath, decompiledDestination);
		Log.info("Decompile successful");
	}

	/**
	 * Modifies the decompiled files according to the resource files
	 * @param decompiledDestination Path to the files to modify
	 * @throws ModifierException Could not modify the decompiled files according to the resource files
	 */
	public void modifyFiles(String decompiledDestination) throws ModifierException {
		Log.info("Starting modification of decompiled files...");
		this.modifier.modifyCode(decompiledDestination);
		Log.info("The modifications were successful");
	}
safdasks
	/**
	 * Recompiles a decompiled APK's files into an APK
	 * @param decompiledDestination APK files to recompile
	 * @param recompiledDestination Destination for the recompiled APK
	 * @throws RecompilerException Could not recompile the APK
	 */
	public void recompile(String decompiledDestination, String recompiledDestination) throws RecompilerException {
		Log.info("Recompiling...");
		this.recompiler.recompile(decompiledDestination, recompiledDestination);
		Log.info("Recompiling successful");
	}

	/**
	 * Creates a signed copy of an APK in a target directory
	 * @param unsignedDestination Path to APK file to sign
	 * @param signedDestination Destination for the signed APK
	 * @throws SignerException Could not sign the APK
	 */
	public void sign(String unsignedDestination, String signedDestination) throws SignerException {
		Log.info("Signing APK...");
		this.signer.sign(unsignedDestination, signedDestination);
		Log.info("Signing successful");
	}
}
