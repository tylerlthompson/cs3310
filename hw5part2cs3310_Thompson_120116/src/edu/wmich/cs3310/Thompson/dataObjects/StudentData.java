package edu.wmich.cs3310.Thompson.dataObjects;

/**
 * Provides the StudentData class implementing the IStudentData interface.
 * @author Tyler Thompson
 *
 */
public class StudentData implements IStudentData {

	private String name;
	private int courseNumber;
	private char grade;
	
	/**
	 * StudentData constructor.
	 * @param name The name of the student as a String.
	 * @param courseNumber The course number as an int.
	 * @param grade The grade as a char.
	 */
	public StudentData(String name, int courseNumber, char grade){
		this.setName(name);
		this.setCourseNumber(courseNumber);
		this.setGrade(grade);
	}
	
	/**
    	 * Get the name of the student.
    	 * @return the name as a String.
    	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name of the student.
	 * @param name the name as a String.
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the students course number
	 * @return the course number as an int.
	 */
	@Override
	public int getCourseNumber() {
		return this.courseNumber;
	}

	/**
	 * Set the students course number.
	 * @param courseNumber the course number as an int.
	 */
	@Override
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * Gets the grade of the student as a char.
	 * @return the grade as a char.
	 */
	@Override
	public char getGrade() {
		return this.grade;
	}

	/**
	 * Set the students grade.
	 * @param grade the grade as a char.
	 */
	@Override
	public void setGrade(char grade) {
		this.grade = grade;
	}

}
