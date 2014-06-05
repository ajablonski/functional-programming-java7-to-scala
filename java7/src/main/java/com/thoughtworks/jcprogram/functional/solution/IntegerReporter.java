package com.thoughtworks.jcprogram.functional.solution;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

// Given a list of numbers like {1, 9, 4, 16, 4}
// Print the square root of all of the numbers larger than 4.
// For example, "3, 4"

public class IntegerReporter {
    public static void main(String[] args) {
        List<Integer> numbers = asList(1, 9, 4, 16, 4);

        System.out.println(new IntegerReporter().reportSquareRootsOfLargeNumbers(numbers));

    }

    public String reportSquareRootsOfLargeNumbers(List<Integer> numbers) {
        return join(asStrings(squareRoots(numbersGreaterThanFour(numbers))), ", ");
    }

    private static List<String> asStrings(List<Integer> numbers) {
        List<String> strings = new ArrayList<String>();
        for (Integer number : numbers){
            strings.add(number.toString());
        }
        return strings;
    }

    private static List<Integer> squareRoots(List<Integer> numbers) {
        List<Integer> squareRoots = new ArrayList<Integer>();
        for (Integer number : numbers){
            Double squareRoot = Math.sqrt(number.floatValue());
            squareRoots.add(squareRoot.intValue());
        }
        return squareRoots;
    }

    private static List<Integer> numbersGreaterThanFour(List<Integer> numbers) {
        List<Integer> numbersGreaterThanFour = new ArrayList<Integer>();
        for (Integer number : numbers){
            if (number > 4){
                numbersGreaterThanFour.add(number);
            }
        }
        return numbersGreaterThanFour;
    }

    private static String join(List<String> items, String delimiter) {
        String result = "";
        if (!items.isEmpty()){
            result = items.get(0);
            List<String> itemsRemainingToAdd = items.subList(1, items.size());
            for (String item : itemsRemainingToAdd){
                result += delimiter + item;
            }
        }
        return result;
    }

}