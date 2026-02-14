package ru.itis.inf503.lab2_1;

public interface Set503 {
    int size();
    boolean isEmpty();
    void add(Object o);
    boolean contains(Object o);
    void remove(Object o);
    void clear();
    Object[] toArray();
}