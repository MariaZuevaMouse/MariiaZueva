package com.marizueva.laboratory.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[href='#'] >.caret")
    private WebElement openLoginDropdownButton;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//ul/li[@class='dropdown uui-profile-menu open']"
            + "/descendant::span[text()='Enter']")
    private WebElement enterCredentials;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CommonPage getCommonPageElements() {
        return new CommonPage(driver);
    }

    public void openSite() {
        driver.navigate().to(siteUrl);
    }

    public void performLogin(String user, String password) {
        openLoginDropdownButton.click();
        loginField.sendKeys(user);
        passwordField.sendKeys(password);
        enterCredentials.click();
    }
}
