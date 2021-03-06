package com.marizueva.laboratory.hw4.voidpageobject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPageElements extends BasePage {

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

    @FindBy(css = "ul.uui-navigation a[href='index.html']")
    WebElement headerItemHome;

    @FindBy(css = "ul.uui-navigation a[href='contacts.html']")
    WebElement headerItemContact;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle")
    WebElement headerItemService;

    @FindBy(css = "ul.uui-navigation a[href='metals-colors.html']")
    WebElement headerItemMetalAndColor;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']")
    WebElement leftSection;

    @FindBy(xpath = "//header//ul/li/a[@class='dropdown-toggle']"
                + "/following-sibling::ul[@class='dropdown-menu']"
                + "/li/a[@href='different-elements.html']")
    WebElement subMenuFromHeaderDifferentElementsItem;


    public CommonPageElements(WebDriver driver) {
        super(driver);

    }

    @Step
    public WebElement getLeftSection() {
        return leftSection;
    }

    @Step
    public void clickServiceItemFromHeader() {
        headerItemService.click();

    }

    @Step
    public ServiceDifferentElementPage goToDifferentElementPageFromHeader() {
        clickServiceItemFromHeader();
        subMenuFromHeaderDifferentElementsItem.click();
        return new ServiceDifferentElementPage(driver);
    }

    @Step
    public boolean isLeftSectionDisplayed() {
        return leftSection.isDisplayed();
    }
}
