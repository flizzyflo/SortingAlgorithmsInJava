package main.java.UserInterface;
import main.java.RandomNumberGenerator.NumberGenerator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    private List<Integer> unsortedNumbers = null;
    private final int BLOCK_OFFSET = 2;
    private final int BAR_COUNT = 250;
    private final int BLOCK_WIDTH = 3;
    private final List<Color> colorsForUnsortedBars = new ArrayList<>(Arrays.asList(Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY));

    private int parentFrameWidth;
    private int parentFrameHeight;

    public DrawPanel() {
        JLabel sortingControls = new JLabel(" T - BubbleSort | Z - HeapSort | U - MergeSort | I - SelectionSort | O - RadixSort | P - Quicksort | S - Shuffle List");
        this.add(sortingControls);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        int xValueForMid = this.calculateFrameMidX();
        int yValueForMid = this.calculateFrameMidY();
        int colorIndex;
        int height;
        int colorCount = colorsForUnsortedBars.size();

        for (int element: this.unsortedNumbers) {
            height = element;
            colorIndex = element % colorCount;

            Color color = colorsForUnsortedBars.get(colorIndex);
            g.setColor(color);

            g.fillRect(xValueForMid, yValueForMid, BLOCK_WIDTH, height);
            xValueForMid = xValueForMid + BLOCK_WIDTH + BLOCK_OFFSET;
        }
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public void generateListElements() {
        this.unsortedNumbers = NumberGenerator.generateIntegerValues(BAR_COUNT, 450);
        this.repaint();
    }

    public void generateListElements(int size, int maxValue) {
        this.unsortedNumbers = NumberGenerator.generateIntegerValues(size, maxValue);
        this.repaint();
    }

    public int calculateFrameMidX() {
        int halfScreenWidth = this.parentFrameWidth / 2;
        return (halfScreenWidth / 8);
    }

    public int calculateFrameMidY() {
        int halfScreenHeight = this.parentFrameHeight / 2;
        return halfScreenHeight - (halfScreenHeight / 2);
    }

    public void setFrameSize(Dimension screenSize) {
        this.parentFrameWidth = screenSize.width;
        this.parentFrameHeight = screenSize.height;
    }

    public int getBarCount() {
        return BAR_COUNT;
    }

    public void receiveNotification() {
        this.repaint();

    }

    public List<Integer> getUnsortedNumbers() {
        return this.unsortedNumbers;
    }
}
