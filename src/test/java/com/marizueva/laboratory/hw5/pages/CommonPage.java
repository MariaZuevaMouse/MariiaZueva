package com.marizueva.laboratory.hw5.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends BasePage{
    public CommonPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle")
    WebElement headerItemService;

    @FindBy(linkText = "Different elements")
    WebElement subMenuFromHeaderDifferentElementsItem;

    public void clickOnServiceFromHeader(){
        headerItemService.click();
    }

    public void goToSubMenuFromHeader(String category) {
        if(category.equals("Different Elements")) {
            subMenuFromHeaderDifferentElementsItem.click();
        } else {
            throw new NotFoundException("no such element" + category);
        }

    }
}
