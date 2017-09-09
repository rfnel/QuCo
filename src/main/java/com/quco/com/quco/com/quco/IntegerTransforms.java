package com.quco.com.quco.com.quco;

import com.quco.Transform;

public class IntegerTransforms {

    public static Transform<Integer> multiplyBy(int by) {
        return x -> x * by;
    }
}
