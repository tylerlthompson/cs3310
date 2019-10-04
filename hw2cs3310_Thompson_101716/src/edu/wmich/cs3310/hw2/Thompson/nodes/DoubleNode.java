package edu.wmich.cs3310.hw2.Thompson.nodes;

/**
 * Provides the DoubleNode class to be used with a doubly linked list.
 * @author Tyler Thompson
 *
 * @param <E> Can be used with all data types.
 */
public class DoubleNode<E> implements IDoubleNode<E> {

	private IDoubleNode<E> next;
	private IDoubleNode<E> last;
	private E data;

	/**
	 * DoubleNode constructor. Creates a new node.
	 * @param data  the data to be held in the node.
	 */
	public DoubleNode(E data) {
		this.setData(data);
	}
	
	/**
	 * Returns the data stored in this node.
	 * @return	Data in this node.
	 */
	@Override
	public E getData() {
		return this.data;
	}
	
	/**
	 * Setter for data for this node.
	 * @param data	New data
	 */
	@Override
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Returns the node next to this node.
	 * @return	Node next to this node.
	 */
	@Override
	public IDoubleNode<E> getNext() {
		return this.next;
	}

	/**
	 * Sets node received as the next node to this node.
	 * @param next	New next node.
	 */
	@Override
	public void setNext(IDoubleNode<E> next) {
		this.next = next;
	}

	/**
	 * Returns the node before this node.
	 * @return Node before this node.
	 */
	@Override
	public IDoubleNode<E> getLast() {
		return this.last;
	}

	/**
	 * Sets node received as the last node to this node.
	 * @param last  New last node.
	 */
	@Override
	public void setLast(IDoubleNode<E> last) {
		this.last = last;
	}

}
