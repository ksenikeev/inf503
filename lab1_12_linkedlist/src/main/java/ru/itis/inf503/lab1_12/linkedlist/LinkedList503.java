package ru.itis.inf503.lab1_12.linkedlist;

public class LinkedList503 {

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public int get(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void add(int number) {
        if (this.size == 0) {
            Node newnode = new Node(number);
            this.head = newnode;
            this.tail = newnode;
        } else {
            Node secondTail = tail;
            tail = new Node(number);
            secondTail.next = tail;
        }
        size++;
    }

     public void add(int value, int index) {
        if (index == size) {
            add(value);
            return;
        }
        Node newNode = new Node(value);
        Node current = head;
        for (int i = 0; i < index - 1; ++i)
            current = current.next;

        newNode.next = current.next;
        current.next = newNode;
        size++;
     }

     public int pop() {

        if (this.size == 1) {
            int value = this.head.value;
            this.head = null;
            size--;
            return value;
        }

        Node current = head;
        for (int i = 0; i < size - 1; ++i)
         current = current.next;

        int result = current.next.value;

         tail = current;
         current.next = null;
        size--;
        return result;
     }

    public int remove(int index) {
        return -1;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            Node previus = head;
            Node current = head;
            Node next = head.next;
            for (int j = 0; j < size - 1 - i; i++) {
                if (compare(current, next) > 0) {
                    swap(previus, current, next);
                    if (current == head) head = next;
                    previus = next;
                    next = current.next;
                } else {
                    previus = current;
                    current = next;
                    next = next.next;
                }
            }
        }
    }
    private int compare(Node a, Node b) {
        return a.value - b.value;
    }

    public void swap(Node p, Node c, Node n) {
        p.next = n;
        c.next = n.next;
        n.next = c;
    }

    public String toString() {
        String result = "[";
        Node current = head;
        for (int i = 0; i < size - 1; ++i) {
            result += current.value + ", ";
            current = current.next;
        }
        result += current.value + "]";
        return result;
    }
}
