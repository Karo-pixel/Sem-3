package se.kth.iv1350.sem3.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Writes error messages to a log file.
 */
public class FileLogger {
    private PrintWriter logFile;

    /**
     * Creates a new logger that writes to a file named log.txt
     * in the program's working directory.
     */
    public FileLogger() {
        try {
            logFile = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException e) {
            System.out.println("Could not create log file.");
        }
    }

    /**
     * Writes an exception to the log file.
     *
     * @param e The exception to log.
     */
    public void logException(Exception e) {
        if (logFile != null) {
            logFile.println("Exception was thrown: " + e.getMessage());
            e.printStackTrace(logFile);
        }
    }
}