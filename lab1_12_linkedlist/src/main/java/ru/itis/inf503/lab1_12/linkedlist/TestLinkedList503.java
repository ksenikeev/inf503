package ru.itis.inf503.lab1_12.linkedlist;

public class TestLinkedList503 {
    public static void main(String[] args) {
        LinkedList503 list = new LinkedList503();

        list.add(1);
        list.add(5);
        list.add(0);
        list.add(17);
        list.add(-3);
        list.add(8);

        System.out.println("размер списка = " + list.size());
        System.out.println(list);
        list.sort();
        System.out.println(list);
    }
}
