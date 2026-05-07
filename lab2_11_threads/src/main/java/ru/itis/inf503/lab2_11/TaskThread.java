package ru.itis.inf503.lab2_11;

/**
 * Создание класса, предназначенного для выполнения
 * в отдельном потоке
 */
public class TaskThread extends Thread {

    private String message;

    public TaskThread(String message) {
        super();
        this.message = message;
    }

    /* Метод, запускаемый в отдельном потоке */
    @Override
    public void run() {
        for (int i = 0; i < message.length(); ++i) {
            System.out.print(message.charAt(i));
        }
        System.out.println();
    }

}
