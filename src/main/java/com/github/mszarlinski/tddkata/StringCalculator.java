package com.github.mszarlinski.tddkata;

import static java.util.Arrays.stream;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mszarlinski on 2017-02-03.
 */
public class StringCalculator {

    private static final String DEFAULT_DELIMETER_REGEXP = "[,\n]";

    private static final Pattern CUSTOM_DELIMETER_PATTERN = Pattern.compile("//(.*)\n(.*)");

    public int add(final String input) {
        if ("".equals(input)) {
            return 0;
        }

        String delimeterRegexp, numbers;
        if (input.startsWith("//")) {
            final Matcher matcher = CUSTOM_DELIMETER_PATTERN.matcher(input);
            if (matcher.find()) {
                delimeterRegexp = matcher.group(1);
                numbers = matcher.group(2);
            } else {
                throw new IllegalArgumentException("Unsupported input: " + input);
            }
        } else {
            numbers = input;
            delimeterRegexp = DEFAULT_DELIMETER_REGEXP;
        }

        final String[] ints = numbers.split(delimeterRegexp);

        return stream(ints)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
