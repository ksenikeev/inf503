package ru.itis.inf503.lab2_12.task20260518;

// Управляющий класс
public class ConsolInputTask extends Thread {

    // управляемый класс
    private final RandomGeneratorTask randomGeneratorTask;

    public ConsolInputTask(RandomGeneratorTask randomGeneratorTask) {
        this.randomGeneratorTask = new RandomGeneratorTask();
    }

    public void run() {
        //Scanner ....
    }

}
