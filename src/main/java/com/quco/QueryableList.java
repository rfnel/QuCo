package com.quco;

import java.util.List;

public interface QueryableList<T> extends List<T> {

    QueryableList<T> selectWhere(Predicate<T> predicate);
    QueryableList<T> transform(Transform<T> transform);
    QueryableList<T> distinct();
    QueryableList<T> sort();

    T aggregate(Aggregate<T> aggregate);
}
