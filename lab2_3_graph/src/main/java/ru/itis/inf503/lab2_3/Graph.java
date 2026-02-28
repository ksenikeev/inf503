package ru.itis.inf503.lab2_3;

import java.util.*;

public class Graph {
    private Map<Node, Set<Node>> graphMap;

    public Graph() {
        this.graphMap = new HashMap<>();
    }

    public void add(Node o, Node ... dependencies) {
        graphMap.put(o, new HashSet<>(List.of(dependencies)));
    }

    // ищем и возвращаем узлы у которых нет зависимостей
    public Set<Node> findEmpty(){
        Set<Node> result = new HashSet<>();
        for(Map.Entry<Node, Set<Node>> o : graphMap.entrySet()){
            if(o.getValue().isEmpty()){
                result.add(o.getKey());
            }
        }
        return result;
    }

    public void removeEmptyNodes(Set<Node> nodes){
        // удаляем узлы без зависимостей
        for(Node n : nodes){
            graphMap.remove(n);
        }

        // из зависимостей удаляем узлы без зависимостей
        for(Map.Entry<Node, Set<Node>> o : graphMap.entrySet()){
            o.getValue().removeAll(nodes);
        }
    }

    public boolean isEmpty() {
        // вызываем встроенный в Map метод isEmpty
        return graphMap.isEmpty();
    }
}
