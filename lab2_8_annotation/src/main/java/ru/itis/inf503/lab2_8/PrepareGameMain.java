package ru.itis.inf503.lab2_8;

import ru.itis.inf503.lab2_8.annotations.DefaultValue;
import ru.itis.inf503.lab2_8.annotations.GameState;
import ru.itis.inf503.lab2_8.annotations.ToString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrepareGameMain {
    public static void main(String[] args) {
        Class clazz = Game.class;

        // 1. Исследуем аннотации над классом
        System.out.println("1. Исследуем аннотации над классом");
        Annotation[] classAnnotations = clazz.getAnnotations();
        for (Annotation a : classAnnotations) {
            System.out.println(a);
        }
        if (clazz.isAnnotationPresent(GameState.class)) {
            System.out.println("обнаружили наличие аннотации GameState");
        }

        // 2. Исследуем аннотации над методами
        System.out.println("2. Исследуем аннотации над методами");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getAnnotations();
            if (methodAnnotations.length > 0) {
                System.out.println(method);
                for (Annotation a : methodAnnotations) {
                    System.out.println(a);
                }

                System.out.println(method.isAnnotationPresent(ToString.class));
            }
        }

        // 3. Исследуем аннотации над членами класса
        System.out.println("3. Исследуем аннотации над членами класса");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] fieldAnnotations = field.getAnnotations();
            if (fieldAnnotations.length > 0) {
                System.out.println(field);
                for (Annotation a : fieldAnnotations) {
                    System.out.println(a);
                    if (a instanceof DefaultValue) //a.equals(DefaultValue.class)
                        System.out.println(((DefaultValue)a).value());
                }
                System.out.println(field.isAnnotationPresent(DefaultValue.class));
            }
        }
    }
}
