package com.marizueva.laboratory.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTestWithHardAssertions {
    private WebDriver driver;
    private  final String baseUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String login = "Roman";
    private final String password = "Jdi1234";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--disable-popup-blocking");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginPage() {
        //Open site by URL  https://jdi-testing.github.io/jdi-light/index.html
        driver.navigate().to(baseUrl);

        //Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //login site
        WebElement openLoginDropdownButton = driver.findElement(By
                .xpath("//li[@class='dropdown uui-profile-menu']//span[@class='caret'][1]"));
        openLoginDropdownButton.click();

        WebElement loginField = driver.findElement(By
                .xpath("//ul/li[@class='dropdown uui-profile-menu open']"
                        + "/descendant::input[@id='name']"));
        loginField.sendKeys(login);

        WebElement passwordField = driver.findElement(By
                .xpath("//ul/li[@class='dropdown uui-profile-menu open']"
                        + "/descendant::input[@id='password']"));
        passwordField.sendKeys(password);

        WebElement enterCredentials = driver.findElement(By
                .xpath("//ul/li[@class='dropdown uui-profile-menu open']"
                        + "/descendant::span[text()='Enter']"));
        enterCredentials.click();

        //Assert User name in the left-top side of screen that user is loggined
        WebElement loggedUserName = driver.findElement(By
                .xpath("//ul/li[@class='dropdown uui-profile-menu open']"
                        + "/descendant::span[@id='user-name']"));

        Assert.assertEquals(loggedUserName.getText(), "ROMAN IOVLEV");

        //  Assert Browser title "Home Page"
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //  Assert that there are 4 items on the header section are displayed and
        //  they have proper texts
        //  "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        WebElement headerItemHome = driver.findElement(By.xpath("//header//ul/li/a[@href='index.html'][1]"));
        Assert.assertEquals(headerItemHome.getText(), "HOME");

        WebElement headerItemContact = driver.findElement(By.xpath("//header//ul/li[2]/a[1]"));
        Assert.assertEquals(headerItemContact.getText(), "CONTACT FORM");

        WebElement headerItemService = driver.findElement(By
                .xpath("//header//ul/li/a[@class='dropdown-toggle'][1]"));
        Assert.assertEquals(headerItemService.getText(), "SERVICE");

        WebElement headerItemMetalAndColor = driver.findElement(By.xpath("//header//ul/li/a[@href='metals-colors.html'][1]"));
        Assert.assertEquals(headerItemMetalAndColor.getText(), "METALS & COLORS");

        //  Assert that there are 4 images on the Index Page and they are displayed
        WebElement displayedImage1 = driver.findElement(By
                .xpath("//*[@class='benefit-icon'][1]"));
        WebElement displayedImage2 = driver.findElement(By
                .xpath("//*[@class='benefit-icon']/span[@class='icons-benefit icon-custom'][1]"));
        WebElement displayedImage3 = driver.findElement(By
                .xpath("//*[@class='benefit-icon']/span[@class='icons-benefit icon-multi'][1]"));
        WebElement displayedImage4 = driver.findElement(By
                .xpath("//*[@class='benefit-icon']/span[@class='icons-benefit icon-base'][1]"));

        Assert.assertTrue(displayedImage1.isDisplayed());
        Assert.assertTrue(displayedImage2.isDisplayed());
        Assert.assertTrue(displayedImage3.isDisplayed());
        Assert.assertTrue(displayedImage4.isDisplayed());

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
                        + "some external projects),\nwish to get more\u2026"};
        for (int i = 0; i < iconExpectedText.length; i++) {

            Assert.assertEquals(iconTextsWebElement.get(i).getText(), iconExpectedText[i]);
        }

        //Assert a text of the main headers ""EPAM FRAMEWORK WISHES..." and "LOREM IPSUM..."
        // Text is displayed and equals to expected result
        // "EPAM FRAMEWORK WISHES..." and "LOREM IPSUM..."
        WebElement mainContentHeader = driver.findElement(By
                .xpath("//div[@class='main-content']/h3[@class='main-title text-center']"));
        WebElement mainContentText = driver.findElement(By.xpath("//div[@class='main-content']/p"));

        Assert.assertEquals(mainContentHeader.getText(), "EPAM FRAMEWORK WISHES\u2026");
        Assert.assertEquals(mainContentText.getText().substring(0, 11), "LOREM IPSUM");

        //Assert that there is the iframe in the center of page
        WebElement iframeCenter = driver.findElement(By.xpath("//iframe[@id='jdi-frame-site']"));
        Assert.assertTrue(iframeCenter.isDisplayed());

        //Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(iframeCenter);
        Assert.assertTrue(driver.findElement(By
                .xpath("//img[@src='images/Logo_Epam_Color.svg']")).isDisplayed());

        //Switch to original window back
        driver.switchTo().parentFrame();

        //Assert a text of the sub header JDI GITHUB
        // Text is displayed and equals to expected result
        Assert.assertTrue(driver.findElement(By
                .xpath("//div[@class='main-content']/h3[@class='text-center']"))
                .isDisplayed());

        //Assert that JDI GITHUB is a link and has a proper URL
        //  https://jdi-testing.github.io/jdi-light/index.html
        Assert.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html");

        //Assert that there is Left Section
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='sidebar-menu left']"))
                .isDisplayed());

        // Assert that there is Footer
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/footer")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
