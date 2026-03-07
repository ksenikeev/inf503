package ru.itis.inf503.lab2_4.fi;

import java.util.function.Consumer;

public class FruitPrinter implements Consumer<Fruit> {

    @Override
    public void accept(Fruit fruit) {
        System.out.println(fruit.getName() + " : " + fruit.getPrice());
    }
}
