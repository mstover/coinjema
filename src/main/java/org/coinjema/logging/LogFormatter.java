package org.coinjema.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	@Override
	public String format(LogRecord record) {
		StringBuffer buf = new StringBuffer(dateFormat.format(new Date(record.getMillis())));
		buf.append(" Coinjema ").append(record.getLevel()).append(": ").append(record.getMessage()).append("\n");
		if(record.getThrown() != null)
		{
			StringWriter string = new StringWriter();
			PrintWriter writer = new PrintWriter(string);
			record.getThrown().printStackTrace(writer);
			buf.append(string.toString()).append("\n");
		}
		return buf.toString();
	}

}
