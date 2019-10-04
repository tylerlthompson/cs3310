package edu.wmich.cs3310.hw1.Thompson.lists;

/**
 * Provide the INode interface used for creating LinkedLists.
 * @author Tyler Thompson
 *
 */
public interface INode {

	/**
	 * Returns the data stored in this node.
	 * @return	Data in this node.
	 */
	int getData();
	
	/**
	 * Setter for data for this node.
	 * @param data	New data
	 */
	void setData(int data);
	
	/**
	 * Returns the node next to this node.
	 * @return	Node next to this node.
	 */
	INode getNext();
	
	/**
	 * Sets node received as the next node to this node.
	 * @param next	New next node.
	 */
	void setNext(INode next);
	
	/**
	 * Returns the node before this node.
	 * @return Node before this node.
	 */
	INode getLast();
	
	/**
	 * Sets node received as the last node to this node.
	 * @param last  New last node.
	 */
	void setLast(INode last);
	
}

