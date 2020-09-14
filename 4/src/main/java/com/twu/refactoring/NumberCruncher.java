package com.twu.refactoring;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int count(String countType) {
        int count = 0;
        if (countType.equals("even")) {
            count = (int) Arrays.stream(numbers).filter(number -> number % 2 == 0).count();
        }
        if (countType.equals("odd")) {
            count = (int) Arrays.stream(numbers).filter(number -> number % 2 == 1).count();
        }
        if (countType.equals("positive")) {
            count = (int) Arrays.stream(numbers).filter(number -> number >= 0).count();
        }
        if (countType.equals("negative")) {
            count = (int) Arrays.stream(numbers).filter(number -> number < 0).count();
        }
        return count;
    }
}
