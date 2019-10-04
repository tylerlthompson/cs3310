package edu.wmich.cs3310.hw2.Thompson.stacks;

import edu.wmich.cs3310.hw2.Thompson.queues.IQueue;
import edu.wmich.cs3310.hw2.Thompson.queues.Queue;

/**
 * Provides the DoubleQueueStack class used for making a stack implemented with two queues.
 * @author Tyler Thompson
 *
 * @param <E> accepts all data types.
 */
public class DoubleQueueStack<E extends Comparable<E>> implements IStack<E> {

	private IQueue<E> queue1;
	private IQueue<E> queue2;
	private int size;
	private E minValue;
	
	/**
	 * DoubleQueueStack constructor initializes a new stack.
	 */
	public DoubleQueueStack() {
		this.queue1 = new Queue<E>();
		this.queue2 = new Queue<E>();
		this.size = 0;
	}
	
	/**
	 * Pop the top element of the stack.
	 * @return E the element popped.
	 */
	@Override
	public E pop() {
		this.size--;
		E e = this.queue1.delete();
		if ( this.minValue == e ) {
			this.minValue = null;
		}
		return e;
	}

	/**
	 * Push a new element to the top of the stack.
	 * @param data  the data to push on the stack.
	 */
	@Override
	public void push(E data) {
		this.size++;
		if ( this.queue1.size() == 0 && this.queue2.size() == 0 ) {
			this.queue1.add(data);
			this.minValue = data;
		}
		else {
			this.queue2 = this.move(this.queue1, this.queue2);
			this.queue1.add(data);
			this.queue1 = this.move(this.queue2, this.queue1);
			if ( this.compare(data, this.minValue) == true ) {
				this.minValue = data;
			}
		}
	}

	/**
	 * Returns the minimum value in the stack.
	 * @return E the min value.
	 */
	@Override
	public E minValue() {
		if ( this.minValue == null ) {
			this.minValue = this.findMinValue();
			return this.minValue;
		}
		else {
			return this.minValue;
		}
	}
	
	/**
	 * Returns the size of the stack.
	 * @return int the size of the stack.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Private method. Finds the min value in the stack. Only used after the current min value is removed.
	 * @return E  the new min value.
	 */
	private E findMinValue() {
		return this.queue1.findMinValue();
	}
	
	/**
	 * Moves all elements from queue1 to queue2 while sustaining existing elements in queue2
	 * @param queue1 queue to move elements out of.
	 * @param queue2 queue to move elements into.
	 * @return IQueue<E>  queue with all the moved elements in it.
	 */
	private IQueue<E> move(IQueue<E> queue1, IQueue<E> queue2){
		int size = queue1.size();
		for ( int i = 0; i < size; i++ ) {
			queue2.add(queue1.delete());
		}
		return queue2;
	}

	/**
	 * Compares data1 to data2. If data1 is smaller than data2, then it returns true, otherwise it returns false.
	 * @param data1  data to compare to data2.
	 * @param data2  data to be compared to.
	 * @return true if data1 is smaller than data2, false otherwise.
	 */
	private boolean compare(E data1, E data2) {
	    int size1 = data1.toString().split("\\.")[0].length();
	    int size2 = data2.toString().split("\\.")[0].length();
	    if ( size1 > size2 ) {
		return false;
	    }
	    else {
		if ( data1.toString().compareTo(data2.toString()) < 0 ) {
			return true;
		}
		else {
			return false;
		}
	    }
	}

	/**
	 * Gets the type of data that is in the queue.
	 * @return The type as a string.
	 */
	@Override
	public String getType() {
	    return this.queue1.getType();
	}
}
