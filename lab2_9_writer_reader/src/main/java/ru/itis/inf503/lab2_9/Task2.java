package ru.itis.inf503.lab2_9;
/*2. Прочитать текст из файла с помощью FileReader, если слово начинается
с буквы А и заканчивается буквой Н, то перевести его в верхний регистр,
результат записать с помощью FileWriter в новый файл
   (использовать метод mark(30) и reset())
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader("transport.csv"));
            FileWriter fw = new FileWriter("task2out.txt")){
            boolean start = true;
            boolean inword = false;
            int cnt = 0;
            while(true){
                char c = (char)br.read();
                if(start && (c =='A' || c == 'a')){
                    br.mark(30);
                    start = false;
                    inword = true;
                    cnt++;
                } else if (start){
                    start = false;
                    fw.write(c);
                } else if(inword && (c == 'н' || c == 'Н' )){
                    br.reset();
                    char[] a = new char[cnt];
                    br.read(a);
                    fw.write(new String(a).toUpperCase());
                    cnt = 0;
                    inword = false;
                } else if(inword){
                    cnt ++;
                } else if( c == ' '){
                    start = true;
                    inword = false;
                    fw.write(c);
                } else{
                    fw.write(c);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
