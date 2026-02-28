package ru.itis.inf503.lab2_3;

public class Bus extends Transport {
    public Bus(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
    super(TransportType.bus, number, routeNumber, workTimeBegin, workTimeEnd);
    }

    @Override
    public String toString() {
        return "Автобус: " + number + ", Маршрут " +
                routeNumber + ", Начало работы: " +
                workTimeBegin + ", Конец работы: " +
                workTimeEnd;
    }
}
