package edu.wmich.cs3310.hw1.Thompson.lists;

/**
 * Provide the Node class used for making LinkedLists.
 * @author Tyler Thompson
 *
 */
public class Node implements INode {

	private int nodeData;
	private INode nextNode;
	private INode lastNode;
	
	/**
	 * Node constructor
	 * @param data the info to be held by the node
	 * @param n the next node in the chain
	 * @param l the last node in the chain
	 */
	public Node(int data, INode n, INode l){
		this.nodeData=data;
		this.nextNode=n;
		this.lastNode=l;
	}
	
	/**
	 * Node constructor
	 * @param nodeData the info to be held by the node
	 */
	public Node(int nodeData) {
		this(nodeData, null, null);
	}
	
	/**
	 * Returns the data stored in this node.
	 * @return	Data in this node.
	 */
	@Override
	public int getData() {
		return this.nodeData;
	}

	/**
	 * Setter for data for this node.
	 * @param data	New data
	 */
	@Override
	public void setData(int data) {
		this.nodeData = data;
	}

	/**
	 * Returns the node next to this node.
	 * @return	Node next to this node.
	 */
	@Override
	public INode getNext() {
		return this.nextNode;
	}

	/**
	 * Sets node received as the next node to this node.
	 * @param next	New next node.
	 */
	@Override
	public void setNext(INode next) {
		this.nextNode = next;
	}
	
	/**
	 * Returns the node last to this node.
	 * @return	Node last to this node.
	 */
	@Override
	public INode getLast() {
		return lastNode;
	}

	/**
	 * Sets node received as the last node to this node.
	 * @param lastNode	New last node.
	 */
	@Override
	public void setLast(INode lastNode) {
		this.lastNode = lastNode;
	}
}
