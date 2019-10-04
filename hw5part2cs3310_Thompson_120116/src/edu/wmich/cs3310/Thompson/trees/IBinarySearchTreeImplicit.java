package edu.wmich.cs3310.Thompson.trees;

import edu.wmich.cs3310.Thompson.dataObjects.IStudentData;

/**
 * Provides the IBinarySearchTreeImplicit interface
 * @author Tyler Thompson
 *
 */
public interface IBinarySearchTreeImplicit {

    	/**
    	 * Get the index of the root node of the tree. In an implicit implementation it's redundant because the root is always at 0. 
    	 * @return the index as a int.
    	 */
	int root();
	
	/**
	 * Gets the index of the left child of the index passed.
	 * @param i The index of the node you want the left child of.
	 * @return The index of the left child as an int.
	 */
	int leftChild(int i);
	
	/**
	 * Gets the index of the right child of the index passed.
	 * @param i The index of the node you want the right child of.
	 * @return The index of the right child as an int.
	 */
	int rightChild(int i);
	
	/**
	 * Get the index of the parent of the index passed.
	 * @param i The index of the node you want the parent of.
	 * @return The index of the parent as an int.
	 */
	int parent(int i);
	
	/**
	 * Inserts a new data member into the tree.
	 * @param data The student data to insert.
	 * @return The index the data was inserted into.
	 */
	int insert(IStudentData data);
	
	/**
	 * Deletes the data with the matching name from the tree.
	 * @param name The name in the student data to delete.
	 * @return The index in the tree of the data deleted. returns -1 if the data doesn't exist.
	 */
	int delete(String name);
	
	/**
	 * Searches the tree for the name specified.
	 * @param name The name of the student you are looking for.
	 * @return The index of the student data. returns -1 if it's not found.
	 */
	int search(String name);
	
	/**
	 * Traverses the tree in an inorder fashion and prints out the data of each node.
	 */
	void inOrderTraversal();
	
	/**
	 * Traverses the tree in a preorder fashion and prints out the data of each node.
	 */
	void preOrderTraversal();
	
	/**
	 * Traverses the tree in a postorder fashion and prints out the data of each node.
	 */
	void postOrderTraversal();
	
	/**
	 * Prints the names of each element in the tree along with it's index. 
	 * Prints a $ if the node is empty.
	 */
	void printTree();
	
}
