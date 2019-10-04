package edu.wmich.cs3310.hw4.Thompson.sorts;

import java.util.ArrayList;

import edu.wmich.cs3310.hw4.Thompson.comparators.*;
import edu.wmich.cs3310.hw4.Thompson.lists.ILinkedList;
import edu.wmich.cs3310.hw4.Thompson.lists.LinkedList;

/**
 * Provides the MergeSort class for sorting list using a merge sort method.
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type.
 */
public class MergeSort<E extends Comparable<E>> implements ISort<E> {

    private ICompare<E> comparator;
    private ILinkedList<E> list;
    private ILinkedList<E> tempList;
    private int length;
    private ArrayList<E> listArray;
    private ArrayList<E> tempListArray;

    /*
     * MergeSort constructor.
     */
    public MergeSort(){
        this.comparator = new Compare<E>();
    }
    
    /**
     * Sort the specified LinkedList using a merge sort method.
     * @param list  LikedList to sort.
     * @return  The LinkedList sorted lowest to highest.
     */
    @Override
    public ILinkedList<E> sort(ILinkedList<E> list) {
	this.list = list;
	this.length = list.size();
	this.tempList = new LinkedList<E>(this.length);
	this.doMergeSort(0, this.length - 1);
	return this.list;
    }
    
   /**
    * Initiates a recursive merge sort on a linked list.
    * @param lower  Lower bound
    * @param higher  Upper bound
    */
   private void doMergeSort(int lower, int higher) {
       
       if ( lower < higher ) {
	   int mid = lower + ( higher - lower ) / 2;
	   this.doMergeSort(lower, mid);
	   this.doMergeSort(mid + 1, higher);
	   this.merge(lower, mid, higher);
       }
       
   }
    
   /**
    * Merges two sub lists of a LinkedList being sorted by merge sort.
    * @param lower The lower bound
    * @param mid The mid point
    * @param higher The upper bound
    */
   private void merge(int lower, int mid, int higher) {
       
       for ( int i = lower; i <= higher; i++ ) {
	   this.tempList.set(i, this.list.get(i));
       }
       int i = lower;
       int j = mid + 1;
       int k = lower;
       while ( i <= mid && j <= higher ) {
	   if ( this.comparator.compare(this.tempList.get(i), this.tempList.get(j)) == true) {
	       this.list.set(k, this.tempList.get(i));
	       i++;
	   }
	   else {
	       this.list.set(k, this.tempList.get(j));
	       j++;
	   }
	   k++;
       }
       while ( i <= mid ) {
	   this.list.set(k, this.tempList.get(i));
	   k++;
	   i++;
       }
       
   }

   /**
    * Sorts the specified ArrayList using a merge sort method.
    * @param list  The ArrayList to sort.
    * @return  The ArrayList sorted from lowest to highest.
    */
   @Override
   public ArrayList<E> sort(ArrayList<E> list) {
       this.listArray = list;
	this.length = list.size();
	this.tempListArray = new ArrayList<E>(this.length);
	this.fillArrayList(this.length);
	this.doMergeSortArray(0, this.length - 1);
	return this.listArray;
   }
   
   /**
    * Fills an array list with null values.
    * @param size Size of list
    */
   private void fillArrayList(int size) {
       for ( int i = 0; i < size; i++ ) {
	   this.tempListArray.add(null);
       }
   }
   
   /**
    * Initiates a recursive merge sort on an array list.
    * @param lower  Lower bound
    * @param higher  Upper bound
    */
   private void doMergeSortArray(int lower, int higher) {
       
       if ( lower < higher ) {
	   int mid = lower + ( higher - lower ) / 2;
	   this.doMergeSortArray(lower, mid);
	   this.doMergeSortArray(mid + 1, higher);
	   this.mergeArray(lower, mid, higher);
       }
       
   }
   
   /**
    * Merges two sub lists of an ArrayList being sorted by merge sort.
    * @param lower The lower bound
    * @param mid The mid point
    * @param higher The upper bound
    */
   private void mergeArray(int lower, int mid, int higher) {
       
       for ( int i = lower; i <= higher; i++ ) {
	   this.tempListArray.set(i, this.listArray.get(i));
       }
       int i = lower;
       int j = mid + 1;
       int k = lower;
       while ( i <= mid && j <= higher ) {
	   if ( this.comparator.compare(this.tempListArray.get(i), this.tempListArray.get(j)) == true) {
	       this.listArray.set(k, this.tempListArray.get(i));
	       i++;
	   }
	   else {
	       this.listArray.set(k, this.tempListArray.get(j));
	       j++;
	   }
	   k++;
       }
       while ( i <= mid ) {
	   this.listArray.set(k, this.tempListArray.get(i));
	   k++;
	   i++;
       }
       
   }
   
}
