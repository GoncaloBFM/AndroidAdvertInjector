package aptoide;

import aptoide.injector.*;
import aptoide.injector.Decompiler.DecompilerException;
import aptoide.injector.Recompiler.RecompilerException;
import aptoide.injector.Modifier.ModifierException;
import aptoide.injector.Signer.SignerException;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
		args = new String[]{"TestFiles/adobe_reader_outcolony.apk", "Final/final.apk"};

		if (args.length != 2) {
			print("Wrong number of args");
			return;
		}

		String originalApkPath = args[0];
		File originalApk = new File(originalApkPath);

		/*if (!FileManager.fileExists(originalApk)) {
			print("Original apk file not found");
			return;
		}

		if (!FileManager.getFileExtension(originalApk).equals("apk")) {
			print("Original Apk file is not an Apk");
			return;vs
		}*/

		Injector injector = new Injector();

		try {
			injector.inject(originalApkPath, args[1]);
		} catch (DecompilerException e) {
			e.printStackTrace();
		} catch (ModifierException e) {
			e.printStackTrace();
		} catch (RecompilerException e) {
			e.printStackTrace();
		} catch (SignerException e) {
			e.printStackTrace();
		}


		/*try {
			AndroidPublicIdsRW x = new AndroidPublicIdsRW("Decompiled/res/values/public.xml");
			x.addResources("ResourceFiles/AddendumFiles/public_ids_to_add.xml");
			x.writeChanges();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}*/
	}




    private static void print(String string) {
        System.out.println(string);
    }


}
