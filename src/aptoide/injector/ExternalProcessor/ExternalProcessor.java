package aptoide.injector.ExternalProcessor;

import java.io.*;

/**
 * Created by gbfm on 8/5/15.
 */

public class ExternalProcessor {

	private static final String INTERRUPT_ERROR = "Process Interrupted";

    public static String execute(ProcessBuilder processBuilder, LogType logType)throws ExternalProcessException {

		String stdout = "";
		String stderr = "";
		Process process = null;
		Result result;

        try {
            process = processBuilder.start();
        } catch (Exception e) {
			return createLog(new Result(false, stdout, e.getMessage()),logType);
        }

        BufferedReader stdoutBuffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stderrBuffer = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        try {
            stdout = getOutputFromBuffer(stdoutBuffer);
         	stderr = getOutputFromBuffer(stderrBuffer);
        } catch (IOException bufferException) {
			stderr = bufferException.toString();
			return createLog(new Result(false, stdout, stderr), logType);
        }

		try {
			process.waitFor();
		} catch (InterruptedException e) {
			return createLog(new Result (false, stdout, e.getMessage()), logType);
		}
		return createLog(new Result (process.exitValue() == 0, stdout, stderr), logType);
    }


    private static String getOutputFromBuffer(BufferedReader buff) throws IOException {
        String aux;
        StringBuilder builder = new StringBuilder();
        while ((aux = buff.readLine()) != null) {
            builder.append(aux);
			builder.append("\n");
        }
        return builder.toString();
    }

	private static String createLog(Result result, LogType logType) throws ExternalProcessException {
		String resultString = "" ;
		boolean wasSuccessful = result.wasSuccessful();

		switch (logType) {
			case COMPLETE:
				resultString = "Log of the process:\n\n" + "Stdout:\n---\n" + result.getOutput() + "---\n\n" + "Stderr:\n---\n" +result.getError() + "---\n\n";
			case SIMPLE:
				resultString = "The process was " + (wasSuccessful ? "successful" : "not successful") + "\n" + resultString;
			case NONE:
		}
		if (wasSuccessful) {
			return resultString;
		}
		throw new ExternalProcessException(resultString);
	}

    public static class Result {
		private boolean result;
        private String stdout;
        private String stderr;

		public Result(boolean result, String stdout, String stderr) {
			this.result = result;
			this.stdout = stdout;
			this.stderr = stderr;
		}

        public String getOutput(){
            return this.stdout;
        }

        public String getError() {
            return this.stderr;
        }

		public boolean wasSuccessful() {
			return this.result;
		}
    }

}
