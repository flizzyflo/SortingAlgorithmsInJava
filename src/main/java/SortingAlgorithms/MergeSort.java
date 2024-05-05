package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.ArrayList;
import java.util.List;


/**
 * This class implements the Merge Sort algorithm to sort a list of elements.
 * It extends the BaseSearch class to inherit common sorting functionality.
 *
 * @param <E> The type of elements to be sorted, which must extend Number and implement Comparable.
 */
public class MergeSort<E extends Number & Comparable<E>> extends BaseSearch<E>{

    /**
     * Constructor to initialize MergeSort with data to be sorted.
     *
     * @param dataToSort The data to be sorted.
     */
    public MergeSort(List<E> dataToSort) {
        this.dataToSort = dataToSort;
    }

    /**
     * Constructor to initialize MergeSort with a DrawPanel for visualization.
     *
     * @param drawPanel The DrawPanel for visualization.
     */
    public MergeSort(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.listeners = new ArrayList<>();
    }

    public void sort() {
        this.sort(this.dataToSort);
    }

    /**
     * Recursively sorts the input list using the Merge Sort algorithm.
     *
     * @param unsortedData The list to be sorted.
     */
    private void sort(List<E> unsortedData) {
        int listLength = unsortedData.size();

        if (listLength < 2) {
            return;
        }

        int middleIndex = listLength / 2;
        List<E> rightHalf = new ArrayList<>(unsortedData.subList(middleIndex, listLength));
        List<E> leftHalf = new ArrayList<>(unsortedData.subList(0, middleIndex));

        sort(leftHalf);
        sort(rightHalf);
        merge(unsortedData, leftHalf, rightHalf);
    }

    /**
     * Merges two sorted lists into one sorted list.
     *
     * @param unsortedData The list to store the merged result.
     * @param leftHalf The left half of the list to be merged.
     * @param rightHalf The right half of the list to be merged.
     */
    private void merge(List<E> unsortedData, List<E> leftHalf, List<E> rightHalf) {

        int leftHalfIndex = 0;
        int rightHalfIndex = 0;
        int mergedArray = 0;

        while(leftHalfIndex < leftHalf.size() && rightHalfIndex < rightHalf.size() ) {

            if (leftHalf.get(leftHalfIndex).compareTo(rightHalf.get(rightHalfIndex)) <= 0) {
                E leftVal = leftHalf.get(leftHalfIndex);
                unsortedData.set(mergedArray, leftVal);
                leftHalfIndex++;
            }

            else if (rightHalf.get(rightHalfIndex).compareTo(leftHalf.get(leftHalfIndex)) < 0) {
                E rightVal = rightHalf.get(rightHalfIndex);
                unsortedData.set(mergedArray, rightVal);
                rightHalfIndex++;
            };
            mergedArray++;

            // draw mechanics, sleep timer manages drawing speed
            this.drawSortProcess();
        }

        while(leftHalfIndex < leftHalf.size() ) {
            E leftVal = leftHalf.get(leftHalfIndex);
            unsortedData.set(mergedArray, leftVal);
            leftHalfIndex++;
            mergedArray++;
            this.drawSortProcess();
        }

        while (rightHalfIndex < rightHalf.size() )  {
            E rightVal = rightHalf.get(rightHalfIndex);
            unsortedData.set(mergedArray, rightVal);
            rightHalfIndex++;
            mergedArray++;
            this.drawSortProcess();
        }
    }

    /**
     * Utility method to manage the drawing process during sorting.
     * It introduces a delay to control the drawing speed.
     */
    private void drawSortProcess() {
        if (this.drawPanel != null) {
            try {
                Thread.sleep(2);
                this.notifyListeners();
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
