package com.rschoen.spocktesting

import spock.lang.Specification

class MathSpec extends Specification{
    def "max of two numbers"(int a, int b, int c) {
        expect:
        Math.max(a,b) == c

        where:
        a | b | c
        1 | 3 | 3
        2 | 4 | 4
        9 | 9 | 9
    }
}
