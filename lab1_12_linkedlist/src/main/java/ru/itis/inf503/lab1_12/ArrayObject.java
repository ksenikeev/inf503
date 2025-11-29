package ru.itis.inf503.lab1_12;

public class ArrayObject {
    public static void main(String[] args) {
        Object[] array = new Object[3];
        array[0] = "hello";
        array[1] = new Data(1);
        array[2] = null;

        for (Object o : array) {
            System.out.println(o);
        }
    }

    private static class Data {
        public int value;

        public Data(int value) {
            this.value = value;
        }

        public String toString() {
            return "Data: " + value;
        }
    }
}
