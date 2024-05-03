package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.ArrayList;
import java.util.List;

public class QuickSort<E extends Number & Comparable<E>> extends BaseSearch<E> {


    public QuickSort (List<E> dataToSort) {
        this.dataToSort = dataToSort;
    }

    public QuickSort (DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.listeners = new ArrayList<>();
    }

    @Override
    public void sort() {

        // draw mechanics, sleep timer manages drawing speed
        if (this.drawPanel != null) {
            try {
                Thread.sleep(50);
                this.notifyListeners();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        int left = 0;
        int right = this.dataToSort.size() - 1;
        this.quickSort(left, right);
    }

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
                Thread.sleep(50);
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

