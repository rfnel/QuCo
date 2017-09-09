package com.quco;

public interface Predicate<T> {

    boolean matches(T item);
}
