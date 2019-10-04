package edu.wmich.cs3310.hw2.Thompson.nodes;

/**
 * Provides the SingleNode class. To be used in a singly linked list.
 * @author Tyler Thompson
 *
 * @param <E> Can be used with all data type.
 */
public class SingleNode<E> implements ISingleNode<E> {

	private E data;
	private SingleNode<E> last;
	
	/**
	 * SingleNode constructor. Creates a new node. 
	 * @param data  The data to be stored in the node.
	 */
	public SingleNode(E data) {
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
	 * Returns the node before this node.
	 * @return Node before this node.
	 */
	@Override
	public ISingleNode<E> getLast() {
		return this.last;
	}

	/**
	 * Sets node received as the last node to this node.
	 * @param last  New last node.
	 */
	@Override
	public void setLast(ISingleNode<E> last) {
		this.last = (SingleNode<E>) last;
	}


}
