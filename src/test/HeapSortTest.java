package test;

import main.java.RandomNumberGenerator.NumberGenerator;
import main.java.SortingAlgorithms.HeapSort;
import main.java.SortingAlgorithms.SelectionSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    private HeapSort<Integer> heapSortInteger;
    private HeapSort<Float> heapSortFloat;

    private List<Integer> ints;
    private List<Integer> ints2;
    private List<Float> floats;
    private List<Float> floats2;
    @BeforeEach
    void setUp() {
        final int SIZE = 1000;
        final int MAX_VALUE = 10000;
        ints = NumberGenerator.generateIntegerValues(SIZE, MAX_VALUE);
        ints2 = new ArrayList<>();
        ints2.addAll(ints);

        floats = NumberGenerator.generateFloatValues(SIZE, MAX_VALUE);
        floats2 = new ArrayList<>();
        floats2.addAll(floats);

        heapSortInteger = new HeapSort<>(ints);
        heapSortFloat = new HeapSort<>(floats);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortFloats(){
        heapSortFloat.sort();
        Collections.sort(floats2);
        assertArrayEquals(floats2.toArray(), floats.toArray());
    }
    @Test
    void sortInts(){
        heapSortInteger.sort();
        Collections.sort(ints2);
        assertArrayEquals(ints2.toArray(), ints.toArray() );
    }
}