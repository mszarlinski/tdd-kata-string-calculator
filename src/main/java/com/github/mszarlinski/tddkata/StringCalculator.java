package com.github.mszarlinski.tddkata;

import static java.util.Arrays.stream;

/**
 * @author mszarlinski on 2017-02-03.
 */
public class StringCalculator {

    public int add(final String numbers) {
        final String[] ints = numbers.split(",");

        return stream(ints)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
