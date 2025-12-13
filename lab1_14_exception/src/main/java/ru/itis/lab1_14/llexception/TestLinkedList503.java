package ru.itis.lab1_14.llexception;

public class TestLinkedList503 {
    public static void main(String[] args) {
        LinkedList503 list = new LinkedList503();

        list.add(1);
        list.add(5);
        list.add(0);
        list.add(17);
        list.add(-3);
        list.add(8);

        try {
            System.out.println(list.get(13));
            System.out.println("aaaaa");
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();

            System.out.println("Вы указали неверный индекс, повторите ввод!");
        } catch (NoNoNo13Exception e) {
            System.err.println("Только не 13!!!!");
            System.exit(13);
        }

        System.out.println("продолжаем работу");
    }
}
