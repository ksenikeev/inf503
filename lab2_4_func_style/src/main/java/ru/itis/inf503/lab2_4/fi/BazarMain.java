package ru.itis.inf503.lab2_4.fi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BazarMain {
    public static void main(String[] args) {
        Bazar bazar = new Bazar();
        List<Fruit> fruits = bazar.generateProductions(new FruitGenerator(), 10);

        fruits.forEach(new Consumer<Fruit>() {
            public void accept(Fruit fruit) {
                System.out.println(fruit.getName() + " : " + fruit.getPrice());
            }
        });
    }

    static class FruitGenerator implements Supplier<Fruit> {

        private Map<String, List<String>> names = new HashMap<>();

        public FruitGenerator() {
            names.put("Яблоко", List.of("Садовые", "Голд", "Гала", "Грени"));
            names.put("Груша", List.of("Конференция", "Бергамот", "Дюшес", "Чудесница"));
            names.put("Мандарины", List.of("Абхазия", "Марокко", "Японский"));
        }

        /*
            1. Выбрать случайный фрукт из множества названий как ключи Map
            2. Для выбранного фрукта получить список сортов sorts = names.get(name)
            3. Из списка сортов выбрать случайный
            4. Случайным образом сформировать цену
            5. По полученным данным создать фрукт new Fruit(...)
         */
        public Fruit get() {

            Random random = new Random();
            // случайный индекс для имени фрукта
            int index = random.nextInt(names.size());
            String name = (String)names.keySet().toArray()[index];
            // Запрашиваем список сортов
            List<String> sorts = names.get(name);
            // случайный индекс для названия сорта
            int indexSort = random.nextInt(sorts.size());
            // names.get(name) - извлекаем значение из Map по ключу name - список сортов
            String sort = sorts.get(indexSort);

            int price = random.nextInt(500);

            return new Fruit(name + " - " + sort, price);
        }
    }
}
