package ru.itis.inf503.lab2_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestFileReader {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("bookings.json");

            int r;
            while ((r = is.read()) != -1) {
                System.out.print((char) r);
            }

            System.out.println( r);

            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
