package aptoide;

import aptoide.injector.Injector;

import java.io.IOException;

/**
 * @author      Gonçalo M.
 */
public class Main {

    public static void main(String[] args) throws IOException {
		args = new String[]{"-i", "TestFiles/flappy_bird.apk", "Final/final.apk"};

		if (args.length == 0) {
			printHelp();
			return;
		}

		Injector injector;

		switch (args[0]) {
			case "--help":
			case "-h":
				if (args.length != 1) {
					printWrongNumberOfArgs();
					printHelp();
				}
				printHelp();
				break;
			case "--inject":
			case "-i":
				if (args.length != 3) {
					printWrongNumberOfArgs();
					printHelp();
				}
				injector = new Injector();
				injector.inject(args[1], args[2]);
				break;
			case "--decompile":
			case "-d":
				if (args.length != 3) {
					printWrongNumberOfArgs();
					printHelp();
				}
				injector = new Injector();
				injector.decompile(args[1], args[2]);
			case "--recompile":
			case "-r":
				if (args.length != 3) {
					printWrongNumberOfArgs();
					printHelp();
				}
				injector = new Injector();
				injector.recompile(args[1], args[2]);
			case "--sign":
			case "-s":
				if (args.length != 3) {
					printWrongNumberOfArgs();
					printHelp();
				}
				injector = new Injector();
				injector.sign(args[1], args[2]);
			case "--modify":
			case "-m":
				if (args.length != 2) {
					printWrongNumberOfArgs();
					printHelp();
				}
				injector = new Injector();
				injector.modifyFiles(args[1]);
			default:
				printHelp();
		}

	}

	private static void print(String string) {
		System.out.println(string);
	}

	private static void printHelp() {
		print(
				"Android Injector v1.0 - a tool for mass injection of code and resources in apks\n" +
				"Created by Gonçalo M.\n" +
				"Using ApkTool for as decompiler and decompiler\n" +
				"\n" +
				"\n" +
				"usage: injector -v, --version\n" +
				"    prints the version then exits\n" +
				"\n" +
				"usage: injector -i, --inject <apk to decompile> <path to the resulting apk>\n" +
				"    decompiles the apk , modifies the decompiled code, recompiles the apk and signs it\n" +
				"\n" +
				"usage: injector -d, --decompile <apk to decompile> <target directory of the decompiled apk files> \n" +
				"    decompiles the apk\n" +
				"\n" +
				"usage: injector -r, --recompile <apk files to recompile> <target directory for the recompiled apk> \n" +
				"    recompiles the apk\n" +
				"\n" +
				"usage: injector -s, --sign <apk to sign> <target path for the signed apk> \n" +
				"    signs the apk\n" +
				"\n" +
				"usage: injector -m, --modify <decompiled code to modify>\n" +
				"    modifies the decompiled apk according to the ResourceFiles directory\n"
		);
	}

	private static void printVersion() {
		print("Android Injector v1.0\n");
	}

	private static void printWrongNumberOfArgs() {
		print("Wrong number of arguments\n");
	}
}


