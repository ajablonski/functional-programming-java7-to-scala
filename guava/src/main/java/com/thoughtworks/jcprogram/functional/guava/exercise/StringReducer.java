package com.thoughtworks.jcprogram.functional.guava.exercise;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;

// Given a list of strings like {"Bill", "Archer", "Lana"}
// Print the first letter of each of the string that have a length of 4.
// For example, "BL"

public class StringReducer {

    private static final Function<String, String> getFirstLetter = new Function<String, String>() {
        @Override
        public String apply(String input) {
            return Character.toString(input.charAt(0));
        }
    };
    private static final Predicate<String> lengthEqualToFour = new Predicate<String>() {
        @Override
        public boolean apply(String input) {
            return input.length() == 4;
        }
    };
    private static final Joiner joiner = Joiner.on("");

    public static void main(String[] args) {
        List<String> strings = newArrayList("Bill", "Archer", "Lana");

        System.out.println("------------ Guava: StringReducer ------------");
        System.out.println(new StringReducer().reduceToFirstLetterOfLengthFourStrings(strings));
    }

    public String reduceToFirstLetterOfLengthFourStrings(List<String> strings) {
        return joiner.join(
                transform(
                        filter(strings, lengthEqualToFour),
                        getFirstLetter));
    }
}
