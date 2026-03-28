package ru.itis.inf503.lab2_4.booking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public class MainBookingGroupBy {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        BookingsData data = mapper.readValue(
                new File("bookings.json"), BookingsData.class);

        //14. Вывести таблицу - город: список гостиниц, принимающих гостей из этого города

/*
        data.getBookings().stream()
                .filter(b -> b.getPerson().getFromcity() != null)
                .collect(Collectors.groupingBy(
                        b -> b.getHotel().getName()
                ))
                .forEach((k,v) -> {
                    System.out.println(k);
                    v.forEach(b-> System.out.print(
                            b.getPerson().getFromcity() + ", "
                    ));
                    System.out.println();
                });
*/

        data.getBookings().stream()
                .filter(b -> b.getPerson().getFromcity() != null)
                .collect(Collectors.groupingBy(
                        b -> b.getHotel().getName()
                ))
                .entrySet().stream()
                    .collect(Collectors.toMap(
                            e -> e.getKey(),
                            e -> e.getValue().stream()
                                    .map(b -> b.getPerson().getFromcity())
                                    .collect(Collectors.toSet())
                    ))
                .forEach((k,v) -> {
                    System.out.println(k);
                    v.forEach(b-> System.out.print(
                            b + ", "
                    ));
                    System.out.println();
                });

    }
}
