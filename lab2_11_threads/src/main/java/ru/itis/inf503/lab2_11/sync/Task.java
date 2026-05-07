package ru.itis.inf503.lab2_11.sync;

import java.io.IOException;
import java.io.Writer;

public class Task implements Runnable {

    private String message;
    private Object mutex;
    private Writer writer;

    public Task(String message, Object mutex, Writer writer) {
        this.mutex = mutex;
        this.message = message;
        this.writer = writer;
    }

    @Override
    public void run() {
        try {
            filePrint();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    private void filePrint() throws IOException {

        synchronized (mutex) {
            //synchronized (Task.class) {
            // этим блоком сможет управлять только один поток
            // захватываем mutex
            for (int i = 0; i < message.length(); ++i) {
                writer.write(message.charAt(i));
            }
            writer.write('\n');
            // освобождаем mutex
        }

    }
}