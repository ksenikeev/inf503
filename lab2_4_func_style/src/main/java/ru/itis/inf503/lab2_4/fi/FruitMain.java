package ru.itis.inf503.lab2_4.fi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class FruitMain {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.addAll(List.of(
                new Fruit("Яблоко", 120),
                new Fruit("Виноград", 240),
                new Fruit("Банан", 160),
                new Fruit("Апельсин", 140),
                new Fruit("Груша", 180)
        ));

        //fruits.sort(new FruitComparator());
        //fruits.forEach(new FruitPrinter());

        // Создаем анонимный экземпляр (new) анонимного класса, реализующего интерфейс
        fruits.sort(new Comparator<Fruit>() {
            public int compare(Fruit o1, Fruit o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });

        fruits.forEach(new Consumer<Fruit>() {
            public void accept(Fruit fruit) {
                System.out.println(fruit.getName() + " : " + fruit.getPrice());
            }
        });


        fruits.forEach(f -> System.out.println(f.getName() + " : " + f.getPrice()));
    }
}
