package edu.wmich.cs3310.hw2.Thompson.stacks;

/**
 * IStack interface used for making new stacks of all kinds and types.
 * @author Tyler Thompson
 * @param <E> Can be used with all data types.
 */
public interface IStack<E> {

    	/**
	 * Pops the top element of the stack.
	 * @return E the element popped.
	 */
	E pop();
	
	/**
	 * Pushes the passed data on to the stack.
	 * @param data  the data to push to the stack.
	 */
	void push(E data);
	
	/**
	 * Returns the minimum value in the stack.
	 * @return E the min value.
	 */
	E minValue();
	
	/**
	 * Returns the size of the stack.
	 * @return int the size of the stack.
	 */
	int size();
	
	/**
	 * Gets the type of data that is in the queue.
	 * @return The type as a string.
	 */
	String getType();
}
