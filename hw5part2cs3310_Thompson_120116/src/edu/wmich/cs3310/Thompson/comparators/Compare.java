package edu.wmich.cs3310.Thompson.comparators;

/**
 * Provides the Compare class used for comparing two generic data types.
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type
 */
public class Compare<E extends Comparable<E>> implements ICompare<E> {

    public Compare(){}
    
    /**
     * Compares data1 to data2. If data1 is smaller than data2, then it returns true, otherwise it returns false.
     * @param data1  data to compare to data2.
     * @param data2  data to be compared to.
     * @return true if data1 is smaller than data2, false otherwise.
     */
    @Override
    public boolean compare(E data1, E data2) {
	if ( this.testNumber(data1) == true ) {
		int size1 = data1.toString().split("\\.")[0].length();
		int size2 = data2.toString().split("\\.")[0].length();
		if ( size1 > size2 ) {
		    return false;
		}
		else if ( size1 < size2 ) {
		    return true;
		}
		else {
		    if ( data1.toString().compareTo(data2.toString()) < 0 ) {
			return true;
		    }
		    else {
			return false;
		    }
		}
	    }
	    else {
		if ( data1.toString().compareTo(data2.toString()) < 0 ) {
		    return true;
		}
		else {
		    return false;
		}
	    }
    }

    /**
     * Tests if a given data type is some sort of number.
     * @param data  The data to test.
     * @return True - If the data is a form of number. False - The data is not a number.
     */
    private boolean testNumber(E data) {
	try {
	    Integer.valueOf(data.toString());
	    return true;
	} catch (Exception e) {
	    return false;
	}
	    
    }
}
