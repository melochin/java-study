package exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException extends Exception {

	private static Logger logger = Logger.getLogger("LoggingException");

	public LoggingException() {
		StringWriter trace = new StringWriter();
		// 打印异常到输出流 输出流->String
		// trace含有异常信息
		printStackTrace(new PrintWriter(trace));
		// logger 打印异常
		logger.severe(trace.toString());
	}

	public static void main(String[] args) {
		try{
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught: " + e);
		}
	}



}
