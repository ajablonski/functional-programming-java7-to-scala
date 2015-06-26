package com.thoughtworks.jcprogram.functional.exercise;

import java.util.List;

import static java.util.Arrays.asList;

// Given a list of numbers like {1, 9, 4, 16, 4}
// Print the square root of all of the numbers larger than 4.
// For example, "3, 4"

public class IntegerReporter {
    public static void main(String[] args) {
        List<Integer> numbers = asList(1, 9, 4, 16, 4);

        System.out.println("------------ Java 7: IntegerReporter ------------");
        System.out.println(new IntegerReporter().reportSquareRootsOfLargeNumbers(numbers));

    }

    public String reportSquareRootsOfLargeNumbers(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            if (number > 4) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(Math.round(Math.sqrt(number)));
            }
        }
        return stringBuilder.toString();
    }

}
