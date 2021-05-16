package com.marizueva.laboratory.hw4.voidpageobject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPageElements {

    @FindBy(css = ".icons-benefit")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitText;

    @FindBy(xpath = "//div[@class='main-content']/h3[@class='main-title text-center']")
    WebElement mainContentHeader;

    @FindBy(xpath = "//div[@class='main-content']/p")
    WebElement mainContentText;

    @FindBy(xpath = "//iframe[@id='jdi-frame-site']")
    WebElement iframeCenter;

    @FindBy(xpath = "//img[@src='images/Logo_Epam_Color.svg']")
    WebElement epamLogoInIframe;

    @FindBy(xpath = "//div[@class='main-content']/h3[@class='text-center']")
    WebElement subHeaderJdi;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Get 4 benefit images on the Index Page ")
    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    @Step("Get 4 benefit texts on the Index Page below benefit icons")
    public List<WebElement> getBenefitTexts() {
        return benefitText;
    }

    @Step("Open site by URL  https://jdi-testing.github.io/jdi-light/index.html")
    public void openSite() {
        driver.navigate().to(siteUrl);
    }

    @Step("login default user: {0} {1}")
    public void performLogin(String userName, String password) {
        openLoginDropdownButton.click();
        loginField.sendKeys(userName);
        passwordField.sendKeys(password);
        enterCredentials.click();
    }

    @Step("Get User name in the left-top side of screen that user is logged in")
    public String getLoggedUserName() {
        return loggedUserName.getText();
    }

    @Step("Get 4 items on the header section\n"
            + " to make further check of proper names:\n"
            + "  \"HOME\", \"CONTACT FORM\", \"SERVICE\", \"METALS & COLORS\"")
    public String getHeaderItem(HeaderItems headerItem) {

        switch (headerItem) {
            case HOME:
                return headerItemHome.getText();

            case CONTACT_FORM:
                return headerItemContact.getText();

            case SERVICE:
                return headerItemService.getText();

            case METAL_AND_COLORS:
                return headerItemMetalAndColor.getText();

            default:
                throw new NotFoundException("There is no such tab" + headerItem);

        }
    }

    @Step("Get a text of the main headers \"EPAM FRAMEWORK WISHES\"")
    public WebElement getMainHeaderEpamWishes() {
        return mainContentHeader;
    }

    @Step("Get a text of the main headers \"LOREM IPSUM...\"")
    public WebElement getMainHeaderEpamLorem() {
        return mainContentText;
    }

    @Step("Switch to the iframe")
    public void goToCentralIframe() {
        driver.switchTo().frame(iframeCenter);
    }

    @Step("Check if text of the sub header JDI GITHUB i displayed")
    public boolean isJdiHeaderDisplayed() {
        return subHeaderJdi.isDisplayed();
    }

    @Step("Check if the iframe in the center of page is displayed")
    public boolean isCentralIframeDisplayed() {
        return iframeCenter.isDisplayed();
    }

    @Step("Check that there is Epam logo in the left top conner of iframe displayed")
    public boolean isEpamLogoDisplayed() {
        return epamLogoInIframe.isDisplayed();
    }

    public void getBackFromIframeToMainSite() {
        driver.switchTo().parentFrame();
    }
}
