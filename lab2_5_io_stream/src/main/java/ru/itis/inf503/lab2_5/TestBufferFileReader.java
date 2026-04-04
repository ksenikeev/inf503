package ru.itis.inf503.lab2_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestBufferFileReader {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("bookings.json");

            byte[] buffer = new byte[1024];
            // количество прочитанных байт
            int r;
            while ((r = is.read(buffer)) != -1) {
                // строим строку из массива, указываем какую его часть надо взять [0,r)
                String str = new String(buffer,0,r,"UTF-8");
                System.out.print(str);
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
