package ru.itis.inf503.lab2_7;

import java.io.Serializable;

public class Game implements Serializable {
    private Double xPosition;
    private Double yPosition;
    private Integer level;
    private Integer power;
    public String gamerName;

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

    public Double getxPosition() {
        return xPosition;
    }

    public void setxPosition(Double xPosition) {
        this.xPosition = xPosition;
    }

    public Double getyPosition() {
        return yPosition;
    }

    public void setyPosition(Double yPosition) {
        this.yPosition = yPosition;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPower() {
        return power;
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

    @Override
    public String toString() {
        return "Game{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", level=" + level +
                ", power=" + power +
                '}';
    }
}
