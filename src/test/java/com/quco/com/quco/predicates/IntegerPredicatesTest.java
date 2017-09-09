package com.quco.com.quco.predicates;

import com.quco.Predicate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IntegerPredicatesTest {

    @Test
    public void testIsDivisibleByTwo() {
        Predicate<Integer> divisibleByTwo = IntegerPredicates.isDivisibleBy(2);

        assertThat("5 is not divisible by 2.", divisibleByTwo.matches(5), is(equalTo(false)));
        assertThat("12 is divisible by 2.", divisibleByTwo.matches(12), is(equalTo(true)));

    }

    @Test
    public void testIsDivisibleByThree() {
        Predicate<Integer> divisibleByThree = IntegerPredicates.isDivisibleBy(3);

        assertThat("5 is not divisible by 3.", divisibleByThree.matches(5), is(equalTo(false)));
        assertThat("12 is divisible by 3.", divisibleByThree.matches(12), is(equalTo(true)));
    }

}