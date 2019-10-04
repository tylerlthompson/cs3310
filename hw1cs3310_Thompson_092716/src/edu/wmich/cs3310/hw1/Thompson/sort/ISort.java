package edu.wmich.cs3310.hw1.Thompson.sort;

import edu.wmich.cs3310.hw1.Thompson.lists.ILinkedList;

/**
 * Provides sort interface for sorting LinkedLists and arrays.
 * @author Tyler Thompson
 *
 */
public interface ISort {

	/**
	 * Sorts a LinkedList in increasing order from left to right using a quick sort method.
	 * @param list  LinkedLisk to sort.
	 * @param left  Index of the first item in the list.
	 * @param right  Index of the last item in the list.
	 */
	void quickShortIncreasing(ILinkedList list , int left, int right);

	/**
	 * Sorts a LinkedList in decreasing order from left to right using a quick sort method.
	 * @param list  LinkedLisk to sort.
	 * @param left  Index of the first item in the list.
	 * @param right  Index of the last item in the list.
	 */
	void quickSortDecreasing(ILinkedList list, int left, int right);

	/**
	 * Sorts an integer array in increasing order from left to right using a quick sort method.
	 * @param list  LinkedLisk to sort.
	 * @param left  Index of the first item in the list.
	 * @param right  Index of the last item in the list.
	 */
	void quickSortIncreasingArray( int[] list, int left, int right);

	/**
	 * Sorts an integer array in decreasing order from left to right using a quick sort method.
	 * @param list  LinkedLisk to sort.
	 * @param left  Index of the first item in the list.
	 * @param right  Index of the last item in the list.
	 */
	void quickSortDecreasingArray( int[] list, int left, int right);
		
}
