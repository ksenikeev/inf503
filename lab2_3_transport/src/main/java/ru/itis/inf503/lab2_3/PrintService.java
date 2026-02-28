package ru.itis.inf503.lab2_3;

import java.util.Comparator;
import java.util.List;

public class PrintService {

    class CompareByNumber implements Comparator<Transport> {
        @Override
        public int compare(Transport o1, Transport o2) {
            return o1.getNumber().compareTo(o2.getNumber());
        }
    }

    public void printSortedByNumber(List<Transport> transports) {
        transports.sort(new CompareByNumber());
        for (Transport transport : transports) {
            System.out.println(transport.getNumber() + " " + transport.getWorkTimeBegin());
        }
    }

    public void printSortedByRouteNumber(List<Transport> transports) {
        transports.sort(new Comparator<Transport>() {
            public int compare(Transport o1, Transport o2) {
                return o1.getRouteNumber().compareTo(o2.getRouteNumber());
            }
        });
        for (Transport transport : transports) {
            System.out.println(transport.getRouteNumber() + " "
                + transport.getWorkTimeBegin() + " - " + transport.getWorkTimeEnd());
        }
    }
}
