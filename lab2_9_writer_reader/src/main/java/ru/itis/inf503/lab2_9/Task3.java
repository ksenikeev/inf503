package ru.itis.inf503.lab2_9;

import java.io.*;
import java.nio.charset.Charset;

//3. Строку преобразовать в массив байт, на базе этого массива
// создать ByteArrayInputStream,
//на базе этого объекта сформировать InputStreamReader,
// в цикле считать и распечатать все символы

public class Task3 {
    public static void main(String[] args) {
        String text = " * 1. Используя PrintWriter и ByteArrayOutputStream сформировать\n" +
                " * массив байт, содержащий текст из нескольких строчек.\n" +
                " * Получить массив и записать его в файл в кодировке cp1251\n";
        try (ByteArrayInputStream bos = new ByteArrayInputStream(text.getBytes());
             InputStreamReader reader = new InputStreamReader(bos)) {
            int r = 0;
            while ((r = reader.read()) != -1) {
                System.out.print((char) r);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
