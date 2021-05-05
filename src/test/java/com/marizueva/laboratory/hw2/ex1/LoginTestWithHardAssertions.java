package com.marizueva.laboratory.hw2.ex1;

import com.marizueva.laboratory.hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTestWithHardAssertions extends BaseTest {


    @Test
    public void testLoginPage() {
        //Open site by URL  https://jdi-testing.github.io/jdi-light/index.html
        driver.navigate().to(baseUrl);

        //Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //login site
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

        //Assert User name in the left-top side of screen that user is loggined
        WebElement loggedUserName = driver.findElement(By
                .id("user-name"));

        assertEquals(loggedUserName.getText(), "ROMAN IOVLEV");

        //  Assert Browser title "Home Page"
        assertEquals(driver.getTitle(), "Home Page");

        //  Assert that there are 4 items on the header section are displayed and
        //  they have proper texts
        //  "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        WebElement headerItemHome = driver.findElement(By
                .cssSelector("ul.uui-navigation a[href='index.html']"));

        assertEquals(headerItemHome.getText(), "HOME");

        WebElement headerItemContact = driver.findElement(By
                .cssSelector("ul.uui-navigation a[href='contacts.html']"));

        assertEquals(headerItemContact.getText(), "CONTACT FORM");

        WebElement headerItemService = driver.findElement(By
                .cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle"));

        assertEquals(headerItemService.getText(), "SERVICE");

        WebElement headerItemMetalAndColor = driver.findElement(By
                .cssSelector("ul.uui-navigation a[href='metals-colors.html']"));

        assertEquals(headerItemMetalAndColor.getText(), "METALS & COLORS");

        //  Assert that there are 4 images on the Index Page and they are displayed
        WebElement displayedImage1 = driver.findElement(By
                .cssSelector(".icons-benefit.icon-practise"));
        assertTrue(displayedImage1.isDisplayed());

        WebElement displayedImage2 = driver.findElement(By
                .cssSelector(".icons-benefit.icon-custom"));

        assertTrue(displayedImage2.isDisplayed());

        WebElement displayedImage3 = driver.findElement(By
                .cssSelector(".icons-benefit.icon-multi"));
        assertTrue(displayedImage3.isDisplayed());

        WebElement displayedImage4 = driver.findElement(By
                .cssSelector(".icons-benefit.icon-base"));
        assertTrue(displayedImage4.isDisplayed());

        // Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        // 4 texts below of each image Texts are displayed and equal to expected
        List<WebElement> iconTextsWebElement = driver.findElements(By
                .xpath("//*[@class='benefit-txt']"));
        String[] iconExpectedText = new String[]{"To include good practices\n"
                    + "and ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\n"
                        + "some external projects),\nwish to get more"};
        for (int i = 0; i < iconExpectedText.length - 1; i++) {

            assertEquals(iconTextsWebElement.get(i).getText(), iconExpectedText[i]);
        }
        assertEquals(iconTextsWebElement.get(iconExpectedText.length - 1).getText()
                .substring(0, 87),
                iconExpectedText[iconExpectedText.length - 1]);

        //Assert a text of the main headers ""EPAM FRAMEWORK WISHES..." and "LOREM IPSUM..."
        // Text is displayed and equals to expected result
        // "EPAM FRAMEWORK WISHES..." and "LOREM IPSUM..."
        WebElement mainContentHeader = driver.findElement(By
                .xpath("//div[@class='main-content']/h3[@class='main-title text-center']"));
        WebElement mainContentText = driver.findElement(By.xpath("//div[@class='main-content']/p"));

        assertEquals(mainContentHeader.getText().substring(0, 21), "EPAM FRAMEWORK WISHES");
        assertEquals(mainContentText.getText().substring(0, 11), "LOREM IPSUM");

        //Assert that there is the iframe in the center of page
        WebElement iframeCenter = driver.findElement(By.xpath("//iframe[@id='jdi-frame-site']"));
        assertTrue(iframeCenter.isDisplayed());

        //Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iframeCenter);
        assertTrue(driver.findElement(By
                .xpath("//img[@src='images/Logo_Epam_Color.svg']")).isDisplayed());

        //Switch to original window back
        driver.switchTo().parentFrame();

        //Assert a text of the sub header JDI GITHUB
        // Text is displayed and equals to expected result
        assertTrue(driver.findElement(By
                .xpath("//div[@class='main-content']/h3[@class='text-center']"))
                .isDisplayed());

        //Assert that JDI GITHUB is a link and has a proper URL
        //  https://jdi-testing.github.io/jdi-light/index.html
        assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html");

        //Assert that there is Left Section
        assertTrue(driver.findElement(By.xpath("//ul[@class='sidebar-menu left']"))
                .isDisplayed());

        // Assert that there is Footer
        assertTrue(driver.findElement(By.xpath("/html/body/footer")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
