package ru.itis.inf503.lab2_4.set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class SetTest {
    public static void main(String[] args) {
        Set503gen<Integer> set = new Set503GenImpl<>();
        set.add(3);
        set.add(4);
        set.add(1);
        set.add(2);
        List<String> list = set.collect(new Function<Integer, String>() {
            public String apply(Integer a) {
                return String.valueOf(a);
            }
        });
        List<Integer> list1 = set.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        list1.forEach(new Consumer<Integer>() {
            public void accept(Integer s) {
                System.out.println(s);
            }
        });
    }
}
