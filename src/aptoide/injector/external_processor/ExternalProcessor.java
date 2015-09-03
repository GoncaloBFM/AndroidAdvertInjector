package aptoide.injector.external_processor;

import aptoide.injector.auxiliar.StringFormater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * Static class used to process external processes that require no interaction after they are launched
 *
 * @author      Gonçalo M.
 */
public class ExternalProcessor {

	private final static Logger Log = Logger.getLogger(ExternalProcessor.class.getName());
	private final static int SEPARATOR_SIZE = 40;
	private final static String SEPARATOR_CHAR = "-";

	/**
	 * Executes a process (the process should follow the specifications referred in the class header)
	 * @param processBuilder Instance of ProcessBuilder of the process to execute
	 * @param processName Name of the process (used for log purposes)
	 * @throws ExternalProcessorException Could not execute the process
	 */
	public static void execute(ProcessBuilder processBuilder, String processName) throws ExternalProcessorException {

		String stdout;
		String stderr;
		Process process;

		processName = "'" + processName + "'";

		try {
			process = processBuilder.start();
			Log.info("External processor starting process " + processName);
		} catch (IOException e) {
			throw new CouldNotStartProcessException("Could not start process " + processName, e);
		}

		BufferedReader stdoutBuffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader stderrBuffer = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		try {
			stdout = getOutputFromBuffer(stdoutBuffer);
			stderr = getOutputFromBuffer(stderrBuffer);
		} catch (IOException e) {
			throw new ExternalProcessorException("Couldn't create output readers for the process " + processName, e);
		}


		try {
			process.waitFor();
		} catch (InterruptedException e) {
			throw new ProcessWasInterruptedException("Process " + processName + " was interrupted", e);
		}

		String formatedStdout =
				StringFormater.createSeparator("stdout", SEPARATOR_SIZE, SEPARATOR_CHAR) +
				"\n" + stdout + StringFormater.createSeparator("", SEPARATOR_SIZE, SEPARATOR_CHAR);
		String formatedStderr = "\n" + StringFormater.createSeparator("stderr", SEPARATOR_SIZE, SEPARATOR_CHAR) +
				"\n" + stderr + StringFormater.createSeparator("", SEPARATOR_SIZE, SEPARATOR_CHAR);
		if (process.exitValue() == 0) {
			Log.info("Process " +
					processName +
					" finished successfully" +
					"\n" + formatedStdout +
					formatedStderr);
		} else {
			throw new ProcessFailedException("Process " +
					processName +
					" failed" +
					"\n" + formatedStdout +
					formatedStderr);
		}
	}

	/**
	 * Creates a string made from the buffered process output
	 * @param buff Process output buffer
	 * @return A string made from the buffered process output
	 * @throws IOException Could not read the process output from the buffer
	 */
    private static String getOutputFromBuffer(BufferedReader buff) throws IOException {
        String aux;
        StringBuilder builder = new StringBuilder();
        while ((aux = buff.readLine()) != null) {
            builder.append(aux);
			builder.append("\n");
        }
        return builder.toString();
	}

}
