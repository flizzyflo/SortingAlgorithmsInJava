package test;

import main.java.RandomNumberGenerator.NumberGenerator;
import main.java.SortingAlgorithms.BubbleSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private BubbleSort<Integer> bubbleSortInteger;
    private BubbleSort<Float> bubbleSortFloat;
    private List<Float> floats;
    private List<Float> floats2;
    private List<Integer> ints;
    private List<Integer> ints2;

    @BeforeEach
    void setUp() {
        final int SIZE = 1000;
        final int MAX_VALUE = 10000;
        floats = NumberGenerator.generateFloatValues(SIZE, MAX_VALUE);
        floats2 = new ArrayList<>();
        floats2.addAll(floats);
        ints = NumberGenerator.generateIntegerValues(SIZE, MAX_VALUE);
        ints2 = new ArrayList<>();
        ints2.addAll(ints);

        bubbleSortFloat = new BubbleSort<>(floats, false, false);
        bubbleSortInteger = new BubbleSort<>(ints, false, false);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortFloats() {
        bubbleSortFloat.sort();
        Collections.sort(floats2);
        assertArrayEquals(floats2.toArray(), floats.toArray());
    }

    @Test
    void sortInts(){
        bubbleSortInteger.sort();
        Collections.sort(ints2);
        assertArrayEquals(ints2.toArray(), ints.toArray());
    }
}