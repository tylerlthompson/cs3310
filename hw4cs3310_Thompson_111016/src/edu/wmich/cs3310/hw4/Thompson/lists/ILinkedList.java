package edu.wmich.cs3310.hw4.Thompson.lists;

/**
 * Provides the Interface for the LinkedList class used for making linked lists.
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type.
 */
public interface ILinkedList<E> {
    	
    /**
    * Set the data at the specified element.
    * @param index  Location of the element.
    * @param e  Data to set the element to.
    */
    void set(int index, E e);
    
    /**
    * Adds the element e to the end of the list.
	* @param e element to be added
	*/
	void add(E e);
	
	/**
	* Adds the element e to the list at the specified index.
	* @param index of the location to place the element, starting from 0
	* @param e element to be added
	*/
	void add(int index, E e);
	
	/**
	* Removes all of the elements from the list
	*/
	void clear();
	
	/**
	* Gets the first element in the list.
	* @return the element at the front (index 0) of the list
	*/
	E getHead();
	
	/**
	* Gets the last element in the list.
	* @return the element at the back (index size-1) of the list.
	*/
	E getTail();
	
	/**
	* Gets the elements in the list at the index specified.
	* @param index index of the element to retrieve, starting from 0.
	* @return the element at that index.
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	E get(int index) throws IndexOutOfBoundsException;
	
	/**
	* Checks to see if the list is empty.
	* @return true if the list is empty, false otherwise.
	*/
	boolean isEmpty();
	
	/**
	* Removes the element at the specified index. 
	* @param index of element to be removed, starting from index 0
	* @return The contents of the element that was removed.
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	E remove(int index) throws IndexOutOfBoundsException;

	/**
	* Gets the number of elements in a LinkedList.
	* @return the number of elements in this list.
	*/
	int size();

	/**
	 * Prints the LinkedLists in a format using arrows to denote the next item in the list.
	 * @throws IndexOutOfBoundsException
	 */
	void printList() throws IndexOutOfBoundsException;

	/**
	 * Finds the node in the LinkedList you specify.
	 * @param index  Index of the node you want to find.
	 * @return  The entire node you are looking for.
	 */
	INode<E> find(int index);

	/**
	 * Prints the LinkedList along with the before and after each node. Great for debugging purposes.
	 * @throws IndexOutOfBoundsException
	 */
	void printListLinks() throws IndexOutOfBoundsException;

	/**
	 * Swaps the two elements specified in the LinkedList by changing their pointers.
	 * @param x  The first item to swap.
	 * @param y  The second item to swap.
	 */
	void swap(int x, int y);
}
