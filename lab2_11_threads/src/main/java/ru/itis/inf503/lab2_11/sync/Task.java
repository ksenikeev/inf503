package ru.itis.inf503.lab2_11.sync;

public class Task implements Runnable {

    private String message;
    private Object mutex;

    public Task(String message, Object mutex) {
        this.mutex = mutex;
        this.message = message;
    }

    @Override
    public void run() {
        print();
    }

    // TODO необходимо обеспечить монопольный доступ к консоли на время выполнения функции
    // private synchronized void print() {... = synchronized(this) { ...

    private void print() {

        // Какие-то вычисления
        //synchronized (mutex) {
        synchronized (Task.class) {
            // этим блоком сможет управлять только один поток
            // захватываем mutex
            for (int i = 0; i < message.length(); ++i) {
                System.out.print(message.charAt(i));
            }
            System.out.println();
            // освобождаем mutex
        }
    }
}
