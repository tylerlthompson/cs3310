package edu.wmich.cs3310.Thompson.comparators;

/**
 * Provides the Interface for the Compare class for comparing generic data types.
 * @author Tyler Thompson
 *
 * @param <E> Generic Data Type
 */
public interface ICompare<E> {

    /**
     * Compares data1 to data2. If data1 is smaller than data2, then it returns true, otherwise it returns false.
     * @param data1  data to compare to data2.
     * @param data2  data to be compared to.
     * @return true if data1 is smaller than data2, false otherwise.
     */
    boolean compare(E data1, E data2);
    
}
