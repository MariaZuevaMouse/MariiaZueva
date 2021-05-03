package com.marizueva.laboratory.hw3.voidpageobject.pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ServiceDifferentElementPage extends CommonPageElements {

    @FindBy(css = "input[type='checkbox'")
    List<WebElement> checkBoxes;

    @FindBy(css = "input[type='radio'")
    List<WebElement> radioButtons;

    @FindBy(css = "div.colors")
    List<WebElement> dropdownMenu;

    @FindBy(css = ".uui-side-bar.right-fix-panel")
    WebElement rightPanel;

    //@FindBy(id = "mCSB_1_container")
    //WebElement leftPanel;

    @FindBy(xpath = "//label[@class='label-checkbox'][1]")
    WebElement waterCheckbox;

    @FindBy(xpath = "//label[@class='label-checkbox'][3]")
    WebElement windCheckbox;

    @FindBy(xpath = "//*[contains(text(),"
            + "substring('01:14:22  Water: condition changed to true',11, 42))]")
    WebElement waterLogTrue;

    @FindBy(xpath = "//*[contains(text(),"
            + "substring('009:38:12  Wind: condition changed to true',11, 15))]")
    WebElement windLogTrue;

    @FindBy(xpath = "//div[@class='checkbox-row']/label[@class='label-radio'][4]")
    WebElement radioSelen;

    @FindBy(xpath = "//*[contains(text(), substring('10:40:57 metal: "
            + "value changed to  Selen',23,40))] ")
    WebElement selenLog;

    @FindBy(css = "div.colors>.uui-form-element")
    WebElement openColorDropdown;

    @FindBy(xpath = "//div[@class='colors']/select/option[text()='Yellow']")
    WebElement dropdownYellow;

    @FindBy(xpath = "//*[contains(text(),substring('11:18:10 Colors: value"
            + " changed to Yellow',18, 40))]")
    WebElement dropdownYellowLog;

    @FindBy(xpath = "//*[contains(text(),"
            + "substring('11:23:22  Water: condition changed to false',11, 43))]")
    WebElement waterLogFalse;

    @FindBy(xpath = "//*[contains(text(),substring('11:23:20  Wind: "
            + "condition changed to false',11, 42))]")
    WebElement windLogFalse;

    public ServiceDifferentElementPage(WebDriver driver) {
        super(driver);
    }

    public void checkElementItemCount(
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

    }

    public WebElement getTheRightSection() {
        return rightPanel;
    }

    public void clickWaterCheckbox() {
        waterCheckbox.click();
    }

    public WebElement getWaterLogInTrue() {
        return waterLogTrue;
    }

    public void clickWindCheckbox() {
        windCheckbox.click();
    }

    public WebElement getWindLogInTrue() {
        return windLogTrue;
    }

    public void chooseRadioSelen() {
        radioSelen.click();
    }

    public WebElement getRadioSelenLog() {
        return selenLog;
    }

    public void openColorDropdown() {
        openColorDropdown.click();

    }

    public void clickYellowInDropdown() {
        dropdownYellow.click();
    }

    public WebElement getDropdownYellowLog() {
        return dropdownYellowLog;
    }

    public WebElement getWaterLogInFalse() {
        return waterLogFalse;
    }

    public WebElement getWindLogInFalse() {
        return windLogFalse;
    }

    public enum ElementType {
        CHECKBOXES, RADIO_BUTTONS, DROPDOWN_MENU
    }
}
