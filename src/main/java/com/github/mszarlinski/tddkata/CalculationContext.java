package com.github.mszarlinski.tddkata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mszarlinski on 2017-02-03.
 */
class CalculationContext {

    private final String delimeterRegexp;

    private final String numbers;

    CalculationContext(String numbers, String delimeterRegexp) {
        this.delimeterRegexp = delimeterRegexp;
        this.numbers = numbers;
    }

    String delimeterRegexp() {
        return delimeterRegexp;
    }

    static CalculationContextBuilder from(String input) {
        return new CalculationContextBuilder(input);
    }

    String numbers() {
        return numbers;
    }

    static class CalculationContextBuilder {

        private static final String DEFAULT_DELIMETER_REGEXP = "[,\n]";

        private static final Pattern CUSTOM_DELIMETER_PATTERN = Pattern.compile("//(.*)\n(.*)");

        private final String input;

        CalculationContextBuilder(final String input) {
            this.input = input;
        }

        CalculationContext build() {
            if (input.startsWith("//")) {
                final Matcher matcher = CUSTOM_DELIMETER_PATTERN.matcher(input);
                if (matcher.find()) {
                    return new CalculationContext(matcher.group(2), matcher.group(1));
                } else {
                    throw new IllegalArgumentException("Unsupported input: " + input);
                }
            } else {
                return new CalculationContext(input, DEFAULT_DELIMETER_REGEXP);
            }
        }
    }
}
