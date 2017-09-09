package com.quco.com.quco.aggregates;

import com.quco.Aggregate;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IntegerAggregatesTest {

    @Test
    public void testSum() throws Exception {
        Aggregate<Integer> sum = IntegerAggregates.sum();

        List<Integer> numbers = Arrays.asList(1, 2, 3);

        assertThat("Sum of numbers should be 6.", sum.aggregate(numbers), is(equalTo(6)));
    }
}