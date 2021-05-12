package com.marizueva.laboratory.hw2.ex2;

import com.marizueva.laboratory.hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LoginTestWithSoftAssertions extends BaseTest {
    SoftAssert softAssert;


    @BeforeMethod
    public void beforeClass() {
        softAssert = new SoftAssert();

    }

    @Test
    public void testLoginTest() {
        //Open test site by URL https://jdi-testing.github.io/jdi-light/index.html
        // Test site is opened
        // Assert Browser title"Home Page"
        driver.navigate().to(baseUrl);
        softAssert.assertEquals(driver.getTitle(), "HomePage");

        //Perform login username: Roman pass: Jdi1234
        WebElement openLoginDropdownButton = driver.findElement(By
                .cssSelector("a[href='#'] >.caret"));
        openLoginDropdownButton.click();

        WebElement loginField = driver.findElement(By
                .id("name"));
        loginField.sendKeys(login);

        WebElement passwordField = driver.findElement(By
                .id("password"));
        passwordField.sendKeys(password);

        WebElement enterCredentials = driver.findElement(By
                .xpath("//ul/li[@class='dropdown uui-profile-menu open']"
                        + "/descendant::span[text()='Enter']"));
        enterCredentials.click();


        //Assert User name in the left-top side of screen that user is logged:ROMAN IOVLEV
        // Name is displayed and equals to expected result
        WebElement loggedUserName = driver.findElement(By
                .id("user-name"));

        softAssert.assertEquals(loggedUserName.getText(), "ROMAN IOVLEV");

        // Click on "Service" subcategory in the header and check that drop down contains
        // options. "Support, Dates, Complex Table, Simple Table, Tables With Pages,
        // Different Elements"
        WebElement headerItemService = driver.findElement(By
                .cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle"));
        headerItemService.click();

        List<WebElement> subMenuFromHeader = driver.findElements(By
                .cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul>li"));
        for (WebElement e : subMenuFromHeader) {
            e.isDisplayed();
        }

        // Click on Service subcategory in the left section and check that
        // drop down contains options
        //"Support, Dates, Complex Table, Simple Table, Tables With Pages,
        // Different Elements"
        WebElement leftServiceMenu = driver.findElement(By
                .cssSelector("ul.sidebar-menu.left >li[index='3']"));
        leftServiceMenu.click();


        List<WebElement> serviceSubMenuFromLeft = driver.findElements(By
                .cssSelector(" ul > li.menu-title.active>ul.sub>li"));
        for (WebElement e : serviceSubMenuFromLeft) {
            softAssert.assertTrue(e.isDisplayed());
        }


        // Open through the header menu Service -> Different Elements Page
        headerItemService.click();
        WebElement subMenuFromHeaderDifferentElementsItem = driver.findElement(
                By.xpath("//header//ul/li/a[@class='dropdown-toggle']"
                        + "/following-sibling::ul[@class='dropdown-menu']"
                        + "/li/a[@href='different-elements.html']"));
        subMenuFromHeaderDifferentElementsItem.click();

        //Check interface on Different elements page, it contains all needed
        // elements 4 checkboxes, 4 radios, 1 dropdown, 2 buttons

        List<WebElement> checkBoxes = driver.findElements(
                By.cssSelector("input[type='checkbox']"));
        softAssert.assertEquals(checkBoxes.size(), 4);

        List<WebElement> radioButtons = driver.findElements(
                By.cssSelector("input[type='radio']"));
        softAssert.assertEquals(radioButtons.size(), 4);

        List<WebElement> dropdownMenu = driver.findElements(
                By.cssSelector("div.colors"));
        softAssert.assertEquals(dropdownMenu.size(), 1);

        // Assert that there is Right Section
        WebElement rightPanel = driver.findElement(
                By.cssSelector(".uui-side-bar.right-fix-panel"));
        softAssert.assertTrue(rightPanel.isDisplayed());

        // Assert that there is Left Section
        WebElement leftPanel = driver.findElement(By.id("mCSB_1_container"));
        softAssert.assertTrue(leftPanel.isDisplayed());

        // Select checkboxes Water, Wind
        WebElement waterCheckbox = driver
                .findElement(By
                        .cssSelector("div.checkbox-row > label.label-checkbox:nth-child(1)"));
        waterCheckbox.click();
        WebElement windCheckbox = driver
                .findElement(By
                        .cssSelector("div.checkbox-row > label.label-checkbox:nth-child(3)"));
        windCheckbox.click();

        // Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        // Log rows are displayed, checkbox name and its status is corresponding to selected
        WebElement waterLogTrue = driver.findElement(By
                .cssSelector("div.info-panel-body-log li:nth-last-child(1)"));
        softAssert.assertTrue(waterLogTrue.isDisplayed());
        softAssert.assertEquals(waterLogTrue.getTagName(), "li");

        WebElement windLogTrue = driver.findElement(By
                .cssSelector("div.info-panel-body-log li:nth-last-child(2)"));
        softAssert.assertTrue(windLogTrue.isDisplayed());
        softAssert.assertEquals(windLogTrue.getTagName(), "li");

        // Select radio Selen
        WebElement radioSelen = driver.findElement(By
                .cssSelector("label:nth-child(4) > input[type=radio]"));
        radioSelen.click();

        // Assert that for radiobutton there is a log row and value is corresponded
        // to the status of radiobutton.
        // Log row is displayed, radiobutton name and its status is corresponding to selected
        WebElement selenLog = driver.findElement(By
                .cssSelector("div.info-panel-body-log li:nth-last-child(3)"));
        softAssert.assertTrue(selenLog.isDisplayed());
        softAssert.assertEquals(selenLog.getText().substring(22),
                "changed to Selen");

        // Select in dropdown Yellow
        WebElement openColorDropdown = driver.findElement(By
                .cssSelector("div.colors>.uui-form-element"));
        openColorDropdown.click();
        WebElement dropdownYellow = driver.findElement(By
                .xpath("//div[@class='colors']/select/option[text()='Yellow']"));
        dropdownYellow.click();

        // Assert that for dropdown there is a log row and value is corresponded
        // to the selected value.
        // Log row is displayed, dropdown name and selected value is corresponding to selected
        WebElement dropdownYellowLog = driver.findElement(By
                .cssSelector("div.info-panel-body-log li:nth-last-child(4)"));

        softAssert.assertTrue(dropdownYellowLog.isDisplayed());
        softAssert.assertEquals(dropdownYellowLog.getText().substring(17),
                "value changed to Yellow");


    }

}
