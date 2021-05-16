package com.marizueva.laboratory.hw5.pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends BasePage {
    public CommonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle")
    WebElement headerItemService;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    WebElement subMenuFromHeaderDifferentElementsItem;

    @FindBy(linkText = "USER TABLE")
    WebElement subMenuFromHeaderUserTableItem;

    public void clickOnServiceFromHeader() {
        headerItemService.click();
    }

    public void goToServiceSubMenuFromHeader(String category) {
        if ("Different Elements".equals(category)) {
            subMenuFromHeaderDifferentElementsItem.click();
        } else if ("User Table".equals(category)) {
            subMenuFromHeaderUserTableItem.click();
        } else {
            throw new NotFoundException("no such element: " + category);
        }

    }
}
