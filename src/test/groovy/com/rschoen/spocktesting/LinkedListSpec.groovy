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


class ThreeItemListSpec extends Specification {
    def list = new LinkedList()

    def setup() {
        ["Third","Second","First"].each { list.push(it) }
    }

    def "size"() {
        expect: list.size() == 3
    }

    def "listIterator index out of bounds"() {
        when: list.listIterator(list.size() + 1)
        then: thrown(IndexOutOfBoundsException)
    }
    def "pop"() {
        expect:
        list.pop() == "First"
        list.pop() == "Second"
        list.pop() == "Third"
        list.size() == 0
    }
    def "peek"() {
        expect:
        list.peek() == "First"
        list.peek() == "First"
        list.peekFirst() == "First"
        list.peekLast() == "Third"
        list.size() == 3
    }
    def "push"() {
        when:
        list.push("Zeroeth")

        then:
        list.size() == 4
        list.peek() == "Zeroeth"
    }
}
class MultipleItemListSpec extends Specification {
    def list = new LinkedList()

    def setup() {
        ["Six", "Five","Four","Four","Three","Two","One"].each { list.push(it)}
    }
    def "size"() {
        expect: list.size() == 7
    }
    def "indexOf"() {
        expect:
        list.lastIndexOf("Four") == 4
    }
    def "removeFirstOccurrence"() {
        when:
        list.removeFirstOccurrence("Four")
        then:
        list.indexOf("Four") == 3
        list.size() == 6
    }
    def "add"() {
        when:
        list.add(3,"AAAAA")
        then:
        list.indexOf("AAAAA") == 3
        list.size() == 8
    }
    def "add OutOfBounds"() {
        when: list.add(8,'Invlid index')
        then: thrown(IndexOutOfBoundsException)
    }
    def "poll"() {
        when:
        list.poll()
        list.poll()
        list.poll()
        then:
        list.size() == 4
        list.peekFirst() == "Four"
    }
}

