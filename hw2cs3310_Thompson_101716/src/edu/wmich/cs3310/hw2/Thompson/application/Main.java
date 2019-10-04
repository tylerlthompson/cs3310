package edu.wmich.cs3310.hw2.Thompson.application;

import java.io.*;
import java.util.*;
import edu.wmich.cs3310.hw2.Thompson.queues.DoubleStackQueue;
import edu.wmich.cs3310.hw2.Thompson.queues.IQueue;
import edu.wmich.cs3310.hw2.Thompson.queues.Queue;
import edu.wmich.cs3310.hw2.Thompson.stacks.DoubleQueueStack;
import edu.wmich.cs3310.hw2.Thompson.stacks.IStack;
import edu.wmich.cs3310.hw2.Thompson.stacks.Stack;

/**
 * Main Class. Runs test on all of the implemented data structures with various different data types.
 * @author Tyler Thompson
 *
 */
public class Main {

	/**
	 * Main method. uncomment "runTestProgram();" to see a more extensive test of the different implementations.
	 * @param args
	 */
	public static void main(String[] args) {
	    
	    //Uncomment to following line to run a more extensive test of all implementations with various data types.
	    //runTestProgram();
	    
	    long curTime = System.currentTimeMillis();
	    
	    runTestProgramFromFile("./TestForMinValue.txt");
	    runTestProgramFromFile("./TestForStackAndQueue.txt");
//	    runTestProgramFromFile("./TestInput.txt");
//	    runTestProgramFromFile("./LargeTestInput.txt");
	    
	    long afterTime = System.currentTimeMillis();
	    long runTime = afterTime - curTime;
	    System.out.println("Runtime: " + runTime + " milliseconds");
	}
	
	/**
	 * Runs a test of all implementations on the file specified. Since the data is read in as a string, it only tests on strings. 
	 * To test on data other then strings, run runTestProgram()
	 * @param file  File to run tests on.
	 */
	public static void runTestProgramFromFile( String file ) {
	    System.out.println("Running test on file: " + file + "\n");
	    String[] stringArray = readFile(file);
	    
	    IStack<String> stringStack = new Stack<String>();
	    IQueue<String> stringQueue = new Queue<String>();
	    IStack<String> stringDoubleQueueStack = new DoubleQueueStack<String>(); 
	    IQueue<String> stringDoubleStackQueue = new DoubleStackQueue<String>(); 
	    
	    fillStackString(stringStack, stringArray);
	    fillQueueString(stringQueue, stringArray);
	    stringDoubleQueueStack = fillStackString(stringDoubleQueueStack, stringArray);
	    fillQueueString(stringDoubleStackQueue, stringArray);
	    stringDoubleQueueStack.pop();
	    printStack(stringStack);
	    printQueue(stringQueue);
	    printStack(stringDoubleQueueStack);
	    printQueue(stringDoubleStackQueue);
	    System.out.println("Done.\n");
	}

	/**
	 * Reads data in a file and returns it in an array of type string.
	 * @param fileLocation  Location of the file to read.
	 * @return The data in the file split up into a String array.
	 */
	public static String[] readFile( String fileLocation ) {
	    ArrayList<String> listData = new ArrayList<String>();
	    try(BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
		    for(String line; (line = br.readLine()) != null; ) {
			String [] lineData = line.split("\\s+");
			for ( int i = 0; i < lineData.length; i++ ) {
			    listData.add(lineData[i]);
			}
		        
		    }
		} catch (IOException e) {
		    String[] error = { "Error", "reading", "file" };
		    return error;
		}
	    String[] data = new String[listData.size()];
	    for ( int i = 0; i < listData.size(); i++ ) {
		data[i] = listData.get(i);
	    }
	    return data;
	}
	
