package ru.itis.inf503.lab2_12;

public class TaskWork implements Runnable {

    private Thread[] dependencies;
    private int workNumber;

    public TaskWork(int workNumber, Thread[] dependencies) {
        this.workNumber = workNumber;
        this.dependencies = dependencies;
    }

    @Override
    public void run() {
        // дождаться окончания выполнения задач от которых зависим
        try {
            if (dependencies != null) {
                for (Thread th : dependencies) {
                    th.join();
                }
            }
            work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void work() throws InterruptedException {
        System.out.println("Начата работа: " + workNumber);
        // Симулируем выполнение работы паузой в 1 сек
        Thread.sleep(1000);
        System.out.println("Завершена работа: " + workNumber);
    }
}
