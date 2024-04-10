package main.java.SortingAlgorithms;

import main.java.RandomNumberGenerator.NumberGenerator;
import main.java.UserInterface.DrawPanel;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<E extends Number & Comparable<E>> extends BaseSearch<E>{


    public MergeSort(List<E> dataToSort) {
        this.dataToSort = dataToSort;
    }

    public MergeSort(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    }

    public void sort() {
        sort(this.dataToSort);
    }

    private void sort( List<E> unsortedData ) {
        int listLength = unsortedData.size();
        if (listLength < 2 ) {
            return;
        }

        int middleIndex = listLength / 2;
        List<E> rightHalf = new ArrayList<>(unsortedData.subList(middleIndex, listLength));
        List<E> leftHalf = new ArrayList<>(unsortedData.subList(0, middleIndex));

        sort(leftHalf);
        sort(rightHalf);
        merge(unsortedData, leftHalf, rightHalf);
    }

    private void merge(List<E> unsortedData, List<E> leftHalf, List<E> rightHalf) {

        int leftHalfIndex = 0;
        int rightHalfIndex = 0;
        int mergedArray = 0;

        while(leftHalfIndex < leftHalf.size()  && rightHalfIndex < rightHalf.size() ) {

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

            if (this.drawPanel != null) {
                this.drawPanel.repaint();
                this.drawPanel.sleepFor(1000);
            }
        }

        while(leftHalfIndex < leftHalf.size() ) {
            E leftVal = leftHalf.get(leftHalfIndex);
            unsortedData.set(mergedArray, leftVal);
            leftHalfIndex++;
            mergedArray++;
        }

        while (rightHalfIndex < rightHalf.size() )  {
            E rightVal = rightHalf.get(rightHalfIndex);
            unsortedData.set(mergedArray, rightVal);
            rightHalfIndex++;
            mergedArray++;
        }

    };
}
