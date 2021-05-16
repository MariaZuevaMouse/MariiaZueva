package com.marizueva.laboratory.hw4.voidpageobject.pages;

public enum Checkboxes {
    WATER(1, "Water"),
    EARTH(2, "Earth"),
    WIND(3, "Wind"),
    FIRE(4, "Fire");

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
