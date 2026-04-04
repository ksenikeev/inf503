package ru.itis.inf503.lab2_5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestFileWriter {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("test.txt");

            String message = "Привет!";
            byte[] data = message.getBytes("UTF-8");

            os.write(data);

            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
