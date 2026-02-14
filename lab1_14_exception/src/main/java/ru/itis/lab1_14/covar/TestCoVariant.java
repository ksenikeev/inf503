package ru.itis.lab1_14.covar;

public class TestCoVariant {
    public static void main(String[] args) {
        Student s = new Student("Name1", "Group1");

        Person p = s;

        System.out.println((Student)p);

        Person[] persons = new Student[] {new Student("Name1", "Group1"), new Student("Name2", "Group2")};
        for (Student person : (Student[])persons) {
            System.out.println(person);
        }

        Student[] students = new Student[] {new Student("Name1", "Group1"), new Student("Name2", "Group2")};
        Person[] persons2 =(Person[])students;

        for (Person person : persons2) {
            System.out.println(person);
        }

    }
}
