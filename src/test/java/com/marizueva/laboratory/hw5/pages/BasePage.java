package com.marizueva.laboratory.hw5.pages;

import com.marizueva.laboratory.hw5.utils.TestDataProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public abstract class BasePage {
    WebDriver driver;

    protected static final String siteUrl = "https://jdi-testing.github.io/jdi-light/index.html ";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
