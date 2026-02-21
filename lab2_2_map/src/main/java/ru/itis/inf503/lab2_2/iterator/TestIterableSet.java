package ru.itis.inf503.lab2_2.iterator;

public class TestIterableSet {
    public static void main(String[] args) {
        Set503GenImpl<Fruit> set = new Set503GenImpl<>();

        set.add(new Fruit("Яблоко 1"));
        set.add(new Fruit("Яблоко 2"));
        set.add(new Fruit("Яблоко 3"));

        for(Fruit f : set) {
            System.out.println(f);
        }
    }
}
