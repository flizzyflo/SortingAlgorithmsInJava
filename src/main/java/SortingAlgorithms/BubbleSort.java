package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.List;

public class BubbleSort<E extends Number & Comparable<E>> extends BaseSearch<E> {

    private boolean countSteps;
    private boolean showComparedValues;
    private DrawPanel drawPanel = null;

    public BubbleSort(final List<E> data, boolean countSteps, boolean showComparedValues) {
        this.dataToSort = data;
        this.countSteps = countSteps;
        this.showComparedValues = showComparedValues;
    };

    public BubbleSort(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    };

    @Override
    public void sort() {

        if (this.dataToSort.isEmpty()) {
            return;
        }

        int currPosition = 0;

        while (currPosition < this.dataToSort.size()) {

            // decrease by current index position, since element will bubble to the end and is the highest respective second biggest etc.
            // iteration does not need to go to the last element and so on since this part is already sorted.
            for (int sortPosition = 0; sortPosition < this.dataToSort.size() - 1 - currPosition; sortPosition++) {
                E leftValue = this.dataToSort.get(sortPosition);
                E rightValue = this.dataToSort.get(sortPosition + 1);

                if (this.countSteps) {
                    this.addStep();
                }

                if (this.showComparedValues) {
                    System.out.println("Currently comparing '" + leftValue + "' and '" + rightValue + "'");
                }

                if (this.leftValueBiggerThanRight(leftValue, rightValue)) {
                    // value switch is required
                    this.dataToSort.set(sortPosition, rightValue);
                    this.dataToSort.set(sortPosition + 1, leftValue);

                    if (this.drawPanel != null) {
                        this.drawPanel.sleepFor(1);
                    }
                }
            }
            currPosition ++;
            if (this.countSteps) {
                this.addStep();
            }
        }
    }


    private boolean leftValueBiggerThanRight(E leftValue, E rightValue) {
        return leftValue.compareTo(rightValue) > 0;
    }

}
