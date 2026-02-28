package ru.itis.inf503.lab2_3;

public class Tram extends Transport {
    public Tram(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        super(TransportType.tram, number, routeNumber, workTimeBegin, workTimeEnd);
    }
}