	/**
	 * Runs through all of the implementations with a few different data types.
	 */
	public static void runTestProgram() {
	    String[] stringArray = { "1.02", "45", "1.001", "100", "2", "345", "50", "4.6", "8", "0" };
	    	int[] intArray = { 9, 8, 17, 3, 5, 4, 5, 2, 1, 0 };
	    	double[] doubleArray = { 23.3, 0.002, 23.3, 234.54345, 234.2, 2.2, 43.768, 0.0, };
	    	float[] floatArray = { 234.3f, 234.45f, 0.00001f, 6.6f, 234.4f, 2340f, 26.2f, 0.0f };
	    	long[] longArray = { 32423423L, 23458354L, 23458374598L, 238471857L, 9230943L, 489375L, 23423435345L, 0L };
	    	
		IStack<String> stringStack = new Stack<String>(); 
		fillStackString(stringStack, stringArray);
		IStack<Integer> intStack = new Stack<Integer>(); 
		fillStackInt(intStack, intArray);
		IStack<Double> doubleStack = new Stack<Double>(); 
		fillStackDouble(doubleStack, doubleArray);
		IStack<Float> floatStack = new Stack<Float>(); 
		fillStackFloat(floatStack, floatArray);
		IStack<Long> longStack = new Stack<Long>(); 
		fillStackLong(longStack, longArray);
		
		IQueue<String> stringQueue = new Queue<String>(); 
		fillQueueString(stringQueue, stringArray);
		IQueue<Integer> intQueue = new Queue<Integer>(); 
		fillQueueInt(intQueue, intArray);
		IQueue<Double> doubleQueue = new Queue<Double>(); 
		fillQueueDouble(doubleQueue, doubleArray);
		IQueue<Float> floatQueue = new Queue<Float>(); 
		fillQueueFloat(floatQueue, floatArray);
		IQueue<Long> longQueue = new Queue<Long>(); 
		fillQueueLong(longQueue, longArray);
		
		IStack<String> stringDoubleQueueStack = new DoubleQueueStack<String>(); 
		fillStackString(stringDoubleQueueStack, stringArray);
		IStack<Integer> intDoubleQueueStack = new DoubleQueueStack<Integer>(); 
		fillStackInt(intDoubleQueueStack, intArray);
		IStack<Double> doubleDoubleQueueStack = new DoubleQueueStack<Double>(); 
		fillStackDouble(doubleDoubleQueueStack, doubleArray);
		IStack<Float> floatDoubleQueueStack = new DoubleQueueStack<Float>(); 
		fillStackFloat(floatDoubleQueueStack, floatArray);
		IStack<Long> longDoubleQueueStack = new DoubleQueueStack<Long>(); 
		fillStackLong(longDoubleQueueStack, longArray);
		
		IQueue<String> stringDoubleStackQueue = new DoubleStackQueue<String>(); 
		fillQueueString(stringDoubleStackQueue, stringArray);
		IQueue<Integer> intDoubleStackQueue = new DoubleStackQueue<Integer>(); 
		fillQueueInt(intDoubleStackQueue, intArray);
		IQueue<Double> doubleDoubleStackQueue = new DoubleStackQueue<Double>(); 
		fillQueueDouble(doubleDoubleStackQueue, doubleArray);
		IQueue<Float> floatDoubleStackQueue = new DoubleStackQueue<Float>(); 
		fillQueueFloat(floatDoubleStackQueue, floatArray);
		IQueue<Long> longDoubleStackQueue = new DoubleStackQueue<Long>(); 
		fillQueueLong(longDoubleStackQueue, longArray);
		
		printStack(stringStack);
		printStack(intStack);
		printStack(doubleStack);
		printStack(floatStack);
		printStack(longStack);
		
		printQueue(stringQueue);
		printQueue(intQueue);
		printQueue(doubleQueue);
		printQueue(floatQueue);
		printQueue(longQueue);
		
		printStack(stringDoubleQueueStack);
		printStack(intDoubleQueueStack);
		printStack(doubleDoubleQueueStack);
		printStack(floatDoubleQueueStack);
		printStack(longDoubleQueueStack);
		
		printQueue(stringDoubleStackQueue);
		printQueue(intDoubleStackQueue);
		printQueue(doubleDoubleStackQueue);
		printQueue(floatDoubleStackQueue);
		printQueue(longDoubleStackQueue);
	}
	
	/**
	 * Fills a queue of type int.
	 * @param queue  The queue to fill.
	 * @param array  The array of data to fill the queue with.
	 * @return IQueue  The queue filled with the passed data.
	 */
	public static IQueue<Integer> fillQueueInt(IQueue<Integer> queue, int[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		queue.add(array[i]);
	    }
	    return queue;
	}
	
	/**
	 * Fills a queue of type string.
	 * @param queue  The queue to fill.
	 * @param array  The array of data to fill the queue with.
	 * @return IQueue  The queue filled with the passed data.
	 */
	public static IQueue<String> fillQueueString(IQueue<String> queue, String[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		queue.add(array[i]);
	    }
	    return queue;
	}
	
	/**
	 * Fills a queue of type double.
	 * @param queue  The queue to fill.
	 * @param array  The array of data to fill the queue with.
	 * @return IQueue  The queue filled with the passed data.
	 */
 	public static IQueue<Double> fillQueueDouble(IQueue<Double> queue, double[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		queue.add(array[i]);
	    }
	    return queue;
	}
	
