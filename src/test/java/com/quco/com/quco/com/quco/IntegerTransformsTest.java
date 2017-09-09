package com.quco.com.quco.com.quco;

import com.quco.Transform;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IntegerTransformsTest {

    @Test
    public void testMultiplyByTwo() {
        Transform<Integer> multiplyByTwo = IntegerTransforms.multiplyBy(2);

        assertThat("5 multiplied by 2 is 10.", multiplyByTwo.transform(5), is(equalTo(10)));
        assertThat("12 multiplied by 2 is 24.", multiplyByTwo.transform(12), is(equalTo(24)));
    }

    @Test
    public void testMultiplyByThree() {
        Transform<Integer> multiplyByTwo = IntegerTransforms.multiplyBy(3);

        assertThat("5 multiplied by 3 is 15.", multiplyByTwo.transform(5), is(equalTo(15)));
        assertThat("12 multiplied by 3 is 36.", multiplyByTwo.transform(12), is(equalTo(36)));
    }
}