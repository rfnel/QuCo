package com.quco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class QueryableArrayListTest {

    private Iterable<Integer> numbers;

    @Before
    public void setUp(){
        this.numbers = getTestNumbers();
    }

    @Test
    public void testTransform() {
        QueryableList<Integer> numbers = getTestNumbers();

        QueryableList<Integer> transformedNumbers = numbers.transform(x -> x *= 2);

        assertThat("Transformed list should contain 12 items.", transformedNumbers.size(), is(equalTo(12)));
        assertThat("Transformed list should contain all initial numbers multiplied by 2.", transformedNumbers, hasItems(2, 4, 6, 8, 10, 12, 14, 16, 18, 20));
    }

    @Test
    public void testSelectWhere() {
        QueryableList<Integer> numbers = getTestNumbers();

        QueryableList<Integer> transformedNumbers = numbers.selectWhere(x -> x % 2 == 0);

        assertThat("Transformed list should contain 5 items.", transformedNumbers.size(), is(equalTo(5)));
        assertThat("Transformed list should contain only even numbers.", transformedNumbers, hasItems(2, 4, 6, 8, 10));
    }

    @Test
    public void testAggregate() {
        QueryableList<Integer> numbers = getTestNumbers();

        int result = numbers.aggregate(x -> {
            int sum = 0;

            for (int number : x) {
                sum += number;
            }

            return sum;
        });

        assertThat("Sum of numbers should be 65", result, is(equalTo(65)));
    }

    @Test
    public void testDistinct() {
        QueryableList<Integer> numbers = getTestNumbers();

        QueryableList<Integer> distinctNumbers = numbers.distinct();

        assertThat("Distinct list should contain 10 items.", distinctNumbers.size(), is(equalTo(10)));
    }

    @Test
    public void testSort() {
        QueryableList<Integer> numbers = getTestNumbers();

        QueryableList<Integer> sortedNumbers = numbers.sort();

        assertThat("Sorted list should contain 1 in position 0.", sortedNumbers.get(0), is(equalTo(1)));
        assertThat("Sorted list should contain 4 in position 4.", sortedNumbers.get(4), is(equalTo(4)));
        assertThat("Sorted list should contain 10 in position 11.", sortedNumbers.get(11), is(equalTo(10)));
    }

    @After
    public void tearDown() {
        assertThat("Source list should not be modified.", numbers, hasItems(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10));
    }

    private QueryableList<Integer> getTestNumbers(){
        List<Integer> sourceList = Arrays.asList(4, 5, 6, 7, 1, 1, 2, 3, 8, 9, 9, 10);
        return QueryableArrayList.fromList(sourceList);
    }

}