package ru.itis.inf503.lab2_4.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestStream {
    public static void main(String[] args) {
        // 1. Преобразовать список строк - отобрать строки, начинающиеся на "Вл",
        //и вывести среднюю длину таких строк

        List<String> task1 = new ArrayList<>(List.of(
                "Владимир", "Суздаль", "Владивосток"));

        Double result1  = task1.stream()
                // Фильтруем, интерфейс Predicate
                .filter(s -> s.startsWith("Вл"))
                // преобразуем в стрим из чисел (длины строк), интерфейс Function
                // Владимир -> 8, ....
                .map(s -> s.length())
                // Для доступа к функции Среднее преобразуем
                // стрим из чисел в целочисленный стрим (отдельный тип)
                .mapToInt(a -> a)
                // вычисляем среднее и извлекаем значение из Optional
                .average().getAsDouble();
        System.out.println(result1);


//        2. Список целых чисел отсортировать по убыванию, преобразовать
//        в список действительных чисел из корней исходных чисел

        List<Integer> task2 = new ArrayList<>(List.of(11,32,22,46,76));
        task2.stream()
                .sorted((o1, o2) -> o2-o1)
                .map(s -> Math.sqrt(s))
                .forEach(s-> System.out.println(s));

        //5 Список строк отфильтровать по длине, оставив только длиной 5,отсортировать полученный результат.
            List<String> task3 = new ArrayList<>(List.of("Арбуз", "Яблоко", "Помидор", "Собак"));
            task3.stream()
                    .filter(s -> s.length() == 5)
                    .sorted((a,b) -> a.compareTo(b))
                    .toList().forEach(s -> System.out.println(s));

            //4. Список действительных чисел отсортировать по последнему разряду и вывести в консоль.
        List<Integer> task4 = new ArrayList<>(List.of(11,32,22,46,76));
        task4.stream()
                .sorted((a, b) -> a % 10 - b % 10)
                .forEach(s -> System.out.println(s));

    }
}
