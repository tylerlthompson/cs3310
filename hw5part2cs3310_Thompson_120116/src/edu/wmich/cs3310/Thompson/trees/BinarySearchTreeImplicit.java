package edu.wmich.cs3310.Thompson.trees;

import java.util.ArrayList;

import edu.wmich.cs3310.Thompson.comparators.Compare;
import edu.wmich.cs3310.Thompson.comparators.ICompare;
import edu.wmich.cs3310.Thompson.dataObjects.IStudentData;
import edu.wmich.cs3310.Thompson.dataObjects.StudentData;

/**
 * Provides the BinarySearchTreeImplicit class that implements the IBinarySearchTreeImplicit interface.
 * @author Tyler Thompson
 *
 */
public class BinarySearchTreeImplicit implements IBinarySearchTreeImplicit {

	private ArrayList<IStudentData> treeData;
	private int treeSize;
	private int lastIndexUsed;
	private ICompare<String> compare;
	
	/**
	 * BinarySearchTreeImplicit constructor.
	 */
	public BinarySearchTreeImplicit() {
		this.treeSize = 0;
		this.lastIndexUsed = -1;
		this.treeData = new ArrayList<IStudentData>();
		this.compare = new Compare<String>();
	}
	
	/**
    	 * Get the index of the root node of the tree. In an implicit implementation it's redundant because the root is always at 0. 
    	 * @return the index as a int.
    	 */
	@Override
	public int root() {
		if ( this.treeSize == 0 ) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Gets the index of the left child of the index passed.
	 * @param i The index of the node you want the left child of.
	 * @return The index of the left child as an int.
	 */
	@Override
	public int leftChild(int i) {
		return (2 * i) + 1;
	}

	/**
	 * Gets the index of the right child of the index passed.
	 * @param i The index of the node you want the right child of.
	 * @return The index of the right child as an int.
	 */
	@Override
	public int rightChild(int i) {
		return (2 * i) + 2;
	}

	/**
	 * Get the index of the parent of the index passed.
	 * @param i The index of the node you want the parent of.
	 * @return The index of the parent as an int.
	 */
	@Override
	public int parent(int i) {
		if ( i == 0 ) {
			return -1;
		}
		else {
			return (i - 1) / 2;
		}
	}

	/**
	 * Inserts a new data member into the tree.
	 * @param data The student data to insert.
	 * @return The index the data was inserted into.
	 */
	@Override
	public int insert(IStudentData data) {
		if ( this.treeSize == 0 ) {
			this.treeData.add(data);
			this.lastIndexUsed = 0;
		}
		else {
			int index = this.insertHelp(data.getName(), 0);
			if ( index > this.treeSize ) {
			    this.fillEmpty(this.lastIndexUsed + 1, index);
			}
			try {
			    if ( this.treeData.get(index).getName() == "$" ) {
				this.treeData.set(index, data);
		    	    }
			}catch (Exception e) {
			    this.treeData.add(index, data);
		    	}
			this.lastIndexUsed = index;
		}
		this.treeSize++;
		return this.lastIndexUsed;
	}
	
	/**
	 * Private method.
	 * Fills the tree with empty nodes from the starting position to the stopping position.
	 * @param start The starting position to start filling from.
	 * @param stop The ending position to stop filling at.
	 */
	private void fillEmpty(int start, int stop) {
	    for ( int i = start; i < stop; i++ ) {
		try {
		    this.treeData.get(i);
		} catch (Exception e) {
		    this.treeData.add(i, new StudentData("$", 0, 'Z'));
		}
	    }
	}
	
	/**
	 * Private method.
	 * Recursive function that finds the index that a new node should be inserted into.
	 * @param key The student name to compare to the others in the tree.
	 * @param index Index to start at. Should always start at index 0, the root.
	 * @return The index the node should be inserted into.
	 */
	private int insertHelp(String key, int index) {
	    	try {
	    	    if ( this.treeData.get(index).getName() == "$" ) {
	    		return index;
	    	    }
	    	} catch (Exception e) {
	    	    return index;
	    	}
	    	String compareKey = this.treeData.get(index).getName();
 		if ( compare.compare(key, compareKey) == true ) {
 			return this.insertHelp(key, this.leftChild(index));
 		}
 		else {
 			return this.insertHelp(key, this.rightChild(index));
 		}
	}

	/**
	 * Deletes the data with the matching name from the tree.
	 * @param name The name in the student data to delete.
	 * @return The index in the tree of the data deleted. returns -1 if the data doesn't exist.
	 */
	@Override
	public int delete(String name) {
		int deleteIndex = this.search(name);
		if ( deleteIndex == -1 ) {
		    return deleteIndex; //student name not found
		}
		if ( this.treeSize == 1 ) {
		    this.treeData = new ArrayList<IStudentData>();
		    this.treeSize = 0;
		    return 0;
		}
		int replaceIndex = this.findLowest(this.rightChild(deleteIndex));
		this.treeData.set(deleteIndex, this.treeData.get(replaceIndex));
		IStudentData emptyStudent = new StudentData("$", 0, 'Z');
		this.treeData.set(replaceIndex, emptyStudent);
		this.treeSize--;
		return deleteIndex;
	}
	
	/**
	 * Private method.
	 * Recursively searches, starting at the passed index, for the lowest value in the tree. Helper function for the delete method.
	 * @param index The index to start at.
	 * @return The index of the lowest value.
	 */
	private int findLowest(int index) {
	    try {
		int leftChild = this.leftChild(index);
		if ( this.treeData.get(leftChild).getName() == "$" ) {
		    return index;
		}
		return this.findLowest(leftChild);
	    } catch (Exception e){
		return index;
	    }
	}

	/**
	 * Searches the tree for the name specified.
	 * @param name The name of the student you are looking for.
	 * @return The index of the student data. returns -1 if it's not found.
	 */
	@Override
	public int search(String name) {
	    ICompare<String> comp = new Compare<String>();
	    return this.searchHelp(name, 0, comp);
	}

	/**
	 * Private method.
	 * Recursive helper function for search.
	 * @param key The value to look for.
	 * @param index The starting index. Should always be 0.
	 * @param comp The Compare object to use through out the search.
	 * @return The index of the node if it was found. Otherwise -1.
	 */
	private int searchHelp(String key, int index, ICompare<String> comp) {
	    try {
		if ( this.treeData.get(index).getName().equals(key) ) {
		    return index;
		}
		else if ( comp.compare(this.treeData.get(index).getName(), key) == true ) {
		    return this.searchHelp(key, this.rightChild(index), comp);
		}
		else {
		    return this.searchHelp(key, this.leftChild(index), comp);
		}
	    } catch (Exception e) {
		return -1;
	    }
	    
	}
	
	/**
	 * Traverses the tree in an inorder fashion and prints out the data of each node.
	 */
	@Override
	public void inOrderTraversal() {
	    System.out.println("\n### Inorder Traversal ###");
	    this.inOrderTraversalHelp(0);
	    System.out.println("");

	}

	/**
	 * Private method.
	 * Recursive helper function for inOrderTraversal. 
	 * @param index The index to start at.
	 */
	private void inOrderTraversalHelp(int index) {
	    try {
		if ( this.treeData.get(index).getName() == "$" ) {
		    return;
		}
		this.inOrderTraversalHelp(this.leftChild(index));
		IStudentData curData = this.treeData.get(index);
		System.out.println("Index: " + index + "\t" + curData.getName() + ", " + curData.getCourseNumber() + ", " + curData.getGrade());
		this.inOrderTraversalHelp(this.rightChild(index));
	    } catch (Exception e) {
		return;
	    }
	}
	
	/**
	 * Traverses the tree in a preorder fashion and prints out the data of each node.
	 */
	@Override
	public void preOrderTraversal() {
	    System.out.println("\n### Preorder Traversal ###");
	    this.preOrderTraversalHelp(0);
	    System.out.println("");

	}
	
	/**
	 * Private method.
	 * Recursive helper function for preOrderTraversal. 
	 * @param index The index to start at.
	 */
	private void preOrderTraversalHelp(int index) {
	    try {
		if ( this.treeData.get(index).getName() == "$" ) {
		    return;
		}
		IStudentData curData = this.treeData.get(index);
		System.out.println("Index: " + index + "\t" + curData.getName() + ", " + curData.getCourseNumber() + ", " + curData.getGrade());
		this.preOrderTraversalHelp(this.leftChild(index));
		this.preOrderTraversalHelp(this.rightChild(index));
	    } catch (Exception e) {
		return;
	    }
	}

	/**
	 * Traverses the tree in a postorder fashion and prints out the data of each node.
	 */
	@Override
	public void postOrderTraversal() {
	    System.out.println("\n### Postorder Traversal ###");
	    this.postOrderTraversalHelp(0);
	    System.out.println("");

	}
	
	/**
	 * Private method.
	 * Recursive helper function for postOrderTraversal. 
	 * @param index The index to start at.
	 */
	private void postOrderTraversalHelp(int index) {
	    try {
		if ( this.treeData.get(index).getName() == "$" ) {
		    return;
		}
		this.postOrderTraversalHelp(this.leftChild(index));
		this.postOrderTraversalHelp(this.rightChild(index));
		IStudentData curData = this.treeData.get(index);
		System.out.println("Index: " + index + "\t" + curData.getName() + ", " + curData.getCourseNumber() + ", " + curData.getGrade());
	    } catch (Exception e) {
		return;
	    }
	}

	/**
	 * Prints the names of each element in the tree along with it's index. 
	 * Prints a $ if the node is empty.
	 */
	@Override
	public void printTree(){
	    System.out.println("Tree Size: " + this.treeSize);
	    int count = 0;
		for ( int i = 0; i < this.treeData.size(); i++ ) {
		    //if( this.treeData.get(i).getName() != "$") {
			System.out.print(i + "|" + this.treeData.get(i).getName() + " ");
		   // }
			count ++;
			double j = i;
			if ( count > ( j / 2 ) + 0.5 ) {
			    System.out.println("\n");
			    count = 0;
			}
		}
		System.out.println();
	}
	
}
