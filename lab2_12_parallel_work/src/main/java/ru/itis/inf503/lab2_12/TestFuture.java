package ru.itis.inf503.lab2_12;

import java.util.concurrent.*;

class TestFuture{

    public static void main(String[] args) {

        System.out.println("Main thread started...");

        int number = 5;  // исходное число для вычисления факториала

        // определяем задачу, которая вычисляет факториал
        Callable<Integer> task = () -> {

            int n = number;     // копируем число, чтобы не изменять его
            int result = 1;
            while(n > 0) result *= n--;
            return result;  // возвращаем результат задачи
        };

        // CompletableFuture<Integer> future = CompletableFuture.supplyAsync(task);
        // определяем задачу, которая будет выполнена в будущем
        FutureTask<Integer> futureTask = new FutureTask(task);
        // создаем и запускаем поток
        Thread t = new Thread(futureTask); // futureTask - это объект Runnable
        t.start();

        // здесь могут быть какие-либо другие операции метода main
        // которые должны выполняться одновременно с futureTask
        System.out.println("Main thread works...");

        try {
            // ожидаем выполнения задачи
            Integer factorial = futureTask.get();
            System.out.printf("factorial of %d is %d\n", number, factorial);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Main thread finished...");
    }
}