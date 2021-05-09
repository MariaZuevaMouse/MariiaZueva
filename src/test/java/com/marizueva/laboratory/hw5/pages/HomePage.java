package com.marizueva.laboratory.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[href='#'] >.caret")
    protected WebElement openLoginDropdownButton;

    @FindBy(id = "name")
    protected WebElement loginField;

    @FindBy(id = "password")
    protected WebElement passwordField;

    @FindBy(xpath = "//ul/li[@class='dropdown uui-profile-menu open']"
            + "/descendant::span[text()='Enter']")
    protected WebElement enterCredentials;

    @FindBy(id = "user-name")
    WebElement loggedUserName;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CommonPage getCommonPageElements(){
        return new CommonPage(driver);
    }

    public void openSite() {
        driver.navigate().to(siteUrl);

    }
}
