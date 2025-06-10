package net.salesianos.activities.four.models;

import java.io.Serializable;

public class Table implements Serializable {
    private String color;
    private int legAmount;

    public Table(String color, int legAmount) {
        this.color = color;
        this.legAmount = legAmount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLegAmount() {
        return legAmount;
    }

    public void setLegAmount(int legAmount) {
        this.legAmount = legAmount;
    }

    @Override
    public String toString() {
        return "\n----------- TABLE -----------\nColor: " + color + "\nLeg Amount: " + legAmount
                + "\n-----------------------------";
    }

}
