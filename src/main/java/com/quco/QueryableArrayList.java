package com.quco;

import java.util.*;

public class QueryableArrayList<T> extends ArrayList<T> implements QueryableList<T> {

    public static <T> QueryableArrayList<T> fromList(List<T> sourceList) {
        QueryableArrayList<T> queryableArrayList = new QueryableArrayList<>();
        queryableArrayList.addAll(sourceList);

        return queryableArrayList;
    }

    @Override
    public QueryableList<T> selectWhere(Predicate<T> predicate) {
        QueryableArrayList<T> returnList = new QueryableArrayList<>();

        for (T item : this) {
            if (predicate.matches(item)) {
                returnList.add(item);
            }
        }

        return returnList;
    }

    @Override
    public QueryableList<T> transform(Transform<T> transform) {
        QueryableArrayList<T> returnList = new QueryableArrayList<>();

        for (T item : this) {
            returnList.add(transform.transform(item));
        }

        return returnList;
    }

    @Override
    public QueryableList<T> distinct() {
        Set<T> uniqueItems = new HashSet<>();
        uniqueItems.addAll(this);

        QueryableArrayList<T> returnList = new QueryableArrayList<>();
        returnList.addAll(uniqueItems);

        return returnList;
    }

    @Override
    public QueryableList<T> sort() {
        QueryableArrayList<Comparable> returnList = new QueryableArrayList<>();
        returnList.addAll((List<Comparable>)this);

        Collections.sort(returnList);

        return (QueryableList<T>)returnList;
    }

    @Override
    public T aggregate(Aggregate<T> aggregate) {
        return aggregate.aggregate(this);
    }
}
