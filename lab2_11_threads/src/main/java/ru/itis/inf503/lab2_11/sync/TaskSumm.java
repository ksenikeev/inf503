package ru.itis.inf503.lab2_11.sync;

/**
 * В параллельных потоках произвести вычисления
 * затем все полученные результаты суммировать
 */
public class TaskSumm implements Runnable {

    @Override
    public void run() {
        double sum = 0;
        int n = 1;

        for (double i = 1; i < 1_000_000; ++i) {
            sum += i/n;
            n *= i;

        }
        MainSum.add(sum);
        System.out.println(Thread.currentThread().threadId() + " : " + sum);



    }
}
