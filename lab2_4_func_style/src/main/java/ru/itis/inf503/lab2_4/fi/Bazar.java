package ru.itis.inf503.lab2_4.fi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Bazar {

    public List<Fruit> generateProductions(Supplier<Fruit> generator, int count) {
        List<Fruit> result = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            result.add(generator.get());
        }
        return result;
    }

}
