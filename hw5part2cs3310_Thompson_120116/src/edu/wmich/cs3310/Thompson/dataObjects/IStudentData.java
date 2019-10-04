package edu.wmich.cs3310.Thompson.dataObjects;

/**
 * Provides the IStudentData interface.
 * @author Tyler Thompson
 *
 */
public interface IStudentData {

    	/**
    	 * Get the name of the student.
    	 * @return the name as a String.
    	 */
	String getName();
	
	/**
	 * Set the name of the student.
	 * @param name the name as a String.
	 */
	void setName(String name);
	
	/**
	 * Get the students course number
	 * @return the course number as an int.
	 */
	int getCourseNumber();
	
	/**
	 * Set the students course number.
	 * @param courseNumber the course number as an int.
	 */
	void setCourseNumber(int courseNumber);
	
	/**
	 * Gets the grade of the student as a char.
	 * @return the grade as a char.
	 */
	char getGrade();
	
	/**
	 * Set the students grade.
	 * @param grade the grade as a char.
	 */
	void setGrade(char grade);
	
}
