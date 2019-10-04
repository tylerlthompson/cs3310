package edu.wmich.cs3310.hw1.Thompson.lists;

import edu.wmich.cs3310.hw1.Thompson.lists.INode;

/**
 * Provides the LinkedList class for working with LinkedLists.
 * @author Tyler Thompson
 *
 */
public class LinkedList implements ILinkedList {

	private INode head;
	private INode tail;
	
	/**
	 * LinkedList constructor for creating an empty LinkedList.
	 */
	public LinkedList() {}
	
	/**
	 * LinkedList constructor for creating a LinkedList filled with zeros of specified size.
	 * @param size  The size you want the linked list to be.
	 */
	public LinkedList(int size) {
		for ( int i = 0; i < size; i++) {
			add(0);
		}
	}
	
	/**
	* Adds the element e to the end of the list.
	* @param e element to be added
	*/
	@Override
	public void add(int e) {
		if (isEmpty()) {
			head = new Node(e);
			tail = head;
		}
		else {
			INode p = new Node(e);
			p.setLast(tail);
			tail.setNext(p);
			tail = tail.getNext();
		}
	}
		
	/**
	* Adds the element e to the list at the specified index.
	* @param index of the location to place the int, starting from 0
	* @param e element to be added
	*/
	@Override
	public void add(int index, int e) {
		INode n = new Node(e);
		INode p = this.find(index);
		
		if ( index == this.size() ) {
			n.setNext(null);
			n.setLast(this.tail);
			this.tail.setNext(n);
			this.tail = n;
		}
		else if ( index == this.size() - 1 ) {
			n.setNext(this.tail);
			n.setLast(this.tail.getLast());
			this.tail.getLast().setNext(n);
			this.tail.setLast(n);
		}
		else if ( p.getLast() == null ) {
			n.setNext(this.head);
			this.head.setLast(n);
			this.head = n;
		}
		else {
			n.setLast(p.getLast());
			n.setNext(p);
			p.getLast().setNext(n);
			p.setLast(n);
		}
		
	}
		
	/**
	* Removes all of the elements from the list.
	*/
	@Override
	public void clear() {
		head=null;
		tail=null;
	}	
		
	/**
	* Get the first element in the list.
	* @return the element at the front (index 0) of the list.
	*/
	@Override
	public int getHead() {
		return head.getData();
	}
		
	/**
	* Get the last element in the list.
	* @return the element at the back (index size-1) of the list.
	*/
	@Override
	public int getTail() {
		return tail.getData();
	}
		
	/**
	* Gets the elements in the list at the index specified.
	* @param index index of the element to retrieve, starting from 0.
	* @return the element at that index.
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		INode p = head;
		for(int i=0;i<index;i++){
			p=p.getNext();
		}
		return p.getData();
	}
	
	/**
	 * Finds the node in the LinkedList you specify.
	 * @param index  Index of the node you want to find.
	 * @return  The entire node you are looking for.
	 */
	@Override
	public INode find(int index) {
		INode p = head;
		for(int i = 0; i < index; i++ ){
			p=p.getNext();
		}
		return p;
	}
	
	/**
	 * Prints the LinkedList along with the before and after each node. Great for debugging purposes.
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public void printListLinks() throws IndexOutOfBoundsException {
		INode p = head;
		for( int i=0; i < this.size(); i++ ){
			
			System.out.print("index:" + i);
			try {
				System.out.print(" last:" + p.getLast().getData());
			} catch (NullPointerException e) {
				System.out.print(" last:" + 0);
			}
			System.out.print(" data:" + p.getData());
			try {
				System.out.print(" next:" + p.getNext().getData());
			} catch (NullPointerException e) {
				System.out.print(" next:" + 0);
			}
			System.out.println();
			p=p.getNext();
		}
	}
	
	/**
	 * Prints the LinkedLists in a format using arrows to denote the next item in the list.
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public void printList() throws IndexOutOfBoundsException {
		INode p = head;
		for( int i=0; i < this.size(); i++ ){
			String arrow = "";
			if ( p.getNext() != null) {
				arrow = "->";
			}
			System.out.print(p.getData() + arrow);
			p=p.getNext();
		}
		System.out.println();
	}
		
	/**
	* Checks to see if the list is empty.
	* @return true if the list is empty, false otherwise.
	*/
	@Override
	public boolean isEmpty() {
		if ( head == null) {
			return true;
		}
		else {
			return false;
		}
	}		
	
		
	/**
	* Removes the element at the specified index. 
	* @param index of element to be removed, starting from index 0
	* @return The contents of the element that was removed.
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	@Override
	public int remove(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>=size()){
			throw new IndexOutOfBoundsException();
		}
		int e;
		if ( index == 0 ) {
			e = head.getData();
			head = head.getNext();
			head.setLast(null);
			if ( head == null) {
				tail = null;
			}
		}
		else {
			INode p = head;
			for(int i=0; i < index; i++){
				p=p.getNext();
			}
			e = p.getData();
			p.getLast().setNext(p.getNext());
			p.getNext().setLast(p.getLast());
			if(p.getNext()==null){
				tail=p;
			}
		}
		return e;
	}

	/**
	 * Inserts the integer specified into the LinkedList correctly if the LinkedList is already sorted in an increasing order.
	 * @param insert  The integer to insert.
	 */
	@Override
	public void insertSortedIncreasing(int insert) {
		INode p = this.head;
		for ( int i = 0; i < this.size(); i++ ) {
			if ( p.getData() >= insert ) {
				this.add(i, insert);
				break;
			}
			else {
				p = p.getNext();
			}
		}
	}
	
