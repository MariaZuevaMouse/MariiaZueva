package com.marizueva.laboratory.hw4.voidpageobject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceDifferentElementPage extends CommonPageElements {

    @FindBy(css = "input[type='checkbox'")
    List<WebElement> checkBoxes;

    @FindBy(css = "input[type='radio'")
    List<WebElement> radioButtons;

    @FindBy(css = "div.colors")
    List<WebElement> dropdownMenu;

    @FindBy(css = ".uui-side-bar.right-fix-panel")
    WebElement rightPanel;

    @FindBy(css = "div.checkbox-row > label.label-checkbox:nth-child(1)")
    WebElement waterCheckbox;

    @FindBy(css = "div.checkbox-row > label.label-checkbox:nth-child(3)")
    WebElement windCheckbox;

    @FindBy(css = "div.checkbox-row > label.label-radio:nth-child(4)")
    WebElement radioSelen;

    @FindBy(css = "div.colors>.uui-form-element")
    WebElement openColorDropdown;

    @FindBy(xpath = "//div[@class='colors']/select/option[text()='Yellow']")
    WebElement dropdownYellow;


    @FindBy(css = "ul.logs>li")
    private List<WebElement> allLogs;

    public ServiceDifferentElementPage(WebDriver driver) {
        super(driver);
    }

    public ServiceDifferentElementPage checkElementItemCount(
            ElementType elementType, int qty, SoftAssert softAssert) {
        switch (elementType) {
            case CHECKBOXES:
                softAssert.assertEquals(checkBoxes.size(), qty);
                break;
            case RADIO_BUTTONS:
                softAssert.assertEquals(radioButtons.size(), qty);
                break;
            case DROPDOWN_MENU:
                softAssert.assertEquals(dropdownMenu.size(), qty);
                break;
            default: throw new NotFoundException("no such element");
        }

        return this;
    }

    public WebElement getTheRightSection() {
        return rightPanel;
    }

    @Step
    public void clickWaterCheckbox() {
        waterCheckbox.click();
    }

    @Step
    public void clickWindCheckbox() {
        windCheckbox.click();
    }

    @Step
    public void chooseRadioSelen() {
        radioSelen.click();

    }

    @Step
    public ServiceDifferentElementPage openColorDropdown() {
        openColorDropdown.click();
        return this;
    }

    public void clickYellowInDropdown() {
        dropdownYellow.click();
    }


    public boolean isTheRightSectionDisplayed() {
        return rightPanel.isDisplayed();
    }

    public enum ElementType {
        CHECKBOXES, RADIO_BUTTONS, DROPDOWN_MENU
    }


    @Step("Check log content")
    public List<String> getAllLogsInStringFormat() {
        return allLogs.stream()
                .map(WebElement::getText)
                .map(e -> e.substring(9))
                .collect(Collectors.toList());
    }
}
