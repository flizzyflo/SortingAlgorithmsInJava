package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort<E extends Number & Comparable<E>> extends BaseSearch<E> {

    private boolean countSteps;
    private boolean showComparedValues;
    private DrawPanel drawPanel = null;

    public BubbleSort(final List<E> data, boolean countSteps, boolean showComparedValues) {
        this.dataToSort = data;
        this.countSteps = countSteps;
        this.showComparedValues = showComparedValues;
        this.listeners = new ArrayList<>();
    };

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

    private boolean leftValueBiggerThanRight(E leftValue, E rightValue) {
        return leftValue.compareTo(rightValue) > 0;
    }

}
