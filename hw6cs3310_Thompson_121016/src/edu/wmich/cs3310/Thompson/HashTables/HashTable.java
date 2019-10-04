package edu.wmich.cs3310.Thompson.HashTables;

import java.util.ArrayList;

import edu.wmich.cs3310.Thompson.FileReaderWriters.FileReaderWriter;
import edu.wmich.cs3310.Thompson.FileReaderWriters.IFileReaderWriter;

/**
 * Provides the HashTable class that implements the IHashtable interface.
 * @author Tyler Thompson
 *
 */
public class HashTable implements IHashTable {

    	private IFileReaderWriter frw;
    	private String hashTableFile;
    
    /**
     * HashTable constructor 
     * @param hashTableFile The file to use as your hash table.
     */
	public HashTable(String hashTableFile){
	    this.hashTableFile = hashTableFile;
	    this.frw = new FileReaderWriter(this.hashTableFile);
	}
	
	/**
     * Turns a name into a hash value. This is the main hash function.
     * @param name The name to hash.
     * @return The hash value as an int.
     */
	@Override
	public int getHashValueFromName(String name) {
		int hash = 7;
		for ( int i = 0; i < name.length(); i++ ) {
    			hash = hash^((name.charAt(i) * (i + 1) ) % 97 );
		}
		return hash;
	}
	
	/**
	 * Looks in the hash table and returns a name based on the hash value.
	 * @param hashValue The hash value associated with a name.
	 * @return The name associated with the specified hash value. Unless it does not exist in the hash table.
	 */
	@Override
	public String getNameFromHashValue(int hashValue) {
		String name = this.frw.readLine(hashValue);
		if ( name.equals("") ) {
		    return "Name at that index does not exist.";
		}
		else {
		    return name;
		}
	}

	 /**
     * Adds a new name to the hash table.
     * @param name The name to add to the hash table.
     */
	@Override
	public void add(String name) {
	    System.out.print("  INSERT: ");
		int hashValue = this.getHashValueFromName(name);
		System.out.println("Successfully added " + name + " to index " + hashValue + "\n");
		frw.writeLine(hashValue, hashValue + ":" + name);
	}

	/**
     * Deletes a name from the hash table.
     * @param name The name to delete from the table.
     */
	@Override
	public void delete(String name) {
	    System.out.print("  DELETE: ");
		int key = this.getHashValueFromName(name);
		String existingValue = this.frw.readLine(key);
		//System.out.println("Existing Value: " + existingValue);
		if ( existingValue.equals(name)) {
		    this.frw.writeLine(key, "");
		    System.out.println("Success, " + name + " was deleted from index " + key + "\n");
		}
		else {
		    System.out.println("Failure, " + name + " was not found in hash table." + "\n");
		}
	}

	/**
     * Prints the hash table.
     */
	@Override
	public void printTable() {
		System.out.println("\n  # Current Hash Table ( index:name ) #");
		System.out.println("    File Name: " + this.hashTableFile);
		ArrayList<String> table = this.frw.readFile();
		for ( int i = 0; i < table.size(); i++ ) {
		    if ( table.get(i).equals("")) {}
		    else {
			System.out.println("\t" + table.get(i));
		    }
		}
		System.out.println();
	}

}
