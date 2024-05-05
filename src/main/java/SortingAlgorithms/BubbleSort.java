package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Bubble Sort algorithm to sort a list of elements.
 * It extends the BaseSearch class to inherit common sorting functionality.
 *
 * @param <E> The type of elements to be sorted, which must extend Number and implement Comparable.
 */
public class BubbleSort<E extends Number & Comparable<E>> extends BaseSearch<E> {

    private boolean countSteps;
    private boolean showComparedValues;
    private DrawPanel drawPanel = null;

    /**
     * Constructor to initialize BubbleSort with data to be sorted, and options for counting steps and displaying compared values.
     *
     * @param data The data to be sorted.
     * @param countSteps Flag to indicate whether to count sorting steps.
     * @param showComparedValues Flag to indicate whether to display compared values during sorting.
     */
    public BubbleSort(final List<E> data, boolean countSteps, boolean showComparedValues) {
        this.dataToSort = data;
        this.countSteps = countSteps;
        this.showComparedValues = showComparedValues;
        this.listeners = new ArrayList<>();
    };

    /**
     * Constructor to initialize BubbleSort with a DrawPanel for visualization.
     *
     * @param drawPanel The DrawPanel for visualization.
     */
    public BubbleSort(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        this.listeners = new ArrayList<>();
    };

    @Override
    public void addListener(DrawPanel listener) {
        super.addListener(listener);
    }

    @Override
    public void notifyListeners() {
        super.notifyListeners();
    }

    /**
     * Implements the Bubble Sort algorithm to sort the data.
     */
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

                // value switch is required
                if (this.leftValueBiggerThanRight(leftValue, rightValue)) {
                    this.swap(this.dataToSort, sortPosition, sortPosition + 1);

                    if (this.drawPanel != null) {
                        try {
                            Thread.sleep(10);
                            this.notifyListeners();
                        }
                        catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            currPosition ++;
            if (this.countSteps) {
                this.addStep();
            }
        }
    }

    /**
     * Checks if the left value is greater than the right value.
     *
     * @param leftValue The left value.
     * @param rightValue The right value.
     * @return True if the left value is strictly greater than the right value, false otherwise.
     */
    private boolean leftValueBiggerThanRight(E leftValue, E rightValue) {
        return leftValue.compareTo(rightValue) > 0;
    }

}
