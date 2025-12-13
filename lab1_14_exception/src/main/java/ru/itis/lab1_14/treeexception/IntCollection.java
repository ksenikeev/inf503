package ru.itis.lab1_14.treeexception;

public interface IntCollection {

    void add(int value);

    int size();

    String[] path(int value);

    int max();

    int min();
}
