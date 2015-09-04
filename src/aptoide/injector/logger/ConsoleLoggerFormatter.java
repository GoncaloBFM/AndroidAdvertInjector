package aptoide.injector.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Console logger formatter
 *
 * @author      Gonçalo M.
 */
public class ConsoleLoggerFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(record.getLevel()).append("] - ");
		builder.append(record.getMessage());

		Throwable throwable = record.getThrown();
		if (throwable != null) {
			StringWriter errors = new StringWriter();
			throwable.printStackTrace(new PrintWriter(errors));
			builder.append(errors.toString());
		}

		builder.append("\n\n");
		return builder.toString();
	}

}