package com.marizueva.laboratory.hw5.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserTablePage extends BasePage {

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='checkbox'][id='ivan']")
    private WebElement vipCheckboxForSergeyIvan;

    @FindBy(css = ".logs>li")
    private List<WebElement> allLogs;

    @FindBy(css = "table[id='user-table'] select")
    private List<WebElement> dropdownItemsOnPage;

    @FindBy(css = "td>a")
    private List<WebElement> allUserNamesInTable;

    @FindBy(css = ".user-descr")
    private List<WebElement> allUserDescriptions;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> allCheckboxes;

    @FindBy(css = "tr>td:nth-child(1)")
    private List<WebElement> allNumbersInTable;

    @FindBy(css = "tr>td:nth-child(3)>a")
    private List<WebElement> allUsersInTable;

    @FindBy(css = "tr>td:nth-child(4)>div>span")
    private List<WebElement> allDescriptionInTable;

    @FindBy(css = "table tr:nth-child(1)>td:nth-child(2) option")
    private List<WebElement> allDropdownValues;

    public void chooseVipCheckboxForSergeyIvan() {
        vipCheckboxForSergeyIvan.click();
    }

    public List<String> getAllLogs() {
        return allLogs.stream().map(e -> e.getText()).collect(Collectors.toList());
    }


    public boolean isUserTableOpened() {
        return driver.getCurrentUrl()
                .equals("https://jdi-testing.github.io/jdi-light/user-table.html");
    }

    public List<String> getAllNumbersInTableInString() {
        return allNumbersInTable.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllUsersInTableInString() {
        return allUsersInTable.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllDescriptionInTableInString() {
        return allDescriptionInTable.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAllDropdownValuesInString() {
        return allDropdownValues.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
