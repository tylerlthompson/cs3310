package edu.wmich.cs3310.hw2.Thompson.queues;

/**
 * Provides the IQueue interface for making new queues of all types.
 * @author Tyler Thompson
 * @param <E> Can be used with all data types.
 */
public interface IQueue<E> {

    	/**
    	 * Dequeue the first element in the queue and return it.
    	 * @return E  the first element in the queue.
    	 */
	E delete();
	
	/**
	 * Enqueue an element to the back of the queue.
	 * @param data  The data to be enqueued.
	 */
	void add(E data);
	
	/**
	 * get the size of the queue.
	 * @return The size of the queue as an int.
	 */
	int size();
	
	/**
	 * Gets the type of data that is in the queue.
	 * @return The type as a string.
	 */
	String getType();
	
	/**
	 * Searches the queue for the minimum value after the minimum values has been dequeued.
	 * @return E  The minimum value.
	 */
	E findMinValue();
}
