package ru.itis.inf503.lab2_11;

public class Task implements Runnable {

    private String message;

    public Task(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < message.length(); ++i) {
            System.out.print(message.charAt(i));
        }
        System.out.println();
    }
}
