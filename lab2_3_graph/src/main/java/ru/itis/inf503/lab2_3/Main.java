package ru.itis.inf503.lab2_3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // создать переменную результат типа List

        Graph graph = new Graph();
        graph.add(new Node("d"), new Node[0]);
        graph.add(new Node("a"), new Node("d"), new Node("c"));
        // ...

        while (!graph.isEmpty()) {
            Set<Node> epty = graph.findEmpty();
            graph.removeEmptyNodes(epty);
            // добавляем в результат узлы с пустыми зависимостями
        }

        // выводим результат с помощью итератора
    }
}
