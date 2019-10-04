package edu.wmich.cs3310.hw1.Thompson.lists;

/**
 * Provides the LinkedList interface for LinkedList operations.
 * @author Tyler Thompson
 *
 */
public interface ILinkedList {
	
	/**
	* Adds the element e to the end of the list.
	* @param e element to be added
	*/
	void add(int e);
	
	/**
	* Adds the element e to the list at the specified index.
	* @param index of the location to place the int, starting from 0
	* @param e element to be added
	*/
	void add(int index, int e);
	
	/**
	* Removes all of the elements from the list
	*/
	void clear();
	
	/**
	* Gets the first element in the list.
	* @return the element at the front (index 0) of the list
	*/
	int getHead();
	
	/**
	* Gets the last element in the list.
	* @return the element at the back (index size-1) of the list.
	*/
	int getTail();
	
	/**
	* Gets the elements in the list at the index specified.
	* @param index index of the element to retrieve, starting from 0.
	* @return the element at that index.
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	int get(int index) throws IndexOutOfBoundsException;
	
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
	int remove(int index) throws IndexOutOfBoundsException;

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
	INode find(int index);

	/**
	 * Prints the LinkedList along with the before and after each node. Great for debugging purposes.
	 * @throws IndexOutOfBoundsException
	 */
	void printListLinks() throws IndexOutOfBoundsException;

	/**
	 * Goes through the LinkedList and finds how many number are greater than the number specified. 
	 * @param index  The number you want to get how many are bigger than it.
	 * @return The number of integers that are greater then the number specified.
	 */
	int getOver(int index);

	/**
	 * Swaps the two elements specified in the LinkedList by changing their pointers.
	 * @param x  The first item to swap.
	 * @param y  The second item to swap.
	 */
	void swap(int x, int y);

	/**
	 * Swaps the tow elements specified in the LinkedList by swapping the data they contain.
	 * @param x  The first item to swap.
	 * @param y  The second item to swap.
	 */
	void swapInt(int x, int y);

	/**
	 * Inserts the integer specified into the LinkedList correctly if the LinkedList is already sorted in an increasing order.
	 * @param insert  The integer to insert.
	 */
	void insertSortedIncreasing(int insert);

	/**
	 * Inserts the integer specified into the LinkedList correctly if the LinkedList is already sorted in a decreasing order. 
	 * @param insert  The integer to insert.
	 */
	void insertSortedDecreasing(int insert);

}
