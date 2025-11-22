package ru.itis.inf503.game;

public class Animal {
    public String name;
    protected int x;
    protected int y;

    public Animal(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
    }

    public void setStartPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {

    }

    // префикс get имя члена класса с заглавной буквы
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
