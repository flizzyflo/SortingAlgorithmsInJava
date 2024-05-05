package main.java.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class provides methods for generating random integer and float values.
 */
public class NumberGenerator {

    /**
     * Generates a list of random integer values.
     *
     * @param size The size of the list to be generated.
     * @return A list of random integer values.
     */
    public static List<Integer> generateIntegerValues(int size) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Random numberGenerator = new Random();

        while (resultList.size() < size) {
            int randomNumber = numberGenerator.nextInt();
            resultList.add(randomNumber);
        }
        return resultList;
    }

    /**
     * Generates a list of random integer values within a specified boundary.
     *
     * @param size The size of the list to be generated.
     * @param boundary The upper boundary (exclusive) for the generated values.
     * @return A list of random integer values within the specified boundary.
     */
    public static List<Integer> generateIntegerValues(int size, int boundary) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Random numberGenerator = new Random();

        while (resultList.size() < size) {
            int randomNumber = numberGenerator.nextInt(boundary);
            resultList.add(randomNumber);
        }
        return resultList;
    }

    /**
     * Generates a list of random float values.
     *
     * @param size The size of the list to be generated.
     * @return A list of random float values.
     */
    public static List<Float> generateFloatValues (int size) {
        ArrayList<Float> resultList = new ArrayList<>();
        Random numberGenerator = new Random();

        while (resultList.size() < size) {
            float randomNumber = numberGenerator.nextFloat();
            resultList.add(randomNumber);
        }
        return resultList;
    }

    /**
     * Generates a list of random float values within a specified boundary.
     *
     * @param size The size of the list to be generated.
     * @param boundary The upper boundary (exclusive) for the generated values.
     * @return A list of random float values within the specified boundary.
     */
    public static List<Float> generateFloatValues (int size, int boundary) {
        ArrayList<Float> resultList = new ArrayList<>();
        Random numberGenerator = new Random();

        while (resultList.size() < size) {
            float randomNumber = numberGenerator.nextFloat(boundary);
            resultList.add(randomNumber);
        }
        return resultList;
    }
}
