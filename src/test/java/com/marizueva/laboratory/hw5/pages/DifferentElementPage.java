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

    @FindBy(css = "div.checkbox-row > label.label-checkbox:nth-child(1)")
    private WebElement waterCheckbox;

    @FindBy(css = "div.checkbox-row > label.label-checkbox:nth-child(3)")
    private WebElement windCheckbox;

    @FindBy(css = "div.checkbox-row > label.label-radio:nth-child(4)")
    private WebElement radioSelen;

    @FindBy(css = "div.colors>.uui-form-element")
    private WebElement openColorDropdown;

    @FindBy(xpath = "//div[@class='colors']/select/option[text()='Yellow']")
    private WebElement dropdownYellow;

    @FindBy(css = "ul.logs>li")
    private List<WebElement> allLogs;


    public void clickCheckbox(String checkbox) {
        switch (checkbox) {
            case "Water":
                waterCheckbox.click();
                break;
            case "Wind":
                windCheckbox.click();
                break;
            default: throw new NotFoundException("item " + checkbox + " not found");
        }
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
