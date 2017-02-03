package com.github.mszarlinski.tddkata;

import static java.util.Arrays.stream;

/**
 * @author mszarlinski on 2017-02-03.
 */
public class StringCalculator {

    public int add(final String input) {
        if ("".equals(input)) {
            return 0;
        }

        CalculationContext ctx = CalculationContext.from(input).build();

        final String[] ints = ctx.numbers().split(ctx.delimeterRegexp());

        return stream(ints)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
