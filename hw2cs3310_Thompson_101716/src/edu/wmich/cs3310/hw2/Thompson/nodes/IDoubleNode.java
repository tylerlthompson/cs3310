package edu.wmich.cs3310.hw2.Thompson.nodes;

/**
 * Provides the interface for a node with last and next pointers to be used in a doubly linked list.
 * @author Tyler Thompson
 *
 * @param <E> Can be used with all data types.
 */
public interface IDoubleNode<E> {
	
	/**
	 * Returns the data stored in this node.
	 * @return	Data in this node.
	 */
	E getData();
	
	/**
	 * Setter for data for this node.
	 * @param data	New data
	 */
	void setData(E data);
	
	/**
	 * Returns the node next to this node.
	 * @return	Node next to this node.
	 */
	IDoubleNode<E> getNext();
	
	/**
	 * Sets node received as the next node to this node.
	 * @param next	New next node.
	 */
	void setNext(IDoubleNode<E> next);
	
	/**
	 * Returns the node before this node.
	 * @return Node before this node.
	 */
	IDoubleNode<E> getLast();
	
	/**
	 * Sets node received as the last node to this node.
	 * @param last  New last node.
	 */
	void setLast(IDoubleNode<E> last);
}
