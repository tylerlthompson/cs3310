package edu.wmich.cs3310.hw4.Thompson.sorts;

import java.util.ArrayList;

import edu.wmich.cs3310.hw4.Thompson.lists.ILinkedList;

/**
 * Provides the Interface for all the sort classes used for sorting data in various methods.
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type.
 */
public interface ISort<E> {

    /**
     * Sort the specified LinkedList.
     * @param list  LikedList to sort.
     * @return  The LinkedList sorted lowest to highest.
     */
    ILinkedList<E> sort(ILinkedList<E> list); 
 
    /**
     * Sorts the specified ArrayList.
     * @param list  The ArrayList to sort.
     * @return  The ArrayList sorted from lowest to highest.
     */
    ArrayList<E> sort(ArrayList<E> list);
}
