package ru.itis.inf503.lab2_4.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Преобразование списка объектов в Map
 */
public class TestToMap {

    static class Fruit {
        String name;
        Integer price;

        public Fruit(String name, Integer price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        List<Fruit> fruits =
                new ArrayList<>(List.of(
                    new Fruit("Яблоко", 100),
                    new Fruit("Банан", 140),
                    new Fruit("Груша", 180),
                    new Fruit("Яблоко", 120)
                ));
        // List<Fruit> -> Map<name, price>

        Map<String, Integer> result = fruits.stream()
                // Описываем две функции: как формировать ключ, как формировать значение
                // можно описать еще 3-ю функцию, разрешающую коллизии
                .collect(Collectors.toMap(
                        f -> f.name, f -> f.price, (v1, v2) -> (v1 + v2) / 2 ));

        result.entrySet()
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }
}
