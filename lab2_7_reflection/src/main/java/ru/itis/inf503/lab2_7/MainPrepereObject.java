package ru.itis.inf503.lab2_7;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainPrepereObject {
    public static void main(String[] args) throws IllegalAccessException {

        Game game = new Game("Gamer");

        // 1. Определим к какому типу относится объект
        System.out.println("1. -------------------------------------");
        System.out.println(game.getClass());
        Class clazz = game.getClass();
        System.out.println(clazz.equals(Game.class));

        // 2. Публичные члены класса
        System.out.println("2. -------------------------------------");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 3. Все члены класса
        System.out.println("3. -------------------------------------");
        Field[] allFields = clazz.getDeclaredFields();
        for (Field field : allFields) {
            field.setAccessible(true);
            System.out.println(field.getType() + " : " + field.getName()
                    + " = " + field.get(game) );
        }

        // 4. Предки
        System.out.println("4. -------------------------------------");
        System.out.println(clazz.getSuperclass());

        // 5. Реализуемые интерфейсы
        System.out.println("5. -------------------------------------");
        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        // 6. Публичные методы
        System.out.println("6. -------------------------------------");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        // 7. Все методы
        System.out.println("7. -------------------------------------");
        Method[] allMethods = clazz.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println(method);
        }

    }
}
