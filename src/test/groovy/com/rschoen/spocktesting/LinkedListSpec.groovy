package com.rschoen.spocktesting

import spock.lang.Specification

class EmptyListSpec extends Specification {
    def list = new LinkedList()

    def "size"() {
        expect: list.size() == 0
    }
    def "pop"() {
        when: list.pop()
        then: thrown(NoSuchElementException)
    }
    def "add"() {
        when: list.add("element")
        then: list.size() == 1
    }
}


