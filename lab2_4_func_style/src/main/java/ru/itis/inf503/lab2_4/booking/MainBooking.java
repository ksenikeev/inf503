package ru.itis.inf503.lab2_4.booking;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainBooking {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        BookingsData data = mapper.readValue(
                new File("bookings.json"), BookingsData.class);

        //data.getBookings().forEach(b -> System.out.println(b));

        // 1. Вывести кол-во мужчин/женщин, бронирующих в гостинице с id=150

        long countF = data.getBookings().stream()
                .filter(b -> b.getHotel().getId() == 150)
                .filter(p -> p.getPerson().getGender().equals("Female"))
                .count();

        long countM = data.getBookings().stream()
                .filter(b -> b.getHotel().getId() == 150)
                .filter(p -> p.getPerson().getGender().equals("Male"))
                .count();

        System.out.println(countF);
        System.out.println(countM);
        //2. Вывести список населенных пунктов в отсортированном виде,
        // из которых прибыли гости

        data.getBookings().stream()
                .map(b -> b.getPerson().getFromcity())
                .distinct()
                .sorted((a,b) -> a.compareTo(b))
                .forEach(s -> System.out.println(s));

        // 3. Вывести количество бронирований за декабрь 2021 года
        long countBofDecember = data.getBookings().stream()
                .filter(b -> b.getArrivaldate().startsWith("2021-12"))
                .count();
        System.out.println(countBofDecember);

        //4. Вывести таблицу: название гостиницы - кол-во бронирований
        data.getBookings().stream()
                .collect(Collectors.toMap(b -> b.getHotel().getName(),
                        b -> 1, (v1, v2) -> v1 + v2))
                .forEach((k, v) -> System.out.println(k + " " + v));

        // 5. Вывести таблицу: название населенного пункта - кол-во бронирований
        data.getBookings().stream()
                .collect(Collectors.toMap(
                        b -> b.getPerson().getFromcity(),
                        b -> 1,
                        (v1, v2) -> v1 + v2))
                .forEach((k, v) -> System.out.println(k + " " + v));

        //Вывести кол-во бронирований людей из Петербурга

        long countPiter = data.getBookings().stream()
                .filter(b -> b.getPerson().getFromcity().equals("Город Санкт-Петербург"))
                .count();
        System.out.println(countPiter);

        // 7. Найти гостиницу с максимальным числом броней за январь 2023 года

        Hotel h = data.getBookings().stream()
                .filter(b -> b.getArrivaldate().startsWith("2022-01"))
                .collect(Collectors.toMap(
                        b -> b.getHotel(),
                        b -> 1,
                        (v1, v2) -> v1+v2)
                ).entrySet().stream()
                .max((e1, e2) -> e1.getValue()-e2.getValue())
                .get().getKey();
        System.out.println(h);

        //8. Вывести список городов из которых прибыли мужчины от 35 до 45 лет (смотрим только год рождения)
        data.getBookings().stream()
                .filter(b -> b.getPerson().getGender() != null)
            .filter(b -> b.getPerson().getGender().equals("Male"))
            .filter(b -> {
                if (b.getPerson().getBirthdate() == null) return false;
                int age =
                    Integer.parseInt(b.getPerson().getBirthdate().substring(0, 4));
              return age >= 1977 && age <= 1987;
            })
            .map(b -> b.getPerson().getFromcity())
            .distinct()
            //.forEach(s -> System.out.println(s));
            .forEach(System.out::println);

        //вывести список гостиниц (названия) в которых проживали дети до 14 лет
        data.getBookings().stream()
                .filter(b -> b.getPerson().getBirthdate() != null)
                .filter(b->{
                    int birthYaers=Integer.parseInt(b.getPerson().getBirthdate().substring(0,4));
                    int arrivalYears=Integer.parseInt(b.getArrivaldate().substring(0,4));
                    return arrivalYears-birthYaers <= 14;
                })
                .map(b->b.getHotel().getName())
                .distinct()
                .forEach(System.out::println);

        // 10. вывести список людей с количеством бронирований больше 3
        data.getBookings().stream()
                .filter(b -> b.getPerson().getGender() != null)
                .filter(b -> b.getPerson().getBirthdate() != null)
                .collect(Collectors.toMap(
                        b -> b.getPerson(),
                        b -> 1,
                        (v1, v2) -> v1+v2)
                ).entrySet().stream()
                .filter(e -> e.getValue() > 3)
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
        // 11. Вывести гостиницы в которых проживали женщины из Санкт-Петербурга
        // в период с февраля по март 2022 года (использовать несколько фильтров)
        data.getBookings().stream()
                .filter(b -> b.getPerson().getGender() != null)
                .filter(b -> b.getPerson().getGender().equals("Female"))
                .filter(b -> b.getArrivaldate().startsWith("2022-02")
                || b.getArrivaldate().startsWith("2022-03"))
                .map(b -> b.getHotel().getName())
                .distinct()
                .forEach(System.out::println);

    }






}
