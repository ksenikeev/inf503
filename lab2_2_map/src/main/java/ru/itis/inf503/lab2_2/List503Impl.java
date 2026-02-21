package ru.itis.inf503.lab2_2;

public class List503Impl<T> implements List503<T> {

    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }


    private Node first;
    private Node last;


    public List503Impl() {
        first = null;
    }

    public List503Impl(T first) {
        this.first = new Node(first);
        this.last = this.first;
    }


    public void add(T elem) {
        if (first == null) {
            first = last = new Node(elem);
        } else {
            last.next = new Node(elem);
            last = last.next;
        }
    }

    public void add(T elem, int position) {
        if (position == 0) {
            Node newNode = new Node(elem);
            newNode.next = first;
            first = newNode;
            if (last == null) {
                last = newNode;
            }
            return;
        }

        Node temp = first;
        for(int i = 0; i < position-1; i++) {
            if (temp.next == null) throw new IndexOutOfBoundsException();
            temp = temp.next;
        }

        Node newNode = new Node(elem);
        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) {
            last = newNode;
        }
    }

    public int size() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T o) {
        return false;
    }

    public T get(int position) throws IndexOutOfBoundsException {
        Node temp = first;
        for(int i = 0; i < position; i++) {
            if (temp == null) throw new IndexOutOfBoundsException();
            temp = temp.next;
        }
        if (temp == null) throw new IndexOutOfBoundsException();
        return temp.value;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public T remove(int position) {
        if (position == 0) {
            T value = first.value;
            first = first.next;
            if (first == null) last = null;
            return value;
        }

        Node temp = first;
        for(int i = 0; i < position - 1; i++) {
            if (temp.next == null) throw new IndexOutOfBoundsException();
            temp = temp.next;
        }
        T value = temp.next.value;
        temp.next = temp.next.next;

        if (temp.next == null) last = temp;
        return value;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = first;
        while(temp != null) {
            stringBuilder.append(temp.value).append(" ");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }
}

