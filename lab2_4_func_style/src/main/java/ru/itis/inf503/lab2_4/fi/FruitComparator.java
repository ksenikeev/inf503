package ru.itis.inf503.lab2_4.fi;

import java.util.Comparator;

/**
 * Задача этого класса предоставить метод
 * сравнения двух фруктов
 */
public class FruitComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit a, Fruit b) {
        return a.getPrice() - b.getPrice();
    }
}
