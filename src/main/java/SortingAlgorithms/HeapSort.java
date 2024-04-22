package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.List;

public class HeapSort<E extends Number & Comparable<E>> extends BaseSearch<E> {

    private boolean countSteps;
    private boolean showComparedValues;
    private DrawPanel drawPanel;

    public HeapSort(List<E> dataToSort) {
        this.dataToSort = dataToSort;
    }

    public HeapSort(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
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
            if (this.drawPanel != null) {
                this.drawPanel.repaint();
            }

            // heapify again, since order of the array has changed and thus it needs to be reordered
            // inserted max element is the max of the whole heap, thus last appended element does not need to be heapified
            this.heapify(0, index);
        }
    }

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
