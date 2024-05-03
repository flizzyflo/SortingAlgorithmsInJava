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

    public DrawPanel getDrawPanel() {
        return this.dp;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_S) {
            this.dp.generateListElements(this.dp.getBarCount(), 450);
        };

        if (keyCode == KeyEvent.VK_T) {
            BubbleSort<Integer> bs = new BubbleSort<Integer>(this.getDrawPanel());
            bs.addListener(this.getDrawPanel());
            bs.setDataToSort(this.getDrawPanel().getUnsortedNumbers());
            new Thread(bs::sort).start();
        }

        if (keyCode == KeyEvent.VK_Z) {
            HeapSort<Integer> hs = new HeapSort<Integer>(this.getDrawPanel());
            hs.addListener(this.getDrawPanel());
            hs.setDataToSort(this.getDrawPanel().getUnsortedNumbers());
            new Thread(hs::sort).start();
        }

        if (keyCode == KeyEvent.VK_U) {
            MergeSort<Integer> ms = new MergeSort<Integer>(this.getDrawPanel());
            ms.addListener(this.getDrawPanel());
            ms.setDataToSort(this.getDrawPanel().getUnsortedNumbers());
            new Thread(ms::sort).start();
        }

        if (keyCode == KeyEvent.VK_I) {
            SelectionSort<Integer> ss = new SelectionSort<Integer>(this.getDrawPanel());
            ss.addListener(this.getDrawPanel());
            ss.setDataToSort(this.getDrawPanel().getUnsortedNumbers());
            new Thread(ss::sort).start();
        }

        if (keyCode == KeyEvent.VK_O) {
            RadixSort<Integer> rs = new RadixSort<>(this.getDrawPanel());
            rs.addListener(this.getDrawPanel());
            rs.setDataToSort(this.getDrawPanel().getUnsortedNumbers());
            new Thread(rs::sort).start();
        }

        if (keyCode == KeyEvent.VK_P) {
            QuickSort<Integer> qs = new QuickSort<>(this.getDrawPanel());
            qs.addListener(this.getDrawPanel());
            qs.setDataToSort(this.getDrawPanel().getUnsortedNumbers());
            new Thread(qs::sort).start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
