package edu.wmich.cs3310.hw2.Thompson.queues;

import edu.wmich.cs3310.hw2.Thompson.nodes.DoubleNode;
import edu.wmich.cs3310.hw2.Thompson.nodes.IDoubleNode;

/**
 * Provides the Queue class for making new queues.
 * @author Tyler Thompson
 * @param <E> Can be used with all data types.
 */
public class Queue<E> implements IQueue<E> {

	private IDoubleNode<E> head;
	private IDoubleNode<E> tail;
	private int size;
	
	/**
	 * The Queue constructor. Creates a new empty queue.
	 */
	public Queue(){
		this.head = new DoubleNode<E>(null);
		this.tail = new DoubleNode<E>(null);
		this.size = 0;
	}
	
	/**
    	 * Dequeue the first element in the queue and return it.
    	 * @return E  the first element in the queue.
    	 */
	@Override
	public E delete() {
		this.size --;
		if ( this.head == this.tail ) {
			E e = this.head.getData();
			this.head = null;
			this.tail = null;
			return e;
		}
		else {
			E e = this.head.getData();
			this.head.getNext().setLast(null);
			this.head = this.head.getNext();
			return e;
		}
		
	}

	/**
	 * Enqueue an element to the back of the queue.
	 * @param data  The data to be enqueued.
	 */
	@Override
	public void add(E data) {
		this.size++;
		if ( this.head == null ) {
			this.head = new DoubleNode<E>(null);
			this.head.setData(data);
			this.tail = this.head;
		}
		else if ( this.head.getData() == null ) {
			this.head.setData(data);
			this.tail = this.head;
		}
		else {
			IDoubleNode<E> newNode = new DoubleNode<E>(data);
			newNode.setLast(this.tail);
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
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
	 * Gets the type of data that is in the queue.
	 * @return The type as a string.
	 */
	@Override
	public String getType(){
	    return this.head.getData().getClass().getSimpleName();
	}

	/**
	 * Searches the queue for the minimum value after the minimum value has been dequeued.
	 * @return E  The minimum value.
	 */
	@Override
	public E findMinValue() {
	    E min = this.tail.getData();
		IDoubleNode<E> cur = this.tail;
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
}
