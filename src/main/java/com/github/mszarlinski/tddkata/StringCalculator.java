package com.github.mszarlinski.tddkata;

import static java.util.Arrays.stream;

/**
 * @author mszarlinski on 2017-02-03.
 */
public class StringCalculator {

    private static final String SEPARATOR_REGEXP = "[,\n]";

    public int add(final String numbers) {
        if ("".equals(numbers)) {
            return 0;
        }

        final String[] ints = numbers.split(SEPARATOR_REGEXP);

        return stream(ints)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
