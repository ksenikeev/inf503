package ru.itis.inf503.lab2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportService {
    private static final String FILE_NAME = "transport.csv";
    public List<Transport> readAll() {
        List<Transport> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                Transport transport = switch(data[0]){
                    case "bus" -> new Bus (data[1], data[2], data[3], data[4]);
                    case "tram" -> new Tram (data[1], data[2], data[3], data[4]);
                    case "trolleybus" -> new Trolleybus (data[1], data[2], data[3], data[4]);
                    default -> null;
                };
                if (transport == null)
                    throw new IllegalArgumentException("Неизвестный тип транспорта: " + data[0]);
                result.add(transport);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
