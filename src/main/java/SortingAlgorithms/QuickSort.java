package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Quick Sort algorithm to sort a list of elements.
 * It extends the BaseSearch class to inherit common sorting functionality.
 *
 * @param <E> The type of elements to be sorted, which must extend Number and implement Comparable.
 */
public class QuickSort<E extends Number & Comparable<E>> extends BaseSearch<E> {

    /**
     * Constructor to initialize QuickSort with data to be sorted.
     *
     * @param dataToSort The data to be sorted.
     */
    public QuickSort (List<E> dataToSort) {
        this.dataToSort = dataToSort;
    }

    /**
     * Constructor to initialize QuickSort with a DrawPanel for visualization.
     *
     * @param drawPanel The DrawPanel for visualization.
     */
    public QuickSort (DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.listeners = new ArrayList<>();
    }

    @Override
    public void sort() {

        // draw mechanics, sleep timer manages drawing speed
        if (this.drawPanel != null) {
            try {
                Thread.sleep(SortSpeed.QUICK_SORT);
                this.notifyListeners();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        int left = 0;
        int right = this.dataToSort.size() - 1;
        this.quickSort(left, right);
    }

    /**
     * Recursively sorts the input list using the Quick Sort algorithm.
     *
     * @param left The left index of the sublist to be sorted.
     * @param right The right index of the sublist to be sorted.
     */
    private void quickSort(int left, int right) {

        if (left >= right) {
            return;
        };

        E pivotElement = this.dataToSort.get(right);
        int leftPointer = left;
        int rightPointer = right;

        while (leftPointer < rightPointer) {

            while (leftPointer < rightPointer && this.dataToSort.get(leftPointer).compareTo(pivotElement) <= 0) {
                leftPointer++;
            };

            while (rightPointer > leftPointer && this.dataToSort.get(rightPointer).compareTo(pivotElement) >= 0) {
                rightPointer--;
            }

            // either pointers cross, meaning they point to same number
            // or both point to numbers which need to be switched
            this.swap(this.dataToSort, leftPointer, rightPointer);
        }

        // draw mechanics, sleep timer manages drawing speed
        if (this.drawPanel != null) {
            try {
                Thread.sleep(SortSpeed.QUICK_SORT);
                this.notifyListeners();
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        // last step, swap the left pointer element with pivot element
        this.swap(this.dataToSort, leftPointer, right);

        this.quickSort(left, leftPointer - 1);
        this.quickSort(leftPointer + 1, right);
    }

}

