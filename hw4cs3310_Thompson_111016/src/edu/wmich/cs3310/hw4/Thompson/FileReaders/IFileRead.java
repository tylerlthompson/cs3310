package edu.wmich.cs3310.hw4.Thompson.FileReaders;

import java.util.ArrayList;

import edu.wmich.cs3310.hw4.Thompson.lists.ILinkedList;

/**
 * Provides the Interface for the FileRead class for reading files.
 * @author Tyler Thompson
 *
 */
public interface IFileRead {

    /**
     * Reads a file into a LinkList. Can be separated by spaces, new lines or tabs.
     * @param fileLocation  Location of the file to read.
     * @return A linked list filled with the data in the file.
     */
    ILinkedList<String> readFile( String fileLocation );
 
    /**
     * Reads a file into a ArrayList. Can be separated by spaces, new lines or tabs.
     * @param fileLocation  Location of the file to read.
     * @return An ArrayList filled with the date in the file.
     */
    ArrayList<String> readfileArrayList( String fileLocation );
    
}
