package ru.itis.inf503.lab2_3;

public class Trolleybus extends Transport {
    public Trolleybus(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(TransportType.trolleybus, number, routeNumber, workTimeBegin, workTimeEnd);
    }
}
