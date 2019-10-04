package edu.wmich.cs3310.hw4.Thompson.lists;
import edu.wmich.cs3310.hw4.Thompson.lists.INode;
import edu.wmich.cs3310.hw4.Thompson.lists.Node;

/**
 * Provides the LinkedList class for creating linked lists.
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type.
 */
public class LinkedList<E extends Comparable<E>> implements ILinkedList<E> {

    private INode<E> head;
    private INode<E> tail;
    private int size;
	
    /**
    * LinkedList constructor for creating an empty LinkedList.
    */
    public LinkedList() {
	this.size = 0;
    }
	
    /**
     * LinkedList Constructor for creating a linked list with a size.
     * @param size  Size you want the linked list to be.
     */
    public LinkedList(int size) {
	for ( int i = 0; i < size; i++) {
		this.add(null);
	}
    }
    
    /**
     * Adds the element e to the end of the list.
     * @param e element to be added
     */
    @Override
    public void add(E e) {
	if (isEmpty()) {
		head = new Node<E>(e);
		tail = head;
	}
	else {
		INode<E> p = new Node<E>(e);
		p.setLast(tail);
		tail.setNext(p);
		tail = tail.getNext();
	}
	this.size++;
    }

    /**
     * Adds the element e to the list at the specified index.
     * @param index of the location to place the element, starting from 0
     * @param e element to be added
     */
    @Override
    public void add(int index, E e) {
	INode<E> n = new Node<E>(e);
	INode<E> p = this.find(index);
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
	this.size++;
    }

    /**
     * Removes all of the elements from the list
     */
    @Override
    public void clear() {
	this.head=null;
	this.tail=null;
    }

    /**
     * Gets the first element in the list.
     * @return the element at the front (index 0) of the list
     */
    @Override
    public E getHead() {
	return this.head.getData();
    }

    /**
     * Gets the last element in the list.
     * @return the element at the back (index size-1) of the list.
     */
    @Override
    public E getTail() {
	return this.tail.getData();
    }

    /**
     * Gets the elements in the list at the index specified.
     * @param index index of the element to retrieve, starting from 0.
     * @return the element at that index.
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
	INode<E> p = head;
	for(int i=0;i<index;i++){
		p=p.getNext();
	}
	return p.getData();
    }

    /**
     * Checks to see if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
	if ( this.size() == 0 ) {
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
    public E remove(int index) throws IndexOutOfBoundsException {
	if(index<0 || index>=size()){
		throw new IndexOutOfBoundsException();
	}
	E e;
	if ( index == 0 ) {
		e = head.getData();
		head = head.getNext();
		head.setLast(null);
		if ( head == null) {
			tail = null;
		}
	}
	else {
		INode<E> p = head;
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
     * Gets the number of elements in a LinkedList.
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
	return this.size;
    }

    /**
     * Prints the LinkedLists in a format using arrows to denote the next item in the list.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void printList() throws IndexOutOfBoundsException {
	if ( this.size() > 100 ) {
	    System.out.println("List size is greater than 100, not printing. Size: " + this.size());
	    return;
	}
	INode<E> p = head;
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
     * Finds the node in the LinkedList you specify.
     * @param index  Index of the node you want to find.
     * @return  The entire node you are looking for.
     */
    @Override
    public INode<E> find(int index) throws IndexOutOfBoundsException{
	INode<E> p = head;
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
	INode<E> p = head;
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
     * Swaps the two elements specified in the LinkedList by changing their pointers.
     * @param x  The first item to swap.
     * @param y  The second item to swap.
     */
    @Override
    public void swap(int x, int y) {
	INode<E> a = this.find(x);
	INode<E> b = this.find(y);
	
	INode<E> tempNext = a.getNext();
	INode<E> tempLast = a.getLast();
	
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
     * Set the data at the specified element.
     * @param index  Location of the element.
     * @param e  Data to set the element to.
     */
    @Override
    public void set(int index, E e) {
	INode<E> p = this.find(index);
	p.setData(e);
	
    }

}
