package com.quco.com.quco.aggregates;

import com.quco.Aggregate;

public class IntegerAggregates {

    public static Aggregate<Integer> sum() {
        return items -> {
            int sum = 0;

            for (Integer value : items) {
                sum += value;
            }

            return sum;
        };
    }
}
