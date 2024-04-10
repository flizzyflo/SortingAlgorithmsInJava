package test;

import main.java.RandomNumberGenerator.NumberGenerator;
import main.java.SortingAlgorithms.RadixSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    private RadixSort<Integer> radixSortInteger;

    private List<Integer> ints;
    private List<Integer> ints2;

    @BeforeEach
    void setUp() {
        final int SIZE = 1000;
        final int MAX_VALUE = 10000;

        ints = NumberGenerator.generateIntegerValues(SIZE, MAX_VALUE);
        ints2 = new ArrayList<>();
        ints2.addAll(ints);

        radixSortInteger = new RadixSort<>(ints);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void sortInts(){
        radixSortInteger.sort();
        Collections.sort(ints2);
        assertArrayEquals(ints2.toArray(), ints.toArray() );
    }
}