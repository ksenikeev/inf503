package ru.itis.inf503.lab2_8;

import ru.itis.inf503.lab2_8.annotations.DefaultValue;
import ru.itis.inf503.lab2_8.annotations.GameState;
import ru.itis.inf503.lab2_8.annotations.ToString;

import java.io.Serializable;

@GameState
public class Game implements Serializable {
    private Double xPosition = 0.;
    private Double yPosition = null;
    private Integer level = 0;

    private Integer power = 100;
    @DefaultValue(value="Gamer 2")
    public String gamerName;
/*
    {
        "xPosition":0,
        "yPosition":0,
        "gamerName":"... "
    }
*/
    public Game() {
    }

    public Game(String gamerName) {
        this.gamerName = gamerName;
    }

    public Game(Double xPosition, Double yPosition, Integer level, Integer power) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.level = level;
        this.power = power;
    }

    public Double getXPosition() {
        return xPosition;
    }

    public void setXPosition(Double xPosition) {
        this.xPosition = xPosition;
    }

    public Double getYPosition() {
        return yPosition;
    }

    public void setYPosition(Double yPosition) {
        this.yPosition = yPosition;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getPower() {
        return power/100.;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    private Double getRadiusVector() {
        return Math.sqrt(xPosition * xPosition + yPosition * yPosition);
    }

    @Override
    @ToString
    public String toString() {
        return "";
    }
}
