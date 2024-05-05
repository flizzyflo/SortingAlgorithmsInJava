package main.java.SortingAlgorithms;


public abstract class AbstractSort<E extends Number & Comparable<E>> {

    /**
     * Sort method to be implemented by concrete sorting algorithms.
     */
    abstract public void sort();

}

