package ru.itis.inf503.lab2_13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainTaskTimer {


    public static void main(String[] args) throws ParseException {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Задача выполнена успешно!");
            }
        };

        Timer timer = new Timer();
        System.out.println("Планируем выполнение");
        //timer.schedule(task, 3000);

        Date time = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
                .parse("14.05.2026 16:13:50");
        timer.schedule(task, time);
        //timer.cancel();
    }
}
