package com.marizueva.laboratory.hw5.pages;

public enum Checkboxes {
    WATER(0, "Water"),
    EARTH(1, "Earth"),
    WIND(2, "Wind"),
    FIRE(3, "Fire");

    private int index;
    private String checkboxName;

    Checkboxes(int index, String checkboxName) {
        this.index = index;
        this.checkboxName = checkboxName;
    }

    public int getIndex() {
        return index;
    }

    public String getCheckboxName() {
        return checkboxName;
    }
}
