package com.github.mszarlinski.tddkata

import spock.lang.Specification

/**
 * @author mszarlinski on 2017-02-03.
 */
class StringCalculatorSpec extends Specification {

    StringCalculator calc = new StringCalculator()

    def "Should take number and return it as int"() {
        given:
            String numbers = "3"
        when:
            int sum = calc.add(numbers)
        then:
            sum == 3
    }

    def "Should take 2 numbers and return their sum"() {
        given:
            String numbers = "10,19"
        when:
            int sum = calc.add(numbers)
        then:
            sum == 29
    }

    def "Should return 0 for empty string"() {
        given:
            String numbers = ""
        when:
            int sum = calc.add(numbers)
        then:
            sum == 0
    }

    def "Should handle unknown number of numbers"() {
        when:
            int sum = calc.add(numbers)
        then:
            sum == expected
        where:
            numbers               || expected
            "1,2,3"               || 6
            "1,2,3,4,5"           || 15
            "1,2,3,4,5,6,7,8,9,0" || 45
    }
}
