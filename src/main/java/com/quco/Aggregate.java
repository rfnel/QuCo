package com.quco;

import java.util.List;

public interface Aggregate<T> {

    T aggregate(List<T> items);
}
