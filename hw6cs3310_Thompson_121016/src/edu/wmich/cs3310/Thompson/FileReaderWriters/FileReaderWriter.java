package edu.wmich.cs3310.Thompson.FileReaderWriters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * FilerReaderWriter class, implements the IFileReaderWriter interface.
 * @author Tyler Thompson
 *
 */
public class FileReaderWriter implements IFileReaderWriter {

	private String fileLocation;
	
	/**
	 * FileReaderWriter constructor
	 * @param fileLocation Location of the file to work with.
	 */
	public FileReaderWriter(String fileLocation){
		this.fileLocation = fileLocation;
		File f = new File(fileLocation);
		System.out.print("HASH FILE CHECK: ");
		if ( f.exists() ) {
			System.out.println("File exists.\n");
		}
		else {
			System.out.println("File does not exist. Creating...\n");
			try {
				PrintWriter w = new PrintWriter(fileLocation, "UTF-8");
				w.println("");
				w.close();
			} catch (Exception e) {
				System.out.println("Failed to create hash table file! Program must not have permissions to create files. Please fix. Program existing...");
				System.exit(0);
			} 		
		}
	}
	
	/**
	 * Reads a single line out of the file.
	 * @param line Index of the line to read.
	 * @return The line as a string.
	 */
	@Override
	public String readLine(int line) {
		try (Stream<String> lines = Files.lines(Paths.get(this.fileLocation))) {
			return lines.skip(line).findFirst().get().split(":")[1];
		}catch (Exception e) {
			return "Name at that index does not exist.";
		}
	}

	/**
	 * Writes to a single line in the file.
	 * @param line Index of the file to write to.
	 * @param data The string to write to that line.
	 */
	@Override
	public void writeLine(int line, String data)  {
		Path path = Paths.get(this.fileLocation);
		List<String> lines;
		int size = 0;
		try {
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			size = lines.size();
			lines.set(line, data);
			Files.write(path, lines, StandardCharsets.UTF_8);
		} catch (Exception e) {
			//System.out.println("Index out of bounds: " + line);
			this.fill(size, line);
			this.writeLine(line, data);
		}
	}

	/**
	 * Fills lines in the file with empty space.
	 * @param start The starting index to start filling.
	 * @param end The ending index to stop filling.
	 */
	private void fill(int start, int end) {
		Path path = Paths.get(this.fileLocation);
		List<String> lines;
		try {
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			for ( int i = start - 1; i < end; i++ ) {
				lines.add(lines.size(), "");
			}
			Files.write(path, lines, StandardCharsets.UTF_8);
		} catch (Exception e) {
			System.out.println("Index out of bounds");
		}
	}

	/**
	 * Reads the whole file.
	 * @return The file as an ArrayList. Each elements is a line from the file.
	 */
	@Override
	public ArrayList<String> readFile() {
	    ArrayList<String> listData = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	String [] lineData = line.split("\n");
		    	for ( int i = 0; i < lineData.length; i++ ) {
		    		listData.add(lineData[i]);
		    	}
		    }
		} catch (Exception e) {
		    ArrayList<String> error = new ArrayList<String>();
		    error.add("Error reading file");
		    return error;
		}
		ArrayList<String> data = new ArrayList<String>();
		for ( int i = 0; i < listData.size(); i++ ) {
		    data.add(listData.get(i));
		}
		return data;
	}
	
}
