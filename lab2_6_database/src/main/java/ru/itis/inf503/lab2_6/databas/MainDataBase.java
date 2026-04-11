package ru.itis.inf503.lab2_6.databas;

import java.util.Date;

public class MainDataBase {
    public static void main(String[] args) {
        try {
            Many many1 = new Many(1, (byte)-1, "Автобус", new Date(),46f,  "");
            DataBaseUtils dataBaseUtils = new DataBaseUtils();

            dataBaseUtils.save(many1);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