	/**
	 * Inserts the integer specified into the LinkedList correctly if the LinkedList is already sorted in a decreasing order. 
	 * @param insert  The integer to insert.
	 */
	@Override
	public void insertSortedDecreasing(int insert) {
		INode p = this.tail;
		for ( int i = this.size(); i > 0; i-- ) {
			if ( p.getData() >= insert ) {
				if ( insert == this.size() - 1) {
					insert++;
				}
				this.add(i, insert);
				break;
			}
			else {
				p = p.getLast();
			}
		}
	}
	
	/**
	* Gets the number of elements in a LinkedList.
	* @return the number of elements in this list.
	*/
	@Override
	public int size() {
		int count =0;
		INode p = head;
		while(p!=null){
			count++;
			p=p.getNext();
		}
		return count;
	}
	
	/**
	 * Goes through the LinkedList and finds how many number are greater than the number specified. 
	 * @param index  The number you want to get how many are bigger than it.
	 * @return The number of integers that are greater then the number specified.
	 */
	@Override
	public int getOver(int index) {
		int f = 0;
		INode p = head;
		for ( int i = 0; i < this.size(); i++) {
			if ( p.getData() > index ) {
				f++;
			}
			p = p.getNext();
		}
		return f;
	}
	
	/**
	 * Swaps the two elements specified in the LinkedList by changing their pointers.
	 * @param x  The first item to swap.
	 * @param y  The second item to swap.
	 */
	@Override
	public void swap(int x, int y) {
		
		INode a = this.find(x);
		INode b = this.find(y);
		
		INode tempNext = a.getNext();
		INode tempLast = a.getLast();
		
		if ( x == y ) {
			return;
		}
		
		else if ( a.getLast() == null && b.getNext() == null ) {
			a.setNext(null);
			a.setLast(b.getLast());
			b.getLast().setNext(a);
			
			b.setLast(null);
			b.setNext(tempNext);
			tempNext.setLast(b);
			
			head = b;
			tail = a;
		}
		
		else if ( a.getLast() == null && b.getLast() == a) {
			a.setNext(b.getNext());
			a.setLast(b);
			
			b.getNext().setLast(a);
			
			b.setLast(null);
			b.setNext(a);
			head = b;
		}
		
		else if ( b.getNext() == null && b.getLast() == a ) {
			a.setNext(null);
			a.setLast(b);
			
			b.setLast(tempLast);
			b.setNext(a);
			tempLast.setNext(b);
			tail = a;
		}
		
		else if ( a.getLast() == null ) {
			a.setNext(b.getNext());
			a.setLast(b.getLast());
			
			b.getNext().setLast(a);
			b.getLast().setNext(a);
			
			b.setLast(null);
			b.setNext(tempNext);
			tempNext.setLast(b);
			head = b;
		}
		
		else if ( b.getNext() == null ) {
			a.setNext(null);
			a.setLast(b.getLast());
			b.getLast().setNext(a);
			
			b.setLast(tempLast);
			b.setNext(tempNext);
			
			tempLast.setNext(b);
			tempNext.setLast(b);
			tail = a;
		}
		
		else if ( a.getNext() == b ) {
			a.setNext(b.getNext());
			a.setLast(b);
			
			b.getNext().setLast(a);
			
			b.setLast(tempLast);
			b.setNext(a);
			tempLast.setNext(b);
		}
		
		
		
		else {
			a.setNext(b.getNext());
			a.setLast(b.getLast());
			
			b.getNext().setLast(a);
			b.getLast().setNext(a);
			
			b.setLast(tempLast);
			b.setNext(tempNext);
			
			tempLast.setNext(b);
			tempNext.setLast(b);
		}
	}
	
	/**
	 * Swaps the tow elements specified in the LinkedList by swapping the data they contain.
	 * @param x  The first item to swap.
	 * @param y  The second item to swap.
	 */
	@Override
	public void swapInt(int x, int y) {
		INode a = find(x);
		INode b = find(y);
		int t1 = a.getData();
		a.setData(b.getData());
		b.setData(t1);
	}
}
