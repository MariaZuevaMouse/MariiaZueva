package com.marizueva.laboratory.hw3.voidpageobject.pages;

public enum ServicesSubCategories {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    SEARCH("SEARCH"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENT("DIFFERENT ELEMENT");

    public String serviceSubCategory;

    ServicesSubCategories(String serviceSubCategory) {
        this.serviceSubCategory = serviceSubCategory;
    }
}
