package ru.itis.inf503.lab2_9;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * 1. Используя PrintWriter и ByteArrayOutputStream сформировать
 * массив байт, содержащий текст из нескольких строчек.
 * Получить массив и записать его в файл в кодировке cp1251
 */
public class Task1 {
    public static void main(String[] args) {
        String text = " * 1. Используя PrintWriter и ByteArrayOutputStream сформировать\n" +
                " * массив байт, содержащий текст из нескольких строчек.\n" +
                " * Получить массив и записать его в файл в кодировке cp1251\n";
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                PrintWriter pw = new PrintWriter(bos, true, Charset.forName("cp1251"));
             FileOutputStream fos = new FileOutputStream("task1.txt")) {
            pw.write(text);
            pw.flush();
            byte[] array = bos.toByteArray();
            System.out.println(array.length);

            fos.write(array);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
