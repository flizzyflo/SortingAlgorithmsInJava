package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.List;


/**
 * This class serves as a base for implementing sorting algorithms.
 * It provides common functionality and properties that can be used by concrete sorting algorithms.
 *
 * @param <E> The type of elements to be sorted, which must extend Number and implement Comparable.
 */
public class BaseSearch<E extends Number & Comparable<E>> extends AbstractSort <E>{

    protected int stepCounter = 0;
    protected List<E> dataToSort = null;
    protected DrawPanel drawPanel = null;
    protected List<DrawPanel> listeners;


    @Override
    public void sort(){};

    /**
     * Swaps two elements in a list.
     *
     * @param container The list containing the elements to be swapped.
     * @param left The index of the first element to be swapped.
     * @param right The index of the second element to be swapped.
     */
    public void swap(List<E> container, int left, int right) {
        E temp = container.get(left);
        container.set(left, container.get(right));
        container.set(right, temp);
    }

    /**
     * Increments the step counter to track sorting steps.
     */
    protected void addStep() { this.stepCounter ++; };

    /**
     * Sets the data to be sorted.
     *
     * @param data The data to be sorted.
     */
    public void setDataToSort(List<E> data) {this.dataToSort = data;}


    /**
     * Gets the number of steps performed during sorting.
     *
     * @return The number of steps performed during sorting.
     */
    public int getSteps() { return this.stepCounter; }


    /**
     * Gets the data to be sorted.
     *
     * @return The data to be sorted.
     */
    public List<E> getData() { return this.dataToSort; }

    /**
     * Checks if a list is sorted in ascending order.
     *
     * @param data The list to be checked.
     * @return True if the list is sorted in ascending order, false otherwise.
     */
    public boolean isSorted(List<E> data) {

        int idx = 1;
        while (idx < data.size()) {
            if (data.get(idx-1).compareTo(data.get(idx)) > 0) {
                return false;
            }
            idx++;
        }
        return true;
    }

    /**
     * Adds a listener to receive notifications from the draw panel.
     *
     * @param listener The listener to be added.
     */
    public void addListener(DrawPanel listener) {
        this.listeners.add(listener);
    };


    /**
     * Removes a listener from receiving notifications from the draw panel.
     *
     * @param listener The listener to be removed.
     */
    public void removeListener(DrawPanel listener) {
        this.listeners.remove(listener);
    };

    /**
     * Notifies all registered listeners.
     */
    public void notifyListeners() {
        for (DrawPanel currentPanel: this.listeners) {
            currentPanel.receiveNotification();
        }
    }
}
