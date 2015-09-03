package aptoide.injector.logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * File logger formatter
 *
 * @author      Gonçalo M.
 */
public class FileLoggerFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(record.getSourceClassName()).append(".");
		builder.append(record.getSourceMethodName()).append("] - ");
		builder.append("[").append(record.getLevel()).append("]\n");
		builder.append(record.getMessage());
		builder.append("\n\n");
		return builder.toString();
	}
}
