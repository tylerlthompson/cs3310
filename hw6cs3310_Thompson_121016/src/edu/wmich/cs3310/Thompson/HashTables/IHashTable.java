package edu.wmich.cs3310.Thompson.HashTables;

/**
 * Provides the IHashTable interface for creating new hash tables.
 * @author Tyler Thompson
 *
 */
public interface IHashTable {

	/**
	 * Looks in the hash table and returns a name based on the hash value.
	 * @param hashValue The hash value associated with a name.
	 * @return The name associated with the specified hash value. Unless it does not exist in the hash table.
	 */
    String getNameFromHashValue(int hashValue);
    
    /**
     * Turns a name into a hash value. This is the main hash function.
     * @param name The name to hash.
     * @return The hash value as an int.
     */
    int getHashValueFromName(String name);
    
    /**
     * Adds a new name to the hash table.
     * @param name The name to add to the hash table.
     */
    void add(String name);
    
    /**
     * Deletes a name from the hash table.
     * @param name The name to delete from the table.
     */
    void delete(String name);
    
    /**
     * Prints the hash table.
     */
    void printTable();
    
}
