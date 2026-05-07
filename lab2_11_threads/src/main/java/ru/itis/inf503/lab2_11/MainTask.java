package ru.itis.inf503.lab2_11;

public class MainTask {
    public static void main(String[] args) throws InterruptedException {

        // Оценим возможности нашей вычислительной системы
        int countProc = Runtime.getRuntime().availableProcessors();
        System.out.println("Кол-во виртуальных ядер: " + countProc);

        // Создадим несколько экземпляров задач
        TaskThread task1 = new TaskThread("Сообщение для потока 1");
        TaskThread task2 = new TaskThread("Сообщение для потока 2");
        TaskThread task3 = new TaskThread("Сообщение для потока 3");

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

        System.out.println("Все задачи выполнены");

    }
}
