package edu.wmich.cs3310.hw4.Thompson.sorts;

import java.util.ArrayList;

import edu.wmich.cs3310.hw4.Thompson.comparators.*;
import edu.wmich.cs3310.hw4.Thompson.lists.ILinkedList;

/**
 * Provide the SelectionSort class for sorting lists using a selection sort method.
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type.
 */
public class SelectionSort<E extends Comparable<E>> implements ISort<E> {

    private ICompare<E> comparator;

    /**
     * SelectionSort constructor.
     */
    public SelectionSort(){
        this.comparator = new Compare<E>();
    }
    
    /**
     * Sort the specified LinkedList using a selection sort method.
     * @param list  LikedList to sort.
     * @return  The LinkedList sorted lowest to highest.
     */
    @Override
    public ILinkedList<E> sort(ILinkedList<E> list) {
	for ( int i = 0; i < list.size() - 1; i++ ) {
	    int index = i;
	    for ( int j = i + 1; j < list.size(); j++ ) {
		if ( this.comparator.compare(list.get(j), list.get(index)) == true ) {
		    index = j;
		}
	    }
	    list.swap(i, index);
	}
	return list;
    }

    /**
     * Sorts the specified ArrayList using a selection sort method.
     * @param list  The ArrayList to sort.
     * @return  The ArrayList sorted from lowest to highest.
     */
    @Override
    public ArrayList<E> sort(ArrayList<E> list) {
	for ( int i = 0; i < list.size() - 1; i++ ) {
	    int index = i;
	    for ( int j = i + 1; j < list.size(); j++ ) {
		if ( this.comparator.compare(list.get(j), list.get(index)) == true ) {
		    index = j;
		}
	    }
	    E tmp = list.get(i);
	    list.set(i, list.get(index));
	    list.set(index, tmp);
	}
	return list;
    }

}
