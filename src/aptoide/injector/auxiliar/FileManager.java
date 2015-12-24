package aptoide.injector.auxiliar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;

/**
 * Auxiliary file manager implement using both the java.io standard
 * and the apache commons io (https://commons.apache.org/proper/commons-io/)
 * libraries for better performance
 *
 * @author      Gonçalo M.
 */
public class FileManager {

	/**
	 * Returns the extension of a file
	 *
	 * @param file File to get the extension from
	 * @return The extension of the file
	 */
	public static String getFileExtension(File file) {
		return FilenameUtils.getExtension(file.getAbsolutePath());
	}

	/**
	 * Returns the extension of a file
	 *
	 * @param filePath File to get the extension from
	 * @return The extension of the file
	 */
	public static String getFileExtension(String filePath) {
		return FilenameUtils.getExtension(filePath);
	}

	/**
	 * Returns True if a file exists, False if not
	 *
	 * @param file File to check
	 * @return True if the file exists, False if not
	 */
	public static boolean fileExists(File file) {
		return file.isFile();
	}

	/**
	 * Returns True if a file exists, False if not
	 *
	 * @param filePath File path of the file to check
	 * @return True if the file exists, False if not
	 */
	public static boolean fileExists(String filePath) {
		return fileExists(new File(filePath));
	}


	/**
	 * Returns True if a file is a directory, False if not
	 *
	 * @param filePath File path of the file to check
	 * @return True if the file is a directory, False if not
	 */
	public static boolean isDirectory(String filePath) {
		return isDirectory(new File(filePath));
	}

	/**
	 * Returns True if a file is a directory, False if not
	 *
	 * @param file File File to check
	 * @return True if the file is a directory, False if not
	 */
	public static boolean isDirectory(File file) {
		return file.isDirectory();
	}


	/**
	 * Removes recursively every file and directory from a directory
	 *
	 * @param folderPath Path to the directory to be purged
	 * @throws IOException Could not load directory to purge or delete its contents
	 */
	public static void purgeDirectory(String folderPath) throws IOException {
		purgeDirectory(new File(folderPath));

	}

	/**
	 * Removes recursively every file and directory from a directory
	 *
	 * @param directory Directory to be purged
	 * @throws IOException Could not load directory to purge or delete its contents
	 */
	public static void purgeDirectory(File directory) throws IOException {
		FileUtils.cleanDirectory(directory);
	}

	/**
	 * Recursively copies a directory to another directory
	 *
	 * @param source      Directory to copy
	 * @param destination Directory to copy source to
	 * @throws IOException Source or destination is not a directory or the copy itself failed
	 */
	public static void copyDirectory(File source, File destination) throws IOException {
		if (!source.isDirectory()) {
			throw new IOException("Source is not a directory");
		} else if (!destination.isDirectory()) {
			throw new IOException("Destination is not a directory");
		}
		FileUtils.copyDirectory(source, destination);
	}

	/**
	 * Recursively merges two directories
	 *
	 * @param source                    Original directory
	 * @param destination               Directory to merge
	 * @param skipOverFilesWithSameName True if you want to skip files with the same name False if you want to throw an IOException
	 * @return LinkedList of Files Added
	 * @throws IOException Source or destination is not a directory or the copy itself failed
	 */
	public static LinkedList<File> mergeCopyDirectory(File source, File destination, boolean skipOverFilesWithSameName) throws IOException {

		if (!source.isDirectory()) {
			throw new IOException("Source is not a directory");
		} else if (!destination.isDirectory()) {
			throw new IOException("Destination is not a directory");
		}

		LinkedList<File> sourcePaths = getAllElements(source);
		LinkedList<File> addedFiles = new LinkedList<File>();
		sourcePaths.removeFirst();

		for (File fileToCopy : sourcePaths) {
			String pathDestination = replacePaths(fileToCopy.getAbsolutePath(), source.getAbsolutePath(), destination.getAbsolutePath());
			File fileDestination = new File(pathDestination);
			addedFiles.add(fileDestination);
			try {
				Files.copy(fileToCopy.toPath(), fileDestination.toPath());
			} catch (IOException e) {
				if (!skipOverFilesWithSameName && !(fileDestination.isDirectory() && fileToCopy.isDirectory())) {
					throw e;
				}
			}
		}
		return addedFiles;
	}

