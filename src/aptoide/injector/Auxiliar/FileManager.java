package aptoide.injector.Auxiliar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;

/**
 * Created by gbfm on 8/6/15.
 */
public class FileManager {

	public static String getFileExtension(File file) {
		return FilenameUtils.getExtension(file.getAbsolutePath());
	}

	public static String getFileExtension(String filePath) {
		return FilenameUtils.getExtension(filePath);
	}

	public static boolean fileExists(File file) {
		return file.isFile();
	}

	public static boolean fileExists(String filePath) {
		return fileExists(new File(filePath));
	}

	public static void purgeDirectory(String folderPath) throws IOException {
		purgeDirectory(new File(folderPath));

	}

	public static void purgeDirectory(File folder) throws IOException {
		FileUtils.cleanDirectory(folder);
	}

	public static void copyDirectory(File source, File destination) throws IOException {
		if (!source.isDirectory()) {
			throw new IOException("Source is not a directory");
		} else if (!destination.isDirectory()) {
			throw new IOException("Destination is not a directory");
		}
		FileUtils.copyDirectory(source, destination);
	}


	public static LinkedList<File> mergeCopyDirectory(File source, File destination) throws IOException {

		if (!source.isDirectory()) {
			throw new IOException("Source is not a directory");
		} else if (!destination.isDirectory()) {
			throw new IOException("Destination is not a directory");
		}

		LinkedList<File> sourcePaths = getAllElements(source);
		LinkedList<File> addedFiles = new LinkedList<File>();
		sourcePaths.removeFirst();

		for (File fileToCopy : sourcePaths){
			addedFiles.add(fileToCopy);
			String pathDestination = replacePaths(fileToCopy.getAbsolutePath(), source.getAbsolutePath(), destination.getAbsolutePath());
			File fileDestination = new File(pathDestination);
			try {
				Files.copy(fileToCopy.toPath(), fileDestination.toPath());
			} catch (IOException e) {
				if (!(fileDestination.isDirectory() && fileToCopy.isDirectory())) throw e;
			}
		}
		return addedFiles;
	}

	private static String replacePaths(String path, String pathToCut, String pathToAdd) {
		int sourcePathSize = pathToCut.length();
		return pathToAdd + path.substring(sourcePathSize);
	}

	//TODO: optimize (addAll implementation is slwo)
	public static LinkedList<File> getAllElements(File source){
		LinkedList<File> list = new LinkedList<File>();

		list.addLast(source);
		File[] files = source.listFiles();
		if (files != null) {
			for (File file : files) {
				list.addAll(getAllElements(file));
			}
		}
		return list;
	}

	public static void copyElements(File[] elements, File destination) throws IOException {
		for (File element : elements) {
			copyElement(element, destination);
		}
	}

	public static void copyElement(File element, File destination) throws IOException {
		if (element.isDirectory()) {
			copyDirectory(element, destination);
		} else {
			copyFile(element, destination);
		}
	}

	public static File findFile(File root, String name) {
		if (root.getName().equals(name)){
			return root;
		}
		File[] files = root.listFiles();
		if (files != null) {
			for (File childFile : files) {
				File result = findFile(childFile, name);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}

	public static void copyFile(File source, File destination) throws IOException {
		if (source.isDirectory()) {
			throw new IOException("Source is not a file");
		} else if (!destination.isDirectory()) {
			throw new IOException("Destination is not a directory");
		}
		Files.copy(source.toPath(), destination.toPath());
	}
}
