package edu.wmich.cs3310.Thompson.FileReaders;

import java.util.ArrayList;

/**
 * Provides the Interface for the FileRead class for reading files.
 * @author Tyler Thompson
 *
 */
public interface IFileRead {

    /**
     * Reads a file into a ArrayList. Can be separated by new lines.
     * @param fileLocation  Location of the file to read.
     * @return An ArrayList filled with the date in the file.
     */
    ArrayList<String> readfileArrayList( String fileLocation );
    
}
