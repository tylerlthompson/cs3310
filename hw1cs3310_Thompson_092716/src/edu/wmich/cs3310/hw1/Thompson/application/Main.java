/**
 * 
 */
package edu.wmich.cs3310.hw1.Thompson.application;

import edu.wmich.cs3310.hw1.Thompson.lists.ILinkedList;
import edu.wmich.cs3310.hw1.Thompson.lists.LinkedList;
import edu.wmich.cs3310.hw1.Thompson.sort.ISort;
import edu.wmich.cs3310.hw1.Thompson.sort.Sort;

import java.util.*;
/**
 * @author Tyler Thompson
 *
 */
public class Main {

	/**
	 * The Main method. First piece of code to run.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (true) {
			int n = getInput(kb, "\nSet a value for n (How many random numbers to generate): ");
			int m = getInput(kb, "\nSet a value for m (The largest value of any number): ");
			int r = getInput(kb, "\nSet a value for r (How many time to run the program with these values): ");
			System.out.println();
			for ( int i = 0; i < r; i++ ) {
				long curTime = System.currentTimeMillis();
				System.out.println("\n### RUN: " + (i + 1) + " ###\n");
				runProgram(n, m);
				long afterTime = System.currentTimeMillis();
				long runTime = afterTime - curTime;
				System.out.println("\n### Total Run Time: " + runTime + " milliseconds ###");
			}
			int i = getInput(kb, "\nDo you want to run the program again?\n4 - Yes, run again.    5 - No, exit.\n");
			if ( i == 5 ) {
				kb.close();
				break;
			}
		}
		System.exit(0);
	}
	
	/**
	 * Runs the program specified in the HW1 assignment
	 * @param n  How many number to randomly generate.
	 * @param max  The largest value of any number.
	 */
	public static void runProgram(int n, int max) {
		long curTime = System.currentTimeMillis();
		long afterTime, runTime;
		ILinkedList list = new LinkedList();
		int[] array = new int[n];
		int rand;
		ISort sort = new Sort();
		int min = 1;
		for ( int i = 0; i < n; i++) {
			rand = randInt(min, max);
			list.add(rand);
			array[i] = rand;
		}
		System.out.println("\nRunning program with Doubly Linked List built by Tyler Thompson.\n");
		
		list.printList();
		
		int intsOverFifty = list.getOver(50);
		if ( intsOverFifty > 5 ) {
			System.out.println("More than 5 numbers are over 50. Sorting data in a Non-decreasing order.");
			sort.quickShortIncreasing(list, 0, n-1);
			list.printList();
			System.out.println("Deleting the 5th element at index 4.");
			list.remove(4);
			list.printList();
			System.out.println("Inseting the number 10 into its' correct place in the list");
			list.insertSortedIncreasing(10);
			afterTime = System.currentTimeMillis();
		}
		else {
			System.out.println("Less than or equal to 5 numbers are over 50. Sorting data in a Non-increasing order.");
			sort.quickSortDecreasing(list, 0, n-1);
			list.printList();
			System.out.println("Deleting the 2nd element at index 1.");
			list.remove(1);
			list.printList();
			System.out.println("Inseting the number 10 into its' correct place in the list");
			list.insertSortedDecreasing(10);
			afterTime = System.currentTimeMillis();
		}
		list.printList();
		
		runTime = afterTime - curTime;
		System.out.println("\t### Run Time: " + runTime + " milliseconds ###");
		
		System.out.println("\nRunning program again with built-in Array of type Integer.\n");
		curTime = System.currentTimeMillis();
		printArray(array);
		intsOverFifty = getOverArray(array, 50);
		
		if ( intsOverFifty > 5 ) {
			System.out.println("More than 5 numbers are over 50. Sorting data in a Non-decreasing order.");
			sort.quickSortIncreasingArray(array, 0, n-1);
			printArray(array);
			System.out.println("Deleting the 5th element at index 4.");
			array = removeArrayIndex(array, 4);
			printArray(array);
			System.out.println("Inseting the number 10 into its' correct place in the list");
			array = insertSortedIncreasing(array, 10);
			afterTime = System.currentTimeMillis();
		}
		else {
			System.out.println("Less than or equal to 5 numbers are over 50. Sorting data in a Non-increasing order.");
			sort.quickSortDecreasingArray(array, 0, n-1);
			printArray(array);
			System.out.println("Deleting the 2nd element at index 1.");
			array = removeArrayIndex(array, 1);
			printArray(array);
			System.out.println("Inseting the number 10 into its' correct place in the list");
			array = insertSortedDecreasing(array, 10);
			afterTime = System.currentTimeMillis();
		}
		printArray(array);
		
		runTime = afterTime - curTime;
		System.out.println("\t### Run Time: " + runTime + " milliseconds ###");
	}
	
