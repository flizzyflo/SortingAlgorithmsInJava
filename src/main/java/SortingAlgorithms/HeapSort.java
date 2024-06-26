package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.ArrayList;
import java.util.List;


/**
 * This class implements the Heap Sort algorithm to sort a list of elements.
 * It extends the BaseSearch class to inherit common sorting functionality.
 *
 * @param <E> The type of elements to be sorted, which must extend Number and implement Comparable.
 */
public class HeapSort<E extends Number & Comparable<E>> extends BaseSearch<E> {

    private boolean countSteps;
    private boolean showComparedValues;
    private DrawPanel drawPanel;

    /**
     * Constructor to initialize HeapSort with data to be sorted.
     *
     * @param dataToSort The data to be sorted.
     */
    public HeapSort(List<E> dataToSort) {
        this.dataToSort = dataToSort;
    }

    /**
     * Constructor to initialize HeapSort with a DrawPanel for visualization.
     *
     * @param drawPanel The DrawPanel for visualization.
     */
    public HeapSort(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.listeners = new ArrayList<>();
    }

    @Override
    public void sort() {
        int totalElementCount = this.dataToSort.size();

        // heapify the dataToSort, turns it into a max-heap. having the maximum value as node, second and third
        // as the childs of the first partent, and so on
        for (int index = Math.floorDiv(totalElementCount, 2); index >= 0; index--) {
            this.heapify( index, totalElementCount);
        };

        // go backward starting from lowest index, which is the lowest value within the heap.
        // reverts the order, doing nothing else.
        for (int index = totalElementCount - 1; index >= 0; index--){

            E tempMaxElementValue =  this.dataToSort.getFirst();
            E tempLowestElementValue =  this.dataToSort.get(index);

            this.dataToSort.set(0, tempLowestElementValue);
            this.dataToSort.set(index, tempMaxElementValue);

            // draw mechanics, sleep timer manages drawing speed
            if (this.drawPanel != null) {
                try {
                    Thread.sleep(SortSpeed.HEAP_SORT);
                    this.notifyListeners();
                }
                catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            // heapify again, since order of the array has changed and thus it needs to be reordered
            // inserted max element is the max of the whole heap, thus last appended element does not need to be heapified
            this.heapify(0, index);
        }
    }

    /**
     * Adjusts the heap to maintain the heap property.
     *
     * @param parentIndex The index of the parent node.
     * @param numberOfElements The number of elements in the heap.
     */
    private void heapify(int parentIndex, int numberOfElements) {

        int maxNumberIndex = parentIndex;

        // Calculation for "tree-type" indices below the parent element
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        // is left child index in range, meaning the element is allowed to be heapified and is left child bigger than current max number
        if (leftChildIndex < numberOfElements && (this.dataToSort.get(leftChildIndex).compareTo(this.dataToSort.get(maxNumberIndex))) >= 0 ) {
            maxNumberIndex = leftChildIndex;
        }

        // is right child index in range, meaning the element is allowed to be heapified and is right child bigger than current max number
        if (rightChildIndex < numberOfElements && (this.dataToSort.get(rightChildIndex).compareTo(this.dataToSort.get(maxNumberIndex))) >= 0 ) {
            maxNumberIndex = rightChildIndex;
        }

        // if maxNumber is parent, nothing has to change, else swithc current parent with higher value
        // if maxNumber > parentNumber changes required
        if (maxNumberIndex != parentIndex){
            E tempParentVal = this.dataToSort.get(parentIndex);
            E tempMaxVal = this.dataToSort.get(maxNumberIndex);

            // switch both values, since max value is higher than and not current parent
            // maxValue wird parent, former parent goes to former position of new parent
            this.dataToSort.set(parentIndex, tempMaxVal);
            this.dataToSort.set(maxNumberIndex, tempParentVal);

            // check for child tree part of the item which is switched since there can be more switches required
            // parent is the former parent, since this leads to possible changes within the following tree structure
            this.heapify( maxNumberIndex, numberOfElements);
        }
    }
}
