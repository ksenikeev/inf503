package ru.itis.inf503.lab2_4.booking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public class MainBooking12 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        BookingsData data = mapper.readValue(
                new File("bookings.json"), BookingsData.class);

        data.getBookings().stream()
                .filter(b -> b.getPerson().getBirthdate() != null)
                .collect(Collectors.toMap(
                        b -> b.getPerson().getGroup(),
                        b -> 1,
                        (v1, v2) -> v1 + v2))
                .forEach((k,v) -> System.out.println(k + ":" + v));
    }
}
