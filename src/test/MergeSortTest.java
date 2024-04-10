package test;

import main.java.RandomNumberGenerator.NumberGenerator;
import main.java.SortingAlgorithms.HeapSort;
import main.java.SortingAlgorithms.MergeSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private MergeSort<Integer> MergeSortInteger;
    private MergeSort<Float> MergeSortFloat;

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

        MergeSortInteger = new MergeSort<>(ints);
        MergeSortFloat = new MergeSort<>(floats);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortFloats(){
        MergeSortFloat.sort();
        Collections.sort(floats2);
        assertArrayEquals(floats2.toArray(), floats.toArray());
    }
    @Test
    void sortInts(){
        MergeSortInteger.sort();
        Collections.sort(ints2);
        assertArrayEquals(ints2.toArray(), ints.toArray());
    }
}