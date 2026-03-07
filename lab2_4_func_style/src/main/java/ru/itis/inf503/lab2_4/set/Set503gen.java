package ru.itis.inf503.lab2_4.set;

import java.util.*;
import java.util.function.*;

public interface Set503gen<T> {
    int size();
    boolean isEmpty();
    void add(T o);
    boolean contains(T o);
    void remove(T o);
    void clear();
    Object[] toArray();
    <R>List<R> collect(Function<T, R> function);
}

/*

def <T> sum(T a,T b):
    return a + b

<Integer> sum(3, "5")

 */