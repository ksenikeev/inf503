package ru.itis.inf503.lab2_8;

import ru.itis.inf503.lab2_8.annotations.DefaultValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ProcessGame {
    public static void main(String[] args) throws Exception {
        ProcessGame processGame = new ProcessGame();

        // 1. Создадим экземпляр Game через рефлексию
        Game game = (Game)processGame.makeObject(Game.class);
        System.out.println(game.getGamerName());
    }

    public Object makeObject(Class clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object result = null;

        Constructor constructor = clazz.getConstructor(/* можно указать типы аргументов конструктора */);
        result = constructor.newInstance(/* Здесь могут быть аргументы конструктора */);

        // Пробуем найти аннотацию DefaltValue, чтобы проинициализировать член класса
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(DefaultValue.class)) {
                field.setAccessible(true);
                DefaultValue annotation = field.getAnnotation(DefaultValue.class);
                field.set(result, annotation.value());
            }
        }

        return result;
    }
}
