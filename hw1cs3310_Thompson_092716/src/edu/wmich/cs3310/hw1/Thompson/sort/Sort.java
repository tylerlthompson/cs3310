package edu.wmich.cs3310.hw1.Thompson.sort;

import edu.wmich.cs3310.hw1.Thompson.lists.ILinkedList;
import edu.wmich.cs3310.hw1.Thompson.lists.INode;

/**
 * Provides sort class for sorting LinkedLists and arrays.
 * @author Tyler Thompson
 *
 */
public class Sort implements ISort{

	/**
	 * Sort object. Takes no parameters.
	 */
	public Sort() {}
	
	/**
	 * Sorts an integer array in increasing order from left to right using a quick sort method.
	 * @param list  LinkedLisk to sort.
	 * @param left  Index of the first item in the list.
	 * @param right  Index of the last item in the list.
	 */
	@Override
	public void quickSortIncreasingArray( int[] list, int left, int right ) {
		int mid, i, j, p;
		mid = left + (right - left) / 2;
		p = list[mid];
		i = left;
		j = right;
		while ( i <= j ) {
			while ( list[i] < p ) {
				i++;
			}
			
			while ( list[j] > p ) {
				
				j--;
			}
			
			if ( i <= j) {
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;
				i++;
				j--;
			}
			if ( left < j ) {
				quickSortIncreasingArray(list, left, j);
			}
			
			if ( i < right ) {
				quickSortIncreasingArray(list, i, right);
			}
		}
		
	}

	/**
	 * Sorts a LinkedList in increasing order from left to right using a quick sort method.
	 * @param list  LinkedLisk to sort.
	 * @param left  Index of the first item in the list.
	 * @param right  Index of the last item in the list.
	 */
	@Override
	public void quickShortIncreasing(ILinkedList list, int left, int right) {
		int mid, i, j, p;
		mid = left + (right - left ) / 2;
		INode tmp = list.find(mid);
		p = tmp.getData();
		i = left;
		j = right;
		
		while ( i <= j ) {
			
			while ( list.get(i) < p ) {
				i++;
			}
			
			while ( list.get(j) > p ) {
				
				j--;
			}
			
			if ( i <= j) {
				list.swap(i, j);
				i++;
				j--;
			}
			if ( left < j ) {
				quickShortIncreasing(list, left, j);
			}
			
			if ( i < right ) {
				quickShortIncreasing(list, i, right);
			}
		}
	}

	/**
	 * Sorts an integer array in decreasing order from left to right using a quick sort method.
	 * @param list  LinkedLisk to sort.
	 * @param left  Index of the first item in the list.
	 * @param right  Index of the last item in the list.
	 */
	@Override
	public void quickSortDecreasingArray( int[] list, int left, int right ) {
		int mid, i, j, p;
		mid = left + (right - left ) / 2;
		p = list[mid];
		i = left;
		j = right;
		while ( i <= j ) {
			
			while ( list[i] > p ) {
				i++;
			}
			
			while ( list[j] < p ) {
				j--;
				if (j < 0) {
					break;
				}
				
			}
			
			if ( i <= j) {
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;
				i++;
				j--;
			}
			if ( left < j ) {
				quickSortDecreasingArray(list, left, j);
			}
			
			if ( i < right ) {
				quickSortDecreasingArray(list, i, right);
			}
		}
		
	}
	
	/**
	 * Sorts a LinkedList in decreasing order from left to right using a quick sort method.
	 * @param list  LinkedLisk to sort.
	 * @param left  Index of the first item in the list.
	 * @param right  Index of the last item in the list.
	 */
	@Override
	public void quickSortDecreasing(ILinkedList list, int left, int right)  {
		int mid, i, j, p;
		mid = left + (right - left ) / 2;
		INode tmp = list.find(mid);
		p = tmp.getData();
		i = left;
		j = right;
		
		while ( i <= j ) {
			
			while ( list.get(i) > p ) {
				i++;
			}
			
			while ( list.get(j) < p ) {
				
				j--;
			}
			
			if ( i <= j) {
				list.swap(i, j);
				i++;
				j--;
			}
			if ( left < j ) {
				quickSortDecreasing(list, left, j);
			}
			
			if ( i < right ) {
				quickSortDecreasing(list, i, right);
			}
		}
	}
}
