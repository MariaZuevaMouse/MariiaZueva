package com.marizueva.laboratory.hw5.pages;

import com.marizueva.laboratory.hw5.utils.TestDataProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public abstract class BasePage {
    WebDriver driver;
    static Properties testDataProps = null;
    protected static final String siteUrl = "https://jdi-testing.github.io/jdi-light/index.html ";

    static {
        testDataProps  = TestDataProperties.getTestDataProps();
    }

    protected static final String defaultUser  =  testDataProps.getProperty("username");
    protected static final String defaultPassword = testDataProps.getProperty("password");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
