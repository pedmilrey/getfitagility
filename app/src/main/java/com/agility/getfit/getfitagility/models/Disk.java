package com.agility.getfit.getfitagility.models;

/**
 * Created by pedro.millan on 03/09/2017.
 */

public class Disk {

    private String color;
    private int number;

    public Disk(String color, int number) {
        this.color = color;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
