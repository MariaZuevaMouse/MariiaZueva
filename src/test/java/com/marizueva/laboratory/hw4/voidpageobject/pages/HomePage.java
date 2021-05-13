package com.marizueva.laboratory.hw4.voidpageobject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPageElements {

    @FindBy(css = ".icons-benefit.icon-practise")
    WebElement displayedBenefitImage1;

    @FindBy(xpath = "//*[@class='benefit-icon']/span[@class='icons-benefit icon-custom']")
    WebElement displayedBenefitImage2;

    @FindBy(xpath = "//*[@class='benefit-icon']/span[@class='icons-benefit icon-multi']")
    WebElement displayedBenefitImage3;

    @FindBy(xpath = "//*[@class='benefit-icon']/span[@class='icons-benefit icon-base']")
    WebElement displayedBenefitImage4;

    @FindBy(css = ".benefits> div:nth-child(1) span.benefit-txt")
    WebElement benefitText1;

    @FindBy(xpath = ".benefits> div:nth-child(2) span.benefit-txt")
    WebElement benefitText2;

    @FindBy(xpath = ".benefits> div:nth-child(3) span.benefit-txt")
    WebElement benefitText3;

    @FindBy(xpath = ".benefits> div:nth-child(4) span.benefit-txt")
    WebElement benefitText4;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textBelowImagesList;

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

    @Step("Open site by URL  https://jdi-testing.github.io/jdi-light/index.html")
    public void openSite() {
        driver.navigate().to(siteUrl);
    }

    @Step("login default user: Roman Jdi1234")
    public void performLogin(String userName, String password) {
        openLoginDropdownButton.click();
        loginField.sendKeys(userName);
        passwordField.sendKeys(password);
        enterCredentials.click();
    }

    @Step("Assert User name in the left-top side of screen that user is loggined 'ROMAN IOVLEV'")
    public String getLoggedUserName() {
        return loggedUserName.getText();
    }

    @Step("Assert that there are 4 items on the header section are displayed and\n"
            + " they have proper texts\n"
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

    @Step(" Assert that there are 4 images on the Index Page and they are displayed")
    public boolean isBenefitIconDisplayed(int index) {
        switch (index) {
            case 1:
                return displayedBenefitImage1.isDisplayed();
            case 2:
                return displayedBenefitImage2.isDisplayed();
            case 3:
                return displayedBenefitImage3.isDisplayed();
            case 4:
                return displayedBenefitImage4.isDisplayed();
            default:
                throw new NotFoundException("there is no such icon");
        }
    }

    @Step("Assert that there are 4 texts on the Index Page under icons\n"
            + " and they have proper text")
    public boolean isBenefitTextDisplayed(int index) {
        switch (index) {
            case 1:
                return benefitText1.isDisplayed();
            case 2:
                return benefitText2.isDisplayed();
            case 3:
                return benefitText3.isDisplayed();
            case 4:
                return benefitText4.isDisplayed();
            default:
                throw new NotFoundException("there is no such icon");
        }
    }

    @Step("Assert a text of the main headers \"EPAM FRAMEWORK WISHES\"")
    public WebElement getMainHeaderEpamWishes() {
        return mainContentHeader;
    }

    @Step("Assert a text of the main headers \"LOREM IPSUM...\"")
    public WebElement getMainHeaderEpamLorem() {
        return mainContentText;
    }

    @Step("Switch to the iframe")
    public void goToCentralIframe() {
        driver.switchTo().frame(iframeCenter);
    }

    @Step("Assert a text of the sub header JDI GITHUB")
    public boolean isJdiHeaderDisplayed() {
        return subHeaderJdi.isDisplayed();
    }

    @Step("Assert that there is the iframe in the center of page")
    public boolean isCentralIframeDisplayed() {
        return iframeCenter.isDisplayed();
    }

    @Step("Switch to the iframe and check that there is Epam logo in the left top conner of iframe")
    public boolean isEpamLogoDisplayed() {
        return epamLogoInIframe.isDisplayed();
    }

    public void getBackFromIframeToMainSite() {
        driver.switchTo().parentFrame();
    }
}
