package ru.itis.inf503.lab2_11.sync;

public class MainSum {

    public static double sum = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread task1 = new Thread(new TaskSumm());
        Thread task2 = new Thread(new TaskSumm());
        Thread task3 = new Thread(new TaskSumm());
        Thread task4 = new Thread(new TaskSumm());

        task1.start();
        task2.start();
        task3.start();
        task4.start();


        task1.join();// в этом месте поток main останавливается до
                    // до завершения task1
        task2.join();
        task3.join();
        task4.join();

        System.out.println("Сумма = " + sum);
    }

    public synchronized static void add(double innerSum) {
        sum += innerSum;
    }
}
