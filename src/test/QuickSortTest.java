package test;

import main.java.RandomNumberGenerator.NumberGenerator;
import main.java.SortingAlgorithms.BubbleSort;
import main.java.SortingAlgorithms.QuickSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    private QuickSort<Integer> quickSortInteger;
    private QuickSort<Float> quickSortFloat;
    private List<Float> floats;
    private List<Float> floats2;
    private List<Integer> ints;
    private List<Integer> ints2;

    @BeforeEach
    void setUp() {
        final int SIZE = 1000000;
        final int MAX_VALUE = 10000;
        floats = NumberGenerator.generateFloatValues(SIZE, MAX_VALUE);
        floats2 = new ArrayList<>();
        floats2.addAll(floats);
        ints = NumberGenerator.generateIntegerValues(SIZE, MAX_VALUE);
        ints2 = new ArrayList<>();
        ints2.addAll(ints);

        quickSortFloat = new QuickSort<Float>(floats);
        quickSortInteger = new QuickSort<Integer>(ints);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortFloats() {
        quickSortFloat.sort();
        Collections.sort(floats2);
        assertArrayEquals(floats2.toArray(), floats.toArray());
    }

    @Test
    void sortInts(){
        quickSortInteger.sort();
        Collections.sort(ints2);
        assertArrayEquals(ints2.toArray(), ints.toArray() );
    }
}