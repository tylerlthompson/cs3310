package edu.wmich.cs3310.Thompson.application;

import java.util.ArrayList;

import edu.wmich.cs3310.Thompson.FileReaders.FileRead;
import edu.wmich.cs3310.Thompson.FileReaders.IFileRead;
import edu.wmich.cs3310.Thompson.dataObjects.IStudentData;
import edu.wmich.cs3310.Thompson.dataObjects.StudentData;
import edu.wmich.cs3310.Thompson.trees.BinarySearchTreeImplicit;
import edu.wmich.cs3310.Thompson.trees.IBinarySearchTreeImplicit;

/**
 * Provides the Main class. The first code to be executed to run the program.
 * @author Tyler Thompson
 *
 */
public class Main {

	/**
	 * Runs the program from the input file. See the input file for an example of excepted commands. 
	 * Execute runProgram with a data file as a parameter for testing Binary Search Trees on other input.
	 * @param args
	 */
	public static void main(String[] args) {
		
	    //When you run the program with the provided input file, there is going to be a lot of output to the console. 
	    //Make sure your console is in a large enough window to see it all. Just a fair warning. 
		runProgram("hw5cs3310F16data.txt");
		
	}
	
	/**
	 * Reads the input file specified and executes each command.
	 * @param inputFile The text file with all the commands listed line by line.
	 */
	public static void runProgram(String inputFile) {
	    IBinarySearchTreeImplicit bst = new BinarySearchTreeImplicit();
	    IFileRead fr = new FileRead();
	    ArrayList<String> instructions = fr.readfileArrayList(inputFile);
	    for ( int i = 0; i < instructions.size(); i++ ) {
		bst = executeCommand(instructions.get(i), bst);
		//bst.printTree();
	    }
	    bst.printTree();
	}
	
	/**
	 * Executes commands on a Binary Search Tree.
	 * @param command The command to execute.
	 * @param bst The Binary Search Tree to execute the command on.
	 * @return The bst after the command has been executed.
	 */
	public static IBinarySearchTreeImplicit executeCommand(String command, IBinarySearchTreeImplicit bst) {
	    String exeCommand = command.split(" ")[0].toLowerCase();
	    switch ( exeCommand ) {
	    case "insert:":
		String [] cmdData = command.replace("Insert:", "").split(",");
		IStudentData data = new StudentData(cmdData[0].trim(), Integer.valueOf(cmdData[1].trim()), cmdData[2].trim().charAt(0));
		int index = bst.insert(data);
		System.out.println("INSERT: Succesfully Inserted" + command.replace("Insert:", "") + " at index " + index);
		break;
	    case "delete:":
		String delData = command.replace("Delete:", "").trim();
		int delIndex = bst.delete(delData);
		if ( delIndex == -1) {
		    System.out.println("DELETE: Failure, " + delData + " Not found. Nothing deleted.");
		}
		else {
		    System.out.println("DELETE: Sucessfully Deleted " + delData + " from index " + delIndex);
		}
		break;
	    case "search:":
		String serData = command.replace("Search:", "").trim();
		int serIndex = bst.search(serData);
		if ( serIndex == -1 ) {
		    System.out.println("SEARCH: Failure, " + serData + " Not found.");
		}
		else {
		    System.out.println("SEARCH: Successfully found " + serData + " at index " + serIndex);
		}
		break;
	    case "inorder":
		bst.inOrderTraversal();
		break;
	    case "preorder":
		bst.preOrderTraversal();
		break;
	    case "postorder":
		bst.postOrderTraversal();
		break;
	    default:
		System.out.println("%%%% Bad instruction %%%%% " + exeCommand);
		break;
	    }
	    return bst;
	}
	
}