 	/**
	 * Fills a queue of type float.
	 * @param queue  The queue to fill.
	 * @param array  The array of data to fill the queue with.
	 * @return IQueue  The queue filled with the passed data.
	 */
 	public static IQueue<Float> fillQueueFloat(IQueue<Float> queue, float[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		queue.add(array[i]);
	    }
	    return queue;
	}
	
 	/**
	 * Fills a queue of type long.
	 * @param queue  The queue to fill.
	 * @param array  The array of data to fill the queue with.
	 * @return IQueue  The queue filled with the passed data.
	 */
 	public static IQueue<Long> fillQueueLong(IQueue<Long> queue, long[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		queue.add(array[i]);
	    }
	    return queue;
	}
	
 	/**
 	 * Fills a stack of type int.
 	 * @param stack  The stack to fill with data.
 	 * @param array  The array of data to fill the stack with.
 	 * @return IStack  The stack filled with the passed data.
 	 */
 	public static IStack<Integer> fillStackInt(IStack<Integer> stack, int[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		stack.push(array[i]);
	    }
	    return stack;
	}
	
 	/**
 	 * Fills a stack of type string.
 	 * @param stack  The stack to fill with data.
 	 * @param array  The array of data to fill the stack with.
 	 * @return IStack  The stack filled with the passed data.
 	 */
 	public static IStack<String> fillStackString(IStack<String> stack, String[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		stack.push(array[i]);
	    }
	    return stack;
	}
	
 	/**
 	 * Fills a stack of type double.
 	 * @param stack  The stack to fill with data.
 	 * @param array  The array of data to fill the stack with.
 	 * @return IStack  The stack filled with the passed data.
 	 */
 	public static IStack<Double> fillStackDouble(IStack<Double> stack, double[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		stack.push(array[i]);
	    }
	    return stack;
	}
	
 	/**
 	 * Fills a stack of type float.
 	 * @param stack  The stack to fill with data.
 	 * @param array  The array of data to fill the stack with.
 	 * @return IStack  The stack filled with the passed data.
 	 */
	public static IStack<Float> fillStackFloat(IStack<Float> stack, float[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		stack.push(array[i]);
	    }
	    return stack;
	}
	
	/**
 	 * Fills a stack of type long.
 	 * @param stack  The stack to fill with data.
 	 * @param array  The array of data to fill the stack with.
 	 * @return IStack  The stack filled with the passed data.
 	 */
 	public static IStack<Long> fillStackLong(IStack<Long> stack, long[] array) {
	    for ( int i = 0; i < array.length; i++ ) {
		stack.push(array[i]);
	    }
	    return stack;
	}
	
 	/**
 	 * Dequeues all elements in the passed queue and prints them to the console.
 	 * If there are 1000 or more elements, it skips printing out all the elements.
 	 * @param queue  The queue to print.
 	 */
	public static <E> void printQueue(IQueue<E> queue) {
	    int size = queue.size();
	    System.out.println("Printing " + queue.getClass().getSimpleName() + " of type " + queue.getType() + " with " + size + " elements.");
		if ( size > 999 ) {
			System.out.println("Queue to large to print. Will only print queues with less than 1000 elements. Deleting values without printing.");
			for ( int i = 0; i < size; i++ ) {
				queue.delete();
			}
		}
		else {
			System.out.print("Front--> ");
			int j = 0;
			for ( int i = 0; i < size; i++ ) {
				j++;
				System.out.print(queue.delete() + " ");
				if ( j > 10 ) {
					System.out.println();
					j = 0;
				}
			}
			System.out.print("<--Back");
		}
		System.out.println("\n");
	}
	
	/**
	 * Pops all elements out of the passed stack and prints them to the console.
	 * If there are 1000 or more elements in the stack it skips printing them to the console.
	 * @param stack  The stack to print.
	 */
	public static <E> void printStack(IStack<E> stack) {
	    int size = stack.size();
	    System.out.println("Printing " + stack.getClass().getSimpleName() + " of type " + stack.getType() + " with " + size + " elements.");
		E minValue = stack.minValue();
		if ( size > 999 ) {
			System.out.println("Stack to large to print. Will only print stacks with less than 1000 elements. Poping values without printing.");
			for ( int i = 0; i < size; i++ ) {
				stack.pop();
			}
		}
		else {
			System.out.print("Top--> ");
			int j = 0;
			for ( int i = 0; i < size; i++ ) {
				j++;
				System.out.print(stack.pop() + " ");
				if ( j > 10 ) {
					System.out.println();
					j = 0;
				}
			}
			System.out.print("<--Bottom");
		}
		System.out.println("\nMin Value: " + minValue + "\n");
	}
}
