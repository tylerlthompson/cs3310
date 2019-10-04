package edu.wmich.cs3310.Thompson.application;

import java.util.Scanner;

import edu.wmich.cs3310.Thompson.HashTables.HashTable;
import edu.wmich.cs3310.Thompson.HashTables.IHashTable;

/**
 * Assignment 6: Hashing. Provides an interactive menu for manipulating a hash table.
 * @author Tyler Thompson
 *
 */
public class Main {

    /**
     * The Main method. Set your hash table file here and the program does the rest.
     * @param args
     */
    public static void main(String[] args) {
    	String hashTableFile = "HashTable.txt";
    	menu(hashTableFile);
    }

    /**
     * The main menu. Handles getting user input and executing commands.
     * @param hashTableFile The file to use as your hash table.
     */
    public static void menu(String hashTableFile) {
    	System.out.println("### Assignment 6: Hashing ### \n    Author: Tyler Thompson\n");
    	Scanner kb = new Scanner(System.in);
    	IHashTable table = new HashTable(hashTableFile);
    	while ( true ) {
    		System.out.println(" ## Main Menu ##\n 1. Add Student \n 2. Find Student \n 3. Delete Student \n 4. Print Hash Table \n 5. Exit \n");
    		int input = getInputInt(kb);
    		executeCommand(input, table, kb);
    	}
    }
    
    /**
     * Gets user input that should only be a string.
     * @param kb The keyboard scanner
     * @param message Message to send to the user.
     * @return The user's input as a string.
     */
    public static String getInputString(Scanner kb, String message) {
    	System.out.println(message);
    	System.out.print(">");
    	String input = kb.nextLine();
    	return input;
    }
    
    /**
     * Gets user input that should only be an integer and should only be 1, 2, 3, 4, or 5.
     * @param kb The keyboard scanner.
     * @return The user's input as an int.
     */
    public static int getInputInt(Scanner kb) {
    	System.out.print(">");
    	String input = kb.nextLine();
    	int inputInt;
    	try {
    		inputInt = Integer.valueOf(input);
    		if ( inputInt != 1 && inputInt != 2 && inputInt != 3 && inputInt != 4 && inputInt != 5 ) {
    			System.out.println("Please input 1, 2, 3, 4, or 5.");
    			return getInputInt(kb);
    		}
    	} catch (Exception e) {
    		System.out.println("Bad input. Please input an integer.");
    		return getInputInt(kb);
    	}
    	return inputInt;
    }
    
    public static void executeCommand(int command, IHashTable table, Scanner kb) {
    	switch ( command ) {
    	case 1: //add
    		table.add(getInputString(kb, "  Name of Student to add?"));
    		break;
    	case 3: //delete
    		table.delete(getInputString(kb, "  Name of student to delete?"));
    		break;
    	case 2: //find
    		int hashKey = 0;
    		String name = "Name not found";
    		String arg = getInputString(kb, "  Name or Hash key of Student to find?");
    		try {
    			hashKey = Integer.valueOf(arg);
    			name = table.getNameFromHashValue(hashKey);
    		}catch (Exception e) {
    			name = arg;
    			hashKey = table.getHashValueFromName(name);
    			name = table.getNameFromHashValue(hashKey);
    		}
    		System.out.println("\n" + name + " : " + hashKey + "\n");
    		break;
    	case 4: //print
    		table.printTable();
    		break;
    	case 5: //exit
    		System.out.println("Exiting...");
    		kb.close();
    		System.exit(0);
    		break;
    	default:
    		System.out.println("Bad command: " + command);
    		break;
    	}
    }
    
}
