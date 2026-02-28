package ru.itis.inf503.lab2_3;

public enum TransportType {
    bus("Автобус"),
    tram("Трамвай"),
    trolleybus("Троллейбус");

    private String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
