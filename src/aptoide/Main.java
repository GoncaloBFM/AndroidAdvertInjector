package aptoide;

import aptoide.injector.Injector;

import java.io.IOException;

/**
 * @author      Gonçalo M.
 */
public class Main {

    public static void main(String[] args) throws IOException {
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
					break;
				}
				printHelp();
				break;
			case "--version":
			case "-v":
				if (args.length != 1) {
					printWrongNumberOfArgs();
					printHelp();
					break;
				}
				printVersion();
				break;
			case "--inject":
			case "-i":
				if (args.length != 3) {
					printWrongNumberOfArgs();
					printHelp();
					break;
				}
				injector = new Injector();
				injector.inject(args[1], args[2]);
				break;
			case "--decompile":
			case "-d":
				if (args.length != 3) {
					printWrongNumberOfArgs();
					printHelp();
					break;
				}
				injector = new Injector();
				injector.decompile(args[1], args[2]);
				break;
			case "--recompile":
			case "-r":
				if (args.length != 3) {
					printWrongNumberOfArgs();
					printHelp();
					break;
				}
				injector = new Injector();
				injector.recompile(args[1], args[2]);
				break;
			case "--sign":
			case "-s":
				if (args.length != 3) {
					printWrongNumberOfArgs();
					printHelp();
					break;
				}
				injector = new Injector();
				injector.sign(args[1], args[2]);
				break;
			case "--modify":
			case "-m":
				if (args.length != 2) {
					printWrongNumberOfArgs();
					printHelp();
					break;
				}
				injector = new Injector();
				injector.modify(args[1]);
				break;
			default:
				printUnknownCommand();
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
				"Using ApkTool 2.0.1 as decompiler and decompiler\n" +
				"Needs Java 1.7 or higher\n" +
				"\n" +
				"\n" +
				"usage: java -jar AndroidInjector.jar -v, --version\n" +
				"    prints the version then exits\n" +
				"\n" +
				"usage: java -jar AndroidInjector.jar -i, --inject <apk to decompile> <path to the resulting apk>\n" +
				"    decompiles the apk , modifies the decompiled code, recompiles the apk and signs it\n" +
				"\n" +
				"usage: java -jar AndroidInjector.jar -d, --decompile <apk to decompile> <target directory of the decompiled apk files> \n" +
				"    decompiles the apk\n" +
				"\n" +
				"usage: java -jar AndroidInjector.jar -r, --recompile <apk files to recompile> <target directory for the recompiled apk> \n" +
				"    recompiles the apk\n" +
				"\n" +
				"usage: java -jar AndroidInjector.jar -s, --sign <apk to sign> <target path for the signed apk> \n" +
				"    signs the apk\n" +
				"\n" +
				"usage: java -jar AndroidInjector.jar -m, --modify <decompiled code to modify>\n" +
				"    modifies the decompiled apk according to the ResourceFiles directory\n"
		);
	}

	private static void printVersion() {
		print("Android Injector v1.0\n");
	}

	private static void printUnknownCommand() {
		print("Unknown Command\n");
	}

	private static void printWrongNumberOfArgs() {
		print("Wrong number of arguments\n");
	}
}


