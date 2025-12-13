package ru.itis.lab1_14.treeexception;

public interface IntCollection {

    void add(int value);

    int size();

    String[] path(int value) throws NotFoundException;

    int max() throws EmptyTreeException;

    int min() throws EmptyTreeException;
}
