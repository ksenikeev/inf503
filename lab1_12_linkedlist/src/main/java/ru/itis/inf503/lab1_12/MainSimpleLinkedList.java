package ru.itis.inf503.lab1_12;

public class MainSimpleLinkedList {
    public static void main(String[] args) {
        // создание связного списка
        Node node0 = new Node(4);
        Node node1 = new Node(1);
        Node node2 = new Node(0);
        Node node3 = new Node(12);
        Node node4 = new Node(8);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        // перебор всех элементо, начиная с 0-го
        // переменную head бережем, если ее значение потеряется-
        // утрачивается доступ к связному списку
        Node head = node0;
        // Введем переменную цикла обхода current, начинаем с головы
        Node current = head;

        while (current != null) {
            //System.out.println(current.value);
            current = current.next;
        }

        // добавление в хвост (конец списка)
        // сначала найти конец
        current = head;
        while (current.next != null) {
            current = current.next;
        }
        //System.out.println(current.value);

        Node last = new Node(13);
        current.next = last;

        // проверим как добавилось
        current = head;
        while (current != null) {
            //System.out.println(current.value);
            current = current.next;
        }

        // удаляем последний элемент
        current = head;
        // в цикде доходим до предпоследнего
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;

        current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }

        // удаляем элемент на позиции n = 2
        int n = 2;
        current = head;
        for (int i = 0; i < n - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        current = head;
        while (current != null) {
            //System.out.println(current.value);
            current = current.next;
        }

        Node first = new Node(-1);
        first.next = head;
        head = first;

        // Вставить элемент в позицию n
        n = 2;
        Node newNode = new Node(-1);
        current = head;
        for (int i = 0; i < n - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;

        current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }


}
