package main.java.SortingAlgorithms;

import main.java.UserInterface.DrawPanel;

import java.util.List;

public class BaseSearch<E extends Number & Comparable<E>> extends AbstractSort <E>{

    protected int stepCounter = 0;
    protected List<E> dataToSort = null;
    protected DrawPanel drawPanel = null;
    protected List<DrawPanel> listeners;

    @Override
    public void sort(){};

    public void swap(List<E> container, int left, int right) {
        E temp = container.get(left);
        container.set(left, container.get(right));
        container.set(right, temp);
    }

    protected void addStep() { this.stepCounter ++; };

    public void setDataToSort(List<E> data) {this.dataToSort = data;}

    public int getSteps() { return this.stepCounter; }

    public List<E> getData() { return this.dataToSort; }

    public boolean isSorted(List<E> data) {

        int idx = 1;
        while (idx < data.size()) {
            if (data.get(idx-1).compareTo(data.get(idx)) > 0) {
                return false;
            }
            idx++;
        }
        return true;
    }

    public void addListener(DrawPanel listener) {
        this.listeners.add(listener);
    };

    public void removeListener(DrawPanel listener) {
        this.listeners.remove(listener);
    };

    public void notifyListeners() {
        for (DrawPanel currentPanel: this.listeners) {
            currentPanel.receiveNotification();
        }
    }
}
