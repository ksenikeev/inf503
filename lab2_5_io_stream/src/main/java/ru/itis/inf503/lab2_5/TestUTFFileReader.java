package ru.itis.inf503.lab2_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestUTFFileReader {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("bookings.json");

            int r;
            while ((r = is.read()) != -1) {
                if ((r & 128) == 0) {
                    // символ состоит из 1 байта
                    System.out.print((char) r);
                } else if ((r & 192) == 192) {
                    // символ состоит из 2 байт
                    // читаем 2-й байт
                    int r2 = is.read();
                    int c = (r << 8) | r2;
                    System.out.print(c);
                }
            }

            System.out.println(r);

            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
