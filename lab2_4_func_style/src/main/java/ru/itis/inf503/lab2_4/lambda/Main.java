package ru.itis.inf503.lab2_4.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

//    Описать класс Student (name, group, birthDate), создать метод work,
//    принимающий в качестве
//    аргумента экземпляр на базе функционального интерфейса StudentWork с методом
//    doWork(String student, String workName), в методе work вызвать doWork
//    Протестировать, используя лямбда выражение


    interface StudentWork {
        void doWork(String student, String workName) ;
    }

    public static class Student {
        String name;
        int group;
        String birthDate;

        public Student(String name, int group, String birthDate) {
            this.name = name;
            this.group = group;
            this.birthDate = birthDate;
        }

        public void work (StudentWork studentWork) {
            studentWork.doWork(name, "Решить уравнение");
        }
    }


    public class Person {
        public String name;
        public int height;
    }
    public static void main(String[] args){

        //Написать лямбда выражение описывающее фильтр по строкам (остаются,
        //    начинающиеся с "Муз")
        Predicate<String> task1 = s -> s.startsWith("Муз");
//        Написать лямбда выражение описывающее функцию преобразования числа
//        в его строковое представление (библиотека+)
        Function<Integer, String> task2 = n -> String.valueOf(n);
        //Написать лямбда выражение описывающее сравнение двух человек по росту
        Comparator<Person> task3 = (a, b) -> a.height - b.height;
        //Написать лямбда выражение описывающее вывод на консоль имени человека
        Consumer<Person> task4 = p -> System.out.println(p.name);

        //Создать список из целых чисел, используя лямбда выражение отсортировать по убыванию
        List<Integer> task5 = new ArrayList<>(List.of(143,3,53,5,32,16,464,46));
        task5.sort((a,b) -> b - a);
        //Создать список из целых чисел, используя лямбда выражение  и метод replaceAll
        //преобразовать список заменив элементы их остатком от деления на 16
        task5.replaceAll(n -> n % 16);
        System.out.println(task5);


        Student student = new Student("Kanan", 503, "30.12.2006");
        student.work((a,b) -> System.out.println(a + " " + b));
    }
}
