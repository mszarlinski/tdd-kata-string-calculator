package com.github.mszarlinski.tddkata

import spock.lang.Specification

/**
 * @author mszarlinski@bravurasolutions.com on 2017-02-03.
 */
class StringCalculatorSpec extends Specification {

    StringCalculator calc = new StringCalculator()

    def "Should take number and return it"() {
        given:
            String numbers = "3"
        when:
            int sum = calc.add(numbers)
        then:
            sum == 3

    }
}
