package com.marizueva.laboratory.hw4.voidpageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    protected static final String siteUrl = "https://jdi-testing.github.io/jdi-light/index.html ";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
