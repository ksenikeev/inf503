package ru.itis.inf503.lab1_12;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Node node = new Node(0);
        System.out.println(node.toString());
    }

}
