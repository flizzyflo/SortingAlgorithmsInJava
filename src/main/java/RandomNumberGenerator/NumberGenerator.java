package main.java.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    public static List<Integer> generateIntegerValues(int size) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Random numberGenerator = new Random();

        while (resultList.size() < size) {
            int randomNumber = numberGenerator.nextInt();
            resultList.add(randomNumber);
        }
        return resultList;
    }

    public static List<Integer> generateIntegerValues(int size, int boundary) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Random numberGenerator = new Random();

        while (resultList.size() < size) {
            int randomNumber = numberGenerator.nextInt(boundary);
            resultList.add(randomNumber);
        }
        return resultList;
    }

    public static List<Float> generateFloatValues (int size) {
        ArrayList<Float> resultList = new ArrayList<>();
        Random numberGenerator = new Random();

        while (resultList.size() < size) {
            float randomNumber = numberGenerator.nextFloat();
            resultList.add(randomNumber);
        }
        return resultList;
    }

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
