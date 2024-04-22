package main.java.UserInterface;

import main.java.SortingAlgorithms.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardListener implements KeyListener {

    private DrawPanel dp;

    public KeyBoardListener(DrawPanel dp) {
        this.dp = dp;
    };


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_S) {
            this.dp.generateListElements(this.dp.getBarCount(), 450);
        };

        if (keyCode == KeyEvent.VK_T) {
            this.dp.startSortingWith(new BubbleSort<Integer>(this.dp));
        }

        if (keyCode == KeyEvent.VK_Z) {
            this.dp.startSortingWith(new HeapSort<Integer>(this.dp));
        }

        if (keyCode == KeyEvent.VK_U) {
            this.dp.startSortingWith(new MergeSort<Integer>(this.dp));
        }

        if (keyCode == KeyEvent.VK_I) {
            this.dp.startSortingWith(new SelectionSort<Integer>(this.dp));
        }

        if (keyCode == KeyEvent.VK_O) {
            this.dp.startSortingWith(new RadixSort<Integer>(this.dp));
        }

        if (keyCode == KeyEvent.VK_P) {
            this.dp.startSortingWith(new QuickSort<Integer>(this.dp));
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
