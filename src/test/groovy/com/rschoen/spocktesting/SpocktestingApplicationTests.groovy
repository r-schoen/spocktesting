package com.rschoen.spocktesting

import spock.lang.Specification

class SpocktestingApplicationSpec extends Specification {
    def "Basic Math"() {
        expect: 2+2 == 4
    }
}
