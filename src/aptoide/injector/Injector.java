package aptoide.injector;

import aptoide.injector.Decompiler.*;
import aptoide.injector.Modifier.IModifier;
import aptoide.injector.Modifier.Modifier;
import aptoide.injector.Modifier.ModifierException;
import aptoide.injector.Recompiler.IRecompiler;
import aptoide.injector.Recompiler.Recompiler;
import aptoide.injector.Recompiler.RecompilerException;
import aptoide.injector.Signer.ISigner;
import aptoide.injector.Signer.Signer;
import aptoide.injector.Signer.SignerException;

import java.io.File;

/**
 * Created by gbfm on 8/5/15.
 */
public class Injector {
	private static final String DECOMPILER_TARGET_FULL_DIRECTORY_PATH = Paths.DECOMPILER_TARGET_FULL_DIRECTORY_PATH;
	private static final String RECOMPILED_APK_FULL_PATH = Paths.RECOMPILED_APK_FULL_PATH;

	private IDecompiler decompiler;
	private IRecompiler recompiler;
	private ISigner signer;
	private IModifier modifier;

	public Injector() {
		this.decompiler = new Decompiler();
		this.recompiler = new Recompiler();
		this.modifier = new Modifier();
		this.signer = new Signer();
	}

	public String inject(String apkFullPath, String destinationFullPath) throws DecompilerException, ModifierException, RecompilerException, SignerException {

		System.out.println("Starting decompiler...");
		System.out.println(this.decompile(apkFullPath, DECOMPILER_TARGET_FULL_DIRECTORY_PATH));
		System.out.println("Starting modifier\n\n");
		this.modifyFiles(DECOMPILER_TARGET_FULL_DIRECTORY_PATH);
		System.out.println("Starting recompiler...");
		System.out.println(this.recompile(DECOMPILER_TARGET_FULL_DIRECTORY_PATH, RECOMPILED_APK_FULL_PATH));
		System.out.println("Starting signer...");
		this.sign(RECOMPILED_APK_FULL_PATH, destinationFullPath);
		System.out.println("Done");
		return "";
	}

	private String decompile(String apkFullPath, String decompiledDestination) throws DecompilerException {
		return this.decompiler.decompile(apkFullPath, decompiledDestination);
	}

	private void modifyFiles(String decompiledDestination) throws ModifierException {
		this.modifier.modifyCode(decompiledDestination);
	}

	private String recompile(String decompiledDestination, String recompiledDestination) throws RecompilerException {
		return this.recompiler.recompile(decompiledDestination, recompiledDestination);
	}

	private String sign(String recompiledDestination, String signerDestination) throws SignerException {
		return this.signer.sign(recompiledDestination, signerDestination);
	}

}
