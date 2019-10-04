package edu.wmich.cs3310.hw4.Thompson.lists;

/**
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type.
 */
public class Node<E> implements INode<E> {

	private E nodeData;
	private INode<E> nextNode;
	private INode<E> lastNode;
	
	/**
	 * Node constructor
	 * @param data the info to be held by the node
	 * @param n the next node in the chain
	 * @param l the last node in the chain
	 */
	public Node(E data, INode<E> n, INode<E> l){
		this.nodeData=data;
		this.nextNode=n;
		this.lastNode=l;
	}
	
	/**
	 * Node constructor
	 * @param nodeData the info to be held by the node
	 */
	public Node(E nodeData) {
		this(nodeData, null, null);
	}
	
	/**
	 * Returns the data stored in this node.
	 * @return	Data in this node.
	 */
	@Override
	public E getData() {
		return this.nodeData;
	}

	/**
	 * Setter for data for this node.
	 * @param data	New data
	 */
	@Override
	public void setData(E data) {
		this.nodeData = data;
	}

	/**
	 * Returns the node next to this node.
	 * @return	Node next to this node.
	 */
	@Override
	public INode<E> getNext() {
		return this.nextNode;
	}

	/**
	 * Sets node received as the next node to this node.
	 * @param next	New next node.
	 */
	@Override
	public void setNext(INode<E> next) {
		this.nextNode = next;
	}
	
	/**
	 * Returns the node last to this node.
	 * @return	Node last to this node.
	 */
	public INode<E> getLast() {
		return lastNode;
	}

	/**
	 * Sets node received as the last node to this node.
	 * @param lastNode	New last node.
	 */
	public void setLast(INode<E> lastNode) {
		this.lastNode = lastNode;
	}
}