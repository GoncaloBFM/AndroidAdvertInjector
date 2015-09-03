package aptoide.injector.logger;

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
		builder.append("\n\n");
		return builder.toString();
	}

}