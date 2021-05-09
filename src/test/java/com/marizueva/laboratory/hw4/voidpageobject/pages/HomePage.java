package com.marizueva.laboratory.hw4.voidpageobject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPageElements {

    @FindBy(xpath = "//*[@class='benefit-icon'][1]")
    WebElement displayedBenefitImage1;

    @FindBy(xpath = "//*[@class='benefit-icon']/span[@class='icons-benefit icon-custom'][1]")
    WebElement displayedBenefitImage2;

    @FindBy(xpath = "//*[@class='benefit-icon']/span[@class='icons-benefit icon-multi'][1]")
    WebElement displayedBenefitImage3;

    @FindBy(xpath = "//*[@class='benefit-icon']/span[@class='icons-benefit icon-base'][1]")
    WebElement displayedBenefitImage4;

    @FindBy(xpath = "(//*[@class='benefit-txt'])[1]")
    WebElement benefitText1;

    @FindBy(xpath = "(//*[@class='benefit-txt'])[2]")
    WebElement benefitText2;

    @FindBy(xpath = "(//*[@class='benefit-txt'])[3]")
    WebElement benefitText3;

    @FindBy(xpath = "(//*[@class='benefit-txt'])[4]")
    WebElement benefitText4;

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

    @Step
    public void openSite() {
        driver.navigate().to(siteUrl);
    }

    @Step("login default user")
    public void performLogin(String userName, String password) {
        openLoginDropdownButton.click();
        loginField.sendKeys(userName);
        passwordField.sendKeys(password);
        enterCredentials.click();
    }

    @Step
    public String getLoggedUserName() {
        return loggedUserName.getText();
    }

    @Step
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

    @Step
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

    @Step
    public boolean checkBenefitTextIsDisplayed(int index) {
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

    @Step
    public WebElement getMainHeaderEpamWishes() {
        return mainContentHeader;
    }

    @Step
    public WebElement getMainHeaderEpamLorem() {
        return mainContentText;
    }

    @Step
    public void goToCentralIframe() {
        driver.switchTo().frame(iframeCenter);
    }

    @Step
    public boolean isJdiHeaderDisplayed() {
        return subHeaderJdi.isDisplayed();
    }

    @Step
    public boolean isCentralIframeDisplayed() {
        return iframeCenter.isDisplayed();
    }

    @Step
    public boolean isEpamLogoDisplayed() {
        return epamLogoInIframe.isDisplayed();
    }

    @Step
    public void getBackFromIframeToMainSite() {
        driver.switchTo().parentFrame();
    }
}
