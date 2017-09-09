package com.quco.com.quco.predicates;

import com.quco.Predicate;

public class IntegerPredicates {

    public static Predicate<Integer> isDivisibleBy(int by) {
        return x -> x % by == 0;
    }
}
