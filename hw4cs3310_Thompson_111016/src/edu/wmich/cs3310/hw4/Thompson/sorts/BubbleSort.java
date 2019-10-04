package edu.wmich.cs3310.hw4.Thompson.sorts;

import java.util.ArrayList;

import edu.wmich.cs3310.hw4.Thompson.comparators.*;
import edu.wmich.cs3310.hw4.Thompson.lists.ILinkedList;

/**
 * Provides the BubbleSort class for sorting lists using a bubble sort method.
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type.
 */
public class BubbleSort<E extends Comparable<E>> implements ISort<E> {
    
   private ICompare<E> comparator;

   /**
    * Bubble sort Constructor.
    */
   public BubbleSort(){
       this.comparator = new Compare<E>();
   }

   /**
    * Sort the specified LinkedList using a bubble sort method.
    * @param list  LikedList to sort.
    * @return  The LinkedList sorted lowest to highest.
    */
    @Override
    public ILinkedList<E> sort(ILinkedList<E> list) {
	int n = list.size();
	for ( int i = 0; i < n; i++ ) {
	    for ( int j = 1; j < (n - i); j++ ) {
		if ( this.comparator.compare(list.get(j), list.get(j - 1)) == true ) {
		    list.swap(j-1, j);
		}
	    }
	}
	return list;
    }

    /**
     * Sorts the specified ArrayList using a bubble sort method.
     * @param list  The ArrayList to sort.
     * @return  The ArrayList sorted from lowest to highest.
     */
    @Override
    public ArrayList<E> sort(ArrayList<E> list) {
	int n = list.size();
	for ( int i = 0; i < n; i++ ) {
	    for ( int j = 1; j < (n - i); j++ ) {
		if ( this.comparator.compare(list.get(j), list.get(j - 1)) == true ) {
		    E tmp = list.get(j - 1);
		    list.set(j - 1, list.get(j));
		    list.set(j, tmp);
		}
	    }
	}
	return list;
    }
	
}
