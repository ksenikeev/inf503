package ru.itis.inf503.lab2_3;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TransportService service = new TransportService();

        List<Transport> transports = service.readAll();

        for (Transport t : transports) {
            System.out.println(t);
        }
    }
}