	/**
	 * Replaces part of a file path
	 *
	 * @param path      Original path
	 * @param pathToCut Part of the path to cut
	 * @param pathToAdd Path to add
	 * @return Updated file path
	 */
	private static String replacePaths(String path, String pathToCut, String pathToAdd) {
		int sourcePathSize = pathToCut.length();
		return pathToAdd + path.substring(sourcePathSize);
	}

	/**
	 * Recursively returns all elements (files and directories) that are inside the root element
	 * (if the root element is a File the resulting list will only contain that file)
	 *
	 * @param root Root element
	 * @return All elements (files and directories) that are inside the root elemen
	 */
	public static LinkedList<File> getAllElements(File root) {
		LinkedList<File> list = new LinkedList<File>();

		list.addLast(root);
		File[] files = root.listFiles();
		if (files != null) {
			for (File file : files) {
				//TODO: optimize (LinkedList.addAll implementation is slow)
				list.addAll(getAllElements(file));
			}
		}
		return list;
	}


	/**
	 * Copies an array of elements (files or directories) to a directory
	 * (Calls copyElement for each of the elements being copied)
	 *
	 * @param elements    Elements to copy
	 * @param destination Target directory
	 * @throws IOException Could not copy the files successfully
	 */
	public static void copyElements(File[] elements, File destination) throws IOException {
		for (File element : elements) {
			copyElement(element, destination);
		}
	}

	/**
	 * Copies an elements (file or directory) to a directory
	 * (Calls copyDirectory if the element is a directory and
	 * copyFile if the element is a file)
	 *
	 * @param element     Element to copy
	 * @param destination Target directory
	 * @throws IOException Could not copy the file successfully
	 */
	public static void copyElement(File element, File destination) throws IOException {
		if (element.isDirectory()) {
			copyDirectory(element, destination);
		} else {
			copyFile(element, destination);
		}
	}

	/**
	 * Recursively searches for a file or directory with a specified
	 * name and returns the  corresponding File object
	 *
	 * @param root Root element for the start of the search
	 * @param name Name of the file or directory to search
	 * @return File object if the file is found, null otherwise
	 */
	public static File findFile(File root, String name) {
		if (root.getName().equals(name)) {
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

	/**
	 * Recursively copies a directory to another directory
	 *
	 * @param source      Directory to copy
	 * @param destination Directory to copy source to
	 * @throws IOException Source or destination is not a directory or the copy itself failed
	 */
	public static void copyFile(File source, File destination) throws IOException {
		if (source.isDirectory()) {
			throw new IOException("Source is not a file");
		} else if (!destination.isDirectory()) {
			throw new IOException("Destination is not a directory");
		}
		Files.copy(source.toPath(), destination.toPath());
	}

	/**
	 * If a the specified directory exists returns True else creates it and returns false
	 * @param directoryPath Path to the directory
	 * @return True if the directory already existed False if it had to be created
	 */
	public static boolean enforceDirectoryExistence(String directoryPath) {
		File directory = new File(directoryPath);
		return enforceDirectoryExistence(directory);
	}

	/**
	 * If a the specified directory exists returns True else creates it and returns false
	 * @param directory Directory to check
	 * @return True if the directory already existed False if it had to be created
	 */
	public static boolean enforceDirectoryExistence(File directory) {
		if (!directory.exists()) {
			directory.mkdirs();
			return false;
		}
		return true;
	}

	/**
	 * Creates all the directories, if they do not exist yet, in the path to the file
	 * @param filePath File path
	 */
	public static void createParentDirectoriesToFile(String filePath) {
		File file = new File(filePath);
		file.getParentFile().mkdirs();
	}
}
