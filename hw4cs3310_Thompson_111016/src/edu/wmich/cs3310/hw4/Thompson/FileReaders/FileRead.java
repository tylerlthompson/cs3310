package edu.wmich.cs3310.hw4.Thompson.FileReaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import edu.wmich.cs3310.hw4.Thompson.lists.ILinkedList;
import edu.wmich.cs3310.hw4.Thompson.lists.LinkedList;

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
     * Reads a file into a LinkList. Can be separated by spaces, new lines or tabs.
     * @param fileLocation  Location of the file to read.
     * @return A linked list filled with the data in the file.
     */
    @Override
    public ILinkedList<String> readFile(String fileLocation) {
    	ILinkedList<String> listData = new LinkedList<String>();
    	try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
    		for(String line; (line = br.readLine()) != null; ) {
    			String [] lineData = line.split("\\s+");
    			for ( int i = 0; i < lineData.length; i++ ) {
    				listData.add(lineData[i]);
    			}
    		}
    	} catch (IOException e) {
    		ILinkedList<String> error = new LinkedList<String>();
    		error.add("Error reading file");
    		return error;
    	}
    	ILinkedList<String> data = new LinkedList<String>();
    	for ( int i = 0; i < listData.size(); i++ ) {
    		data.add(listData.get(i));
    	}
    	return data;
    }

    /**
     * Reads a file into a ArrayList. Can be separated by spaces, new lines or tabs.
     * @param fileLocation  Location of the file to read.
     * @return An ArrayList filled with the date in the file.
     */
    @Override
    public ArrayList<String> readfileArrayList(String fileLocation) {
    	ArrayList<String> listData = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	String [] lineData = line.split("\\s+");
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
