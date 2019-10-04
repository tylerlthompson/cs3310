package edu.wmich.cs3310.hw4.Thompson.sorts;

import java.util.ArrayList;

import edu.wmich.cs3310.hw4.Thompson.comparators.Compare;
import edu.wmich.cs3310.hw4.Thompson.comparators.ICompare;
import edu.wmich.cs3310.hw4.Thompson.lists.ILinkedList;

/**
 * Provides the BinaryInsetionSort class for sorting list using a binary insertion method.
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type.
 */
public class BinaryInsertionSort<E extends Comparable<E>> implements ISort<E> {

    private ICompare<E> comparator;
    
    /**
     * BinaryInertionSort constructor.
     */
    public BinaryInsertionSort(){
        this.comparator = new Compare<E>();
    }
    
    /**
     * Sort the specified LinkedList using a binary insertion sort method.
     * @param list  LikedList to sort.
     * @return  The LinkedList sorted lowest to highest.
     */
    @Override
    public ILinkedList<E> sort(ILinkedList<E> list) {
	
	for ( int i = 1; i < list.size(); i++ ){
	    E temp = list.get(i);
	    int left = 0;
	    int right = i;
	    while ( left < right ) {
		int mid = (left + right) / 2;
		if ( this.comparator.compare(temp, list.get(mid)) == false ) {
		    left = mid + 1;
		}
		else {
		    right = mid;
		}
	    }
	    for ( int j = i; j > left; --j ) {
		list.swap(j - 1, j);
	    }
	}
	
	return list;
    }

    /**
     * Sorts the specified ArrayList using a biniary insertion sort method.
     * @param list  The ArrayList to sort.
     * @return  The ArrayList sorted from lowest to highest.
     */
    @Override
    public ArrayList<E> sort(ArrayList<E> list) {
	for ( int i = 1; i < list.size(); i++ ){
	    E temp = list.get(i);
	    int left = 0;
	    int right = i;
	    while ( left < right ) {
		int mid = (left + right) / 2;
		if ( this.comparator.compare(temp, list.get(mid)) == false ) {
		    left = mid + 1;
		}
		else {
		    right = mid;
		}
	    }
	    for ( int j = i; j > left; --j ) {
		E tmp = list.get(j - 1);
		list.set(j - 1, list.get(j));
		list.set(j, tmp);
	    }
	}
	return list;
    }

}
