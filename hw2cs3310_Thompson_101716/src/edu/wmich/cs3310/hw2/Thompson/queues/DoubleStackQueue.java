package edu.wmich.cs3310.hw2.Thompson.queues;

import edu.wmich.cs3310.hw2.Thompson.stacks.IStack;
import edu.wmich.cs3310.hw2.Thompson.stacks.Stack;

/**
 * Provides the DoubleStackQueue class for making queues with two stacks.
 * @author Tyler Thompson
 *
 * @param <E> Can be used with all data types.
 */
public class DoubleStackQueue<E extends Comparable<E>> implements IQueue<E> {

	private IStack<E> stack1;
	private IStack<E> stack2;
	private int size;
	
	/**
	 * DoubleStackQueue constructor. Makes a new empty queue.
	 */
	public DoubleStackQueue() {
		this.size = 0;
		this.stack1 = new Stack<E>();
		this.stack2 = new Stack<E>();
	}
	
	/**
    	 * Dequeue the first element in the queue and return it.
    	 * @return E  the first element in the queue.
    	 */
	@Override
	public E delete() {
		this.size--;
		this.stack2 = this.move(stack1);
		E e = this.stack2.pop();
		this.stack1 = this.move(stack2);
		return e;
	}

	/**
	 * Enqueue an element to the back of the queue.
	 * @param data  The data to be enqueued.
	 */
	@Override
	public void add(E data) {
		this.size++;
		this.stack1.push(data);
	}

	/**
	 * get the size of the queue.
	 * @return The size of the queue as an int.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Private method, used to move all elements in one stack to the other.
	 * @param stack The stack to pop all the elements out of and move them to the new stack.
	 * @return IStack<E> The new stack with all the elements in reverse order.
	 */
	private IStack<E> move(IStack<E> stack) {
		IStack<E> tempStack = new Stack<E>();
		int tempSize = stack.size();
		for ( int i = 0; i < tempSize; i++ ) {
			tempStack.push((E) stack.pop());
		}
		return tempStack;
	}

	/**
	 * Gets the type of data that is in the queue.
	 * @return The type as a string.
	 */
	@Override
	public String getType() {
	    return this.stack1.getType();
	}

	/**
	 * Searches the queue for the minimum value after the minimum values has been dequeued.
	 * @return E  The minimum value.
	 */
	@Override
	public E findMinValue() {
	    return this.stack1.minValue();
	}
	
}
