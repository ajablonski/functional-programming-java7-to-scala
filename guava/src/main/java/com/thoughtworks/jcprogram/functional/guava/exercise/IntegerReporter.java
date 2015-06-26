package com.thoughtworks.jcprogram.functional.guava.exercise;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;

// Given a list of numbers like {1, 9, 4, 16, 4}
// Print the square root of all of the numbers larger than 4.
// For example, "3, 4"

public class IntegerReporter {

    private static final Function<Integer, String> getSquareRoot = new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return Long.toString(Math.round(Math.sqrt(input)));
        }
    };
    private static final Predicate<Integer> largerThanFour = new Predicate<Integer>() {
        @Override
        public boolean apply(Integer input) {
            return input > 4;
        }
    };
    private final Joiner joiner = Joiner.on(", ");

    public static void main(String[] args) {
        List<Integer> numbers = newArrayList(1, 9, 4, 16, 4);

        System.out.println("------------ Guava: IntegerReporter ------------");
        System.out.println(new IntegerReporter().reportSquareRootsOfLargeNumbers(numbers));
    }

    public String reportSquareRootsOfLargeNumbers(List<Integer> numbers) {
        return joiner.join(
                transform(
                        filter(numbers, largerThanFour),
                        getSquareRoot));
    }


}
