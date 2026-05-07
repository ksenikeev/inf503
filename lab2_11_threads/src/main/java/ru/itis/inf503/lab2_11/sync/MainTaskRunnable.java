package ru.itis.inf503.lab2_11.sync;

import java.io.FileWriter;
import java.io.IOException;

public class MainTaskRunnable {
    public static void main(String[] args) throws InterruptedException {

        // Оценим возможности нашей вычислительной системы
        int countProc = Runtime.getRuntime().availableProcessors();
        System.out.println("Кол-во виртуальных ядер: " + countProc);

        Object mutex = new Object();

        try (FileWriter writer = new FileWriter("message.txt")) {

            // Создадим несколько экземпляров задач
            Thread task1 = new Thread(new Task("Сообщение для потока 1", mutex, writer));
            Thread task2 = new Thread(new Task("Сообщение для потока 2", mutex, writer));
            Thread task3 = new Thread(new Task("Сообщение для потока 3", mutex, writer));

            // запуск задач в параллельных потоках start()! неявный вызов run()
            task1.start();
            task2.start();
            task3.start();
            // следующа строка начнет выполняться сразу после старта
            // не дожидаясь окончания работы
            System.out.println("Запустили 3 параллельные задачи");

            // Ожидаем завершения задачи 1
            task1.join();
            // Ожидаем завершения задачи 2
            task2.join();
            // Ожидаем завершения задачи 3
            task3.join();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Все задачи выполнены");

    }
}
