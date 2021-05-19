package com.marizueva.laboratory.hw5.pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementPage extends BasePage {

    public DifferentElementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='checkbox']")
    List<WebElement> checkBoxes;

    @FindBy(css = "div.checkbox-row > label.label-radio:nth-child(4)")
    private WebElement radioSelen;

    @FindBy(css = "div.colors>.uui-form-element")
    private WebElement openColorDropdown;

    @FindBy(xpath = "//div[@class='colors']/select/option[text()='Yellow']")
    private WebElement dropdownYellow;

    @FindBy(css = "ul.logs>li")
    private List<WebElement> allLogs;


    public void clickCheckbox(String checkbox) {
        Checkboxes checkboxEnum = null;
        switch (checkbox) {
            case "Water":
                checkboxEnum = Checkboxes.WATER;
                break;
            case "Wind":
                checkboxEnum = Checkboxes.WIND;
                break;
            case "Fire":
                checkboxEnum = Checkboxes.FIRE;
                break;
            case "Earth":
                checkboxEnum = Checkboxes.EARTH;
                break;
            default: throw new NotFoundException("item " + checkbox + " not found");
        }
        checkBoxes.get(checkboxEnum.getIndex()).click();
    }

    public void chooseRadioSelen() {
        radioSelen.click();
    }

    public void chooseYellowDropdown() {
        openColorDropdown.click();
        dropdownYellow.click();
    }

    public List<WebElement> getAllLogs() {
        return allLogs;
    }
}
