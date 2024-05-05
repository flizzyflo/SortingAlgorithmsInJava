package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class implements the Radix Sort algorithm to sort a list of elements.
 * It extends the BaseSearch class to inherit common sorting functionality.
 *
 * @param <E> The type of elements to be sorted, which must extend Number and implement Comparable.
 */
public class RadixSort<E extends Number & Comparable<E>> extends BaseSearch<E>{

    private final int baseFactor;
    private final HashMap<Integer, List<E>> bucket;
    private E maxNumber;
    private int maxNumberDigitCount;

    /**
     * Constructor to initialize RadixSort with a DrawPanel for visualization.
     *
     * @param drawPanel The DrawPanel for visualization.
     */
    public RadixSort (DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.baseFactor = 10;
        this.bucket = new HashMap<Integer, List<E>>();
        this.listeners = new ArrayList<>();
    }

    /**
     * Constructor to initialize RadixSort with data to be sorted.
     *
     * @param dataToSort The data to be sorted.
     */
    public RadixSort (List<E> dataToSort) {
        this.dataToSort = dataToSort;
        this.maxNumber = this.getMaximumNumberOfData();
        this.maxNumberDigitCount = maxNumber.toString().length();
        this.baseFactor = 10;
        this.bucket = new HashMap<Integer, List<E>>();
        this.listeners = new ArrayList<>();
    }

    /**
     * Constructor to initialize RadixSort with data to be sorted and a custom base factor.
     *
     * @param dataToSort The data to be sorted.
     * @param baseFactor The base factor for radix sort.
     */
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

    /**
     * Finds the maximum number in the dataset.
     *
     * @return The maximum number in the dataset.
     */
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
     * Initializes the buckets required for radix sort.
     */
    private void initializeBucket() {
        for (int bucketNumber = 0; bucketNumber < this.baseFactor; bucketNumber++) {
            this.bucket.put(bucketNumber, new ArrayList<E>());
        }
    }

    /**
     * Identifies the relevant bucket number for a specific value.
     *
     * @param value The value for which the bucket number should be identified.
     * @param factor The factor used to identify the bucket number.
     * @return The bucket number for the specified value.
     */
    private int identifyBucketNumberFor(E value, int factor) {
        int bucketNumber;
        bucketNumber = ( (value.intValue() / factor ) % this.baseFactor);
        return bucketNumber;
    };

    /**
     * Inserts the value into the specified bucket.
     *
     * @param bucketNumber The bucket number where the value should be inserted.
     * @param value The value to be inserted.
     */
    private void insertIntoBucket (int bucketNumber, E value) {
        List<E> bucketList = this.bucket.get(bucketNumber);
        bucketList.add(value);
    };

    /**
     * Updates the base data after each sorting iteration.
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
