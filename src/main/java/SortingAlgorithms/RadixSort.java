package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RadixSort<E extends Number & Comparable<E>> extends BaseSearch<E>{

    private final int baseFactor;
    private final HashMap<Integer, List<E>> bucket;
    private E maxNumber;
    private int maxNumberDigitCount;

    public RadixSort (DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.baseFactor = 10;
        this.bucket = new HashMap<Integer, List<E>>();
        this.listeners = new ArrayList<>();
    }

    public RadixSort (List<E> dataToSort) {
        this.dataToSort = dataToSort;
        this.maxNumber = this.getMaximumNumberOfData();
        this.maxNumberDigitCount = maxNumber.toString().length();
        this.baseFactor = 10;
        this.bucket = new HashMap<Integer, List<E>>();
        this.listeners = new ArrayList<>();
    }

    public RadixSort (List<E> dataToSort, int baseFactor) {
        this.dataToSort = dataToSort;
        this.maxNumber = this.getMaximumNumberOfData();
        this.maxNumberDigitCount = maxNumber.toString().length();
        this.baseFactor = baseFactor;
        this.bucket = new HashMap<Integer, List<E>>();
        this.listeners = new ArrayList<>();
    }

    /**
     * Main sorting algorithm, uses several helper methods to sort values into buckets and update the under-
     * lying base data. Performs sort within the original datastructure which was passed in.
     */
    @Override
    public void sort() {
        if (this.drawPanel != null) {
            this.maxNumber = this.getMaximumNumberOfData();
            this.maxNumberDigitCount = maxNumber.toString().length();
        }

        int numberPositionToGrab = 1;
        this.initializeBucket();
        int factor = numberPositionToGrab;
        int bucketNumber;
        while (numberPositionToGrab <= this.maxNumberDigitCount) {


            // put elements into bucket
            for (E value: this.dataToSort) {
                bucketNumber = this.identifyBucketNumberFor(value, factor);
                this.insertIntoBucket(bucketNumber, value);

            }
            // place of number to use for bucketizing, e.g. numberPositionToGrab = 1 means for 1537 bucket 7,
            // numberPositionToGrab = 2 would be 3 and so on
            numberPositionToGrab++;
            // update factor for identifying the relevant bucket
            factor = factor * this.baseFactor;
            // update data in base array
            this.updateDataToBeSorted();

            // clear buckets for next iteration
            this.clearBuckets();

            if (this.drawPanel != null) {
                try {
                    Thread.sleep(300);
                    this.notifyListeners();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }


    private E getMaximumNumberOfData() {
        E curMax = null;
        for (E value: this.dataToSort) {

            if (curMax == null) {
                curMax = value;
            }

            else if (value.compareTo(curMax) > 0) {
                curMax = value;
            }
        }
        return curMax;
    }

    /**
     * This method sets up the required buckets according to the possible numbers.
     */
    private void initializeBucket() {
        for (int bucketNumber = 0; bucketNumber < this.baseFactor; bucketNumber++) {
            this.bucket.put(bucketNumber, new ArrayList<E>());
        }
    }

    /**
     * This method identifies the relevant bucketnumber for a specific value.
     * @param value The value which the relevant bucket should be identified for
     * @param factor The factor by which the value is divided to identify the relvant bucket number.
     * @Returns The bucketnumber of the specific number for this specific iteration
     */
    private int identifyBucketNumberFor(E value, int factor) {
        int bucketNumber;
        bucketNumber = ( (value.intValue() / factor ) % this.baseFactor);
        return bucketNumber;
    };

    /**
     * This method inserts the value into the specific bucket.
     * @param value The value which the relevant bucket should be identified for
     * @param bucketNumber Relevant bucketnumber to put the value in to
     */
    private void insertIntoBucket (int bucketNumber, E value) {
        List<E> bucketList = this.bucket.get(bucketNumber);
        bucketList.add(value);
    };

    /**
     * Updates the base data after every single sorting iteration to represent the newest sort result
     */
    private void updateDataToBeSorted() {
        this.dataToSort.clear();
        for (int bucket = 0; bucket < this.bucket.keySet().size(); bucket++) {
            List<E> bucketToAdd = this.bucket.get(bucket);
            this.dataToSort.addAll(bucketToAdd);

            if (this.drawPanel != null) {
                this.drawPanel.repaint();
            }
        }
    }

    /**
     * Clears every bucket after the values where passed into the base data according to their new order.
     */
    private void clearBuckets() {
        for (int bucket = 0; bucket < this.bucket.keySet().size(); bucket++) {
            List<E> bucketToClear = this.bucket.get(bucket);
            bucketToClear.clear();
        }
    }
}
