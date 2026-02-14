package ru.itis.lab1_14.covar;

public class Student extends Person {
    private String group;

    public Student(String name, String group) {
        super(name);
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student[" + getName() + ", " + group + ']';
    }
}
