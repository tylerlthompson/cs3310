package edu.wmich.cs3310.hw4.Thompson.lists;

/**
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type.
 */
public interface INode<E> {

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
	INode<E> getNext();
	/**
	 * Sets node received as the next node to this node.
	 * @param next	New next node.
	 */
	void setNext(INode<E> next);
	/**
	 * Returns the node before this node.
	 * @return Node before this node.
	 */
	INode<E> getLast();
	/**
	 * Sets node received as the last node to this node.
	 * @param last  New last node.
	 */
	void setLast(INode<E> last);
	
}
