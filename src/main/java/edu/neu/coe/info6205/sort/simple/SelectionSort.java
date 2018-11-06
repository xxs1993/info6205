package edu.neu.coe.info6205.sort.simple;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {

    /**
     * Constructor for SelectionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public SelectionSort(Helper<X> helper) {
        this.helper = helper;
    }

    public SelectionSort() {
        this(new Helper<>("SelectionSort"));
    }

    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement selection sort
    }

    @Override
    public String toString() {
        return helper.toString();
    }

    public Helper<X> getHelper() {
        return helper;
    }

    private final Helper<X> helper;
}
