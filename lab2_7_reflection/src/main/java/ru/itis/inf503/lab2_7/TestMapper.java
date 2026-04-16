package ru.itis.inf503.lab2_7;

public class TestMapper {
    public static void main(String[] args) {
        Game game = new Game("Gamer");

        JSONMapper mapper = new JSONMapper();

        System.out.println(mapper.writeObject(game));
    }
}
