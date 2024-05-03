package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort<E extends Number & Comparable<E>> extends BaseSearch<E> {

    private boolean countSteps = false;
    private boolean showComparedValues = false;

    public SelectionSort(final List<E> data, boolean countSteps, boolean showComparedValues) {
        this.dataToSort = data;
        this.countSteps = countSteps;
        this.showComparedValues = showComparedValues;
    }

    public SelectionSort(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.listeners = new ArrayList<>();
    }

    @Override
    public void sort() {

        for (int indexToBeReplaced = 0; indexToBeReplaced < this.dataToSort.size() - 1; indexToBeReplaced++) {

            int currLowestValueIndex = indexToBeReplaced;

            if (this.countSteps) {
                this.addStep();
            }

            for (int lowestValueIndex = indexToBeReplaced + 1; lowestValueIndex < this.dataToSort.size(); lowestValueIndex++) {

                if (this.countSteps) {
                    this.addStep();
                }

                if (this.showComparedValues) {
                    System.out.println("Currently comparing '" + this.dataToSort.get(lowestValueIndex) + "' and '" + this.dataToSort.get(indexToBeReplaced) + "'");
                }

                if (this.currentValueIsLowestValue(lowestValueIndex, currLowestValueIndex)) {
                    currLowestValueIndex = lowestValueIndex;
                }

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

            if (currLowestValueIndex == indexToBeReplaced) {
                continue;
            }

            // swap values; min value of the current iteration and most left value.
            E currentLowestValue = this.dataToSort.get(currLowestValueIndex);
            E valueToBeReplaced = this.dataToSort.get(indexToBeReplaced);

            this.dataToSort.set(indexToBeReplaced, currentLowestValue);
            this.dataToSort.set(currLowestValueIndex, valueToBeReplaced);

        }
    }


    private boolean currentValueIsLowestValue(int currentValue, int minValueIdx) {
        return this.dataToSort.get(currentValue).compareTo(this.dataToSort.get(minValueIdx)) < 0;
    }
}
