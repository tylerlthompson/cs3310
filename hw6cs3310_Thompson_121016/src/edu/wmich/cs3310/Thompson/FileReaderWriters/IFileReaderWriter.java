package edu.wmich.cs3310.Thompson.FileReaderWriters;

import java.util.ArrayList;

/**
 * Provides the IFileReaderWriter interfeace for reading and writing to files.
 * @author Tyler Thompson
 *
 */
public interface IFileReaderWriter {

	/**
	 * Reads a single line out of the file.
	 * @param line Index of the line to read.
	 * @return The line as a string.
	 */
	String readLine(int line);
	
	/**
	 * Writes to a single line in the file.
	 * @param line Index of the file to write to.
	 * @param data The string to write to that line.
	 */
	void writeLine(int line, String data);
	
	/**
	 * Reads the whole file.
	 * @return The file as an ArrayList. Each elements is a line from the file.
	 */
	ArrayList<String> readFile();
	
}
