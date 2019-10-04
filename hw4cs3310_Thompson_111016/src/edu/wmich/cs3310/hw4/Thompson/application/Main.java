package edu.wmich.cs3310.hw4.Thompson.application;

import java.util.ArrayList;
import edu.wmich.cs3310.hw4.Thompson.FileReaders.*;
import edu.wmich.cs3310.hw4.Thompson.lists.ILinkedList;
import edu.wmich.cs3310.hw4.Thompson.sorts.*;

/**
 * Main class of the program. Runs tests on the specified file, reads them into an ArrayList and Linked list.
 * Then runs all of the sort algorithms on them.
 * @author Tyler Thompson
 * @since 11/10/2016
 */
public class Main {

    /**
     * Main Method. Change the file specified to be sent to "runProgram" to test different files.
     * @param args
     */
    public static void main(String[] args) {
    	runProgram("NameList.txt");
    }
    
    /**
     * Loads the specified file into an array list and linked list and then runs them both through all of the sorting algorithms.
     * @param inputFile  The file to be loaded.
     */
    public static void runProgram(String inputFile) {
    	IFileRead fr = new FileRead();
    	ILinkedList<String> testList = fr.readFile(inputFile);
    	ArrayList<String> testArrayList = fr.readfileArrayList(inputFile);
    	System.out.println("Running program on LinkedList..");
    	System.out.println("Original Unsorted List: ");
    	testList.printList();
    	System.out.println();
	
    	runTest("mergeSort", testList);
    	runTest("binaryInsertionSort", testList);
    	runTest("selectionSort", testList);
    	runTest("bubbleSort", testList);
	
    	System.out.println("Running program on built in ArrayList..");
    	System.out.println("Original Unsorted List: ");
    	printArrayList(testArrayList);
    	System.out.println();
	
    	runTestArrayList("mergeSort", testArrayList);
    	runTestArrayList("binaryInsertionSort", testArrayList);
    	runTestArrayList("selectionSort", testArrayList);
    	runTestArrayList("bubbleSort", testArrayList);
	
    }

    /**
     * Runs a single test on the specified LinkedList using the specified sorting method.
     * @param testType  The sorting method to use.
     * @param testList  The LinkedList with the data to sort.
     */
    public static void runTest(String testType, ILinkedList<String> testList) {
	ISort<String> sort = null;
	switch ( testType ) {
	case "bubbleSort":
	    sort = new BubbleSort<String>();
	    testType = testType + "\t\t";
	    break;
	case "selectionSort":
	    sort = new SelectionSort<String>();
	    testType = testType + "\t";
	    break;
	case "mergeSort":
	    sort = new MergeSort<String>();
	    testType = testType + "\t\t";
	    break;
	case "binaryInsertionSort":
	    sort = new BinaryInsertionSort<String>();
	    break;
	default:
	    System.out.println("Bad choice for sorting method.");
	    System.exit(0);
	}
	System.out.println( "Running " + testType + "...");
	 long curTime = System.currentTimeMillis();
	 sort.sort(testList);
	 long afterTime = System.currentTimeMillis();
	 testList.printList();
	 long runTime = afterTime - curTime;
	 System.out.println("Done. Run Time: " + runTime + " milliseconds.\n");
    }
    
    /**
     * Runs a single test on the specified ArrayList using the specified sorting method.
     * @param testType  The sorting method to use.
     * @param testList  The ArrayList with the data to sort.
     */
    public static void runTestArrayList(String testType, ArrayList<String> testList) {
	ISort<String> sort = null;
	switch ( testType ) {
	case "bubbleSort":
	    sort = new BubbleSort<String>();
	    testType = testType + "\t\t";
	    break;
	case "selectionSort":
	    sort = new SelectionSort<String>();
	    testType = testType + "\t";
	    break;
	case "mergeSort":
	    sort = new MergeSort<String>();
	    testType = testType + "\t\t";
	    break;
	case "binaryInsertionSort":
	    sort = new BinaryInsertionSort<String>();
	    break;
	default:
	    System.out.println("Bad choice for sorting method.");
	    System.exit(0);
	}
	System.out.println( "Running " + testType + "...");
	 long curTime = System.currentTimeMillis();
	 sort.sort(testList);
	 long afterTime = System.currentTimeMillis();
	 printArrayList(testList);
	 long runTime = afterTime - curTime;
	 System.out.println("Done. Run Time: " + runTime + " milliseconds.\n");
    }
    
    /**
     * Prints the ArrayList specified in a nice format.
     * @param list  The ArrayList to print out.
     */
    public static void printArrayList(ArrayList<String> list) {
	if ( list.size() > 100 ) {
	    System.out.println("List size is greater than 100, not printing. Size: " + list.size());
	    return;
	}
	for ( int i = 0; i < list.size(); i++ ) {
	    System.out.print(list.get(i) + "->");
	}
	System.out.println();
    }
    
    
}
