package edu.wmich.cs3310.hw2.Thompson.nodes;

/**
 * Provides the interface for SingleNodes. These nodes only have alast pointer and are to be used in a singly linked list.
 * @author Tyler Thompson
 *
 * @param <E> Can be used with all data types.
 */
public interface ISingleNode<E> {

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
	 * Returns the node before this node.
	 * @return Node before this node.
	 */
	ISingleNode<E> getLast();
	
	/**
	 * Sets node received as the last node to this node.
	 * @param last  New last node.
	 */
	void setLast(ISingleNode<E> last);
}