	/**
	 * Remove an integer from an integer array at a specified index.
	 * @param array  Integer array to work with.
	 * @param index  The index of the number to remove.
	 * @return  The array after the specified integer was removed.
	 */
	public static int[] removeArrayIndex(int[] array, int index) {
		int j = 0;
		int[] tempArray = new int[array.length - 1];
		for ( int i = 0; i < array.length; i++ ) {
			if ( i != index ) {
				tempArray[j] = array[i];
				j++;
			}
		}
		return tempArray;
	}
	
	/**
	 * Inserts an integer into an integer array at the specified index.
	 * @param array  Int array you want to insert a number into.
	 * @param index  Index at which you want to insert the number.
	 * @param insert  The integer you want to insert.
	 * @return The int array with the new number inserted.
	 */
	public static int[] insertArrayIndex(int[] array, int index, int insert) {
		int[] tempArray = new int[array.length + 1];
		int j = 0;
		for ( int i = 0; i < tempArray.length; i++ ) {
			if ( i == index ) {
				tempArray[i] = insert;
			}
			else {
				tempArray[i] = array[j];
				j++;
			}
		}
		return tempArray;
	}
	
	/**
	 * Insert an Integer into an int array that is already sorted increasingly from left to right.
	 * @param list  The int array you want to insert a number into.
	 * @param insert Integer you want to insert.
	 * @return An Integer array with the new value inserted.
	 */
	public static int[] insertSortedIncreasing( int[] list, int insert) {
		for ( int i = 0; i < list.length; i++ ) {
			if ( list[i] >= insert ) {
				list = insertArrayIndex(list, i, insert);
				break;
			}
		}
		return list;
	}
	
	/**
	 * Insert an integer into an int array that is sorted decreasing from left to right.
	 * @param list  Integer array you want to insert a value into.
	 * @param insert  Integer you want to insert.
	 * @return An Integer array with the new value inserted.
	 */
	public static int[] insertSortedDecreasing( int[] list, int insert) {
		boolean toggle = false;
		for ( int i = 0; i < list.length; i++ ) {
			if ( list[i] < insert ) {
				list = insertArrayIndex(list, i, insert);
				toggle = true;
				break;
			}
		}
		if ( toggle == false ) {
			list = insertArrayIndex(list, list.length, insert);
		}
		return list;
	}
	
	/**
	 * Get how many numbers are over the specified number in an integer array.	
	 * @param list  Integer array you want to search.
	 * @param over  Integer you are looking to find how many are over.
	 * @return How many numbers are over the specified integer.
	 */
	public static int getOverArray( int[] list, int over) {
		int j = 0;
		for ( int i = 0; i < list.length; i++ ) {
			if ( list[i] > over ) {
				j++;
			}
		}
		return j;
	}
	
	/**
	 * Prints an integer array.
	 * @param list  Integer array you want to print.
	 */
	public static void printArray( int[] list) {
		for ( int i = 0; i < list.length; i++ ) {
            String e;
            if (i == list.length -1 ) {
                    e = "";
            }
            else {
                    e = "->";
            }
            System.out.print(list[i] + e);
		}
		System.out.println();
	}
	
	
	/**
	 * Generates a random integer.
	 * @param min  Minimum value that the random integer can be.
	 * @param max  Maximum value that the random integer can be.
	 * @return  A random integer within the range specified.
	 */
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	/**
	 * gets user input of type int, validates it, and then returns it if it is valid, otherwise will keep asking for input.
	 * @return validated user input.
	 */
	public static int getInput(Scanner kb, String message) {
		
		System.out.print(message);
		String input = kb.nextLine();
		if (validateInput(input) == true) {
			if ( Integer.parseInt(input) < 3 ) {
				System.out.println("\nError: Input must be an integer greater than or equal to 3.\nPlease input text again.\n");
				return getInput(kb, message);
			}
			else {
				return Integer.parseInt(input);
			}
		}
		else {
			System.out.println("\nError: Input must be integer.\nPlease input text again.\n");
			return getInput(kb, message);
		}
	}
	
	/**
	 * method validates input and returns false if input is not valid and true if the input is valid.
	 * @param input	string containing the data you would like to verify
	 * @return returns true if the input is valid and false if the input is not valid
	 */
	public static boolean validateInput(String input) {
		boolean validate = true;
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			validate = false;
		} catch (NullPointerException e) {
			validate = false;
		}
		return validate;
	}//end validateInput()
}
