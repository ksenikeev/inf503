package ru.itis.inf503.game;

import java.util.Random;

public class Game {

    public final static int WIDTH = 1000;
    public final static int HEIGHT = 1000;

    public final static int SQ_X = 400;
    public final static int SQ_Y = 400;

    public final static int SQ_WIDTH = 200;
    public final static int SQ_HEIGHT = 200;

    public void run() {
        Random random = new Random();
        int position = random.nextInt(1, WIDTH);
        Ant ant = new Ant("муравьишка");
        ant.setStartPosition(position, 0);

        for (int i = 0; i < 100; ++i) {
            ant.move();
            System.out.println("x=" + ant.getX() + ", y=" + ant.getY());
        }
    }
}
