package ru.itis.inf503.lab2_4.set;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class SetTest {
    public static void main(String[] args) {
        Set503gen<Integer> set = new Set503GenImpl<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        List<String> list = set.collect(new Function<Integer, String>() {
            public String apply(Integer a) {
                return String.valueOf(a);
            }
        });

        list.forEach(new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
