package com.marizueva.laboratory.hw3.fluentpageobject.pages;

public enum HeaderItems {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METAL_AND_COLORS("METALS & COLORS");


    public String requestedTab;

    HeaderItems(String requestedTab) {
        this.requestedTab = requestedTab;
    }
}
