package edu.wmich.cs3310.Thompson.FileReaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Provides the FileRead class for reading files.
 * @author Tyler Thompson
 *
 */
public class FileRead implements IFileRead {

	/**
	 * FileRead constructor.
	 */
	public FileRead(){}

    /**
     * Reads a file into a ArrayList. Can be separated by new lines.
     * @param fileLocation  Location of the file to read.
     * @return An ArrayList filled with the date in the file.
     */
    @Override
    public ArrayList<String> readfileArrayList(String fileLocation) {
    	ArrayList<String> listData = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	String [] lineData = line.split("\n");
		    	for ( int i = 0; i < lineData.length; i++ ) {
		    		listData.add(lineData[i]);
		    	}
		    }
		} catch (IOException e) {
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
