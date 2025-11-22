package ru.itis.inf503.game;

import java.util.Random;

public class Ant extends Animal {
    public Ant(String name) {
        // вызов конструктора предка
        super(name);
    }

    @Override
    public void move() {
        Random random = new Random();
        // получаем псевдослучайное число от 0 .. 3
        int direction = random.nextInt(4);
        // 0 - назад, 1 - вправо, 2 - вперед, 3 - влево
        switch (direction) {
            case 0: if (y > 0) y--; break;
            case 1: if (x < Game.WIDTH) x++; break;
            case 2: if (y < Game.HEIGHT) y++; break;
            case 3: if (x > 0) x--; break;
        }

    }
}
