package edu.wmich.cs3310.hw2.Thompson.stacks;

import edu.wmich.cs3310.hw2.Thompson.nodes.ISingleNode;
import edu.wmich.cs3310.hw2.Thompson.nodes.SingleNode;

/**
 * Provides the stack class used for making new stacks.
 * @author Tyler Thompson
 * @param <E> accepts all data types.
 */
public class Stack<E extends Comparable<E>> implements IStack<E> {
	
	private E minValue;
	private ISingleNode<E> head;
	private ISingleNode<E> tail;
	private int size;
	
	/**
	 * Stack constructor initializes a new stack.
	 */
	public Stack(){
		this.head = new SingleNode<E>(null);
		this.tail = new SingleNode<E>(null);
		this.minValue = null;
		this.size = 0;
	}
	
	/**
	 * Pops the top element of the stack.
	 * @return E the element popped.
	 */
	@Override
	public E pop() {
		this.size--;
		if ( this.head == this.tail) {
			E e = this.head.getData();
			this.head = null;
			this.tail = null;
			return e;
		}
		else {
			E e = this.tail.getData();
			this.tail = this.tail.getLast();
			if ( this.minValue == e ) {
				this.minValue = null;
			}
			return e;
		}
	}

	/**
	 * Pushes the passed data on to the stack.
	 * @param data  the data to push to the stack.
	 */
	@Override
	public void push(E data) {
		this.size++;
		
		if ( this.head.getData() == null ) {
			this.head.setData(data);
			this.tail = this.head;
			this.minValue = data;
		}
		else {
			ISingleNode<E> newNode = new SingleNode<E>(data);
			newNode.setLast(this.tail);
			this.tail = newNode;
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
		E min = this.tail.getData();
		ISingleNode<E> cur = this.tail;
		for ( int i = 0; i < this.size(); i++ ) {
			E curData = cur.getData();
			if ( this.compare(curData, min) == true ) {
				min = curData;
			}
			cur = cur.getLast();
		}
		
		return min;
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
	    return this.head.getData().getClass().getSimpleName();
	}
	
}
