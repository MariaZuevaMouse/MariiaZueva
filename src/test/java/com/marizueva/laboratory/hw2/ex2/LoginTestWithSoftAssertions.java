package com.marizueva.laboratory.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class LoginTestWithSoftAssertions {
    SoftAssert softAssert;

    private WebDriver driver;
    private  final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String login = "Roman";
    private final String password = "Jdi1234";

    @BeforeClass
    public void beforeClass() {
        softAssert = new SoftAssert();

        WebDriverManager.chromedriver().setup();

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--disable-notifications","--disable-popup-blocking");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testLoginTest() {
//        1	Open test site by URL	https://jdi-testing.github.io/jdi-light/index.html
//        Test site is opened
//        2	Assert Browser title"Home Page"
        driver.navigate().to(BASE_URL);
        softAssert.assertEquals(driver.getTitle(), "HomePage");

//        3	Perform login	username: Roman pass: Jdi1234
        WebElement openLoginDropdownButton = driver.findElement(By.xpath("//li[@class='dropdown uui-profile-menu']//span[@class='caret'][1]"));
        openLoginDropdownButton.click();

        WebElement loginField = driver.findElement(By.xpath("//ul/li[@class='dropdown uui-profile-menu open']/descendant::input[@id='name']"));
        loginField.sendKeys(login);

        WebElement passwordField = driver.findElement(By.xpath("//ul/li[@class='dropdown uui-profile-menu open']/descendant::input[@id='password']"));
        passwordField.sendKeys(password);

        WebElement enterCredentials = driver.findElement(By.xpath("//ul/li[@class='dropdown uui-profile-menu open']/descendant::span[text()='Enter']"));
        enterCredentials.click();


//        4	Assert User name in the left-top side of screen that user is loggined	ROMAN IOVLEV	Name is displayed and equals to expected result
        WebElement loggedUserName = driver.findElement(By.xpath("//ul/li[@class='dropdown uui-profile-menu open']/descendant::span[@id='user-name']"));

        softAssert.assertEquals(loggedUserName.getText(), "ROMAN IOVLEV");

//       Click on "Service" subcategory in the header and check that drop down contains
//       options	"Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements"
        WebElement headerItemService = driver.findElement(By.xpath("//header//ul/li/a[@class='dropdown-toggle'][1]"));
        headerItemService.click();

        WebElement subMenuFromHeaderSupportItem = driver.findElement(By.xpath("//header//ul/li/a[@class='dropdown-toggle']/following-sibling::ul[@class='dropdown-menu']/li/a[text()='Support']"));
        softAssert.assertTrue(subMenuFromHeaderSupportItem.isDisplayed());
        WebElement subMenuFromHeaderDatesItem = driver.findElement(By.xpath("//header//ul/li/a[@class='dropdown-toggle']/following-sibling::ul[@class='dropdown-menu']/li/a[text()='Dates']"));
        softAssert.assertTrue(subMenuFromHeaderDatesItem.isDisplayed());
        WebElement subMenuFromHeaderSearchItem = driver.findElement(By.xpath("//header//ul/li/a[@class='dropdown-toggle']/following-sibling::ul[@class='dropdown-menu']/li/a[text()='Search']"));
        softAssert.assertTrue(subMenuFromHeaderSearchItem.isDisplayed());
        WebElement subMenuFromHeaderComplexTableItem = driver.findElement(By.xpath("//header//ul/li/a[@class='dropdown-toggle']/following-sibling::ul[@class='dropdown-menu']/li/a[text()='Complex Table']"));
        softAssert.assertTrue(subMenuFromHeaderComplexTableItem.isDisplayed());
        WebElement subMenuFromHeaderUserTableItem = driver.findElement(By.xpath("//header//ul/li/a[@class='dropdown-toggle']/following-sibling::ul[@class='dropdown-menu']/li/a[text()='User Table']"));
        softAssert.assertTrue(subMenuFromHeaderUserTableItem.isDisplayed());
        WebElement subMenuFromHeaderTableWithPagesItem = driver.findElement(By.xpath("//header//ul/li/a[@class='dropdown-toggle']/following-sibling::ul[@class='dropdown-menu']/li/a[text()='Table with pages']"));
        softAssert.assertTrue(subMenuFromHeaderTableWithPagesItem.isDisplayed());
        WebElement subMenuFromHeaderDifferentElementsItem = driver.findElement(By.xpath("//header//ul/li/a[@class='dropdown-toggle']/following-sibling::ul[@class='dropdown-menu']/li/a[text()='Different elements']"));
        softAssert.assertTrue(subMenuFromHeaderDifferentElementsItem.isDisplayed());

//        Click on Service subcategory in the left section and check that drop down contains options
//        "Support, Dates, Complex Table, Simple Table, Tables With Pages, Different Elements"	Elements exist
        WebElement leftServiceMenu = driver.findElement(By.cssSelector("ul.sidebar-menu.left >li[index='3']"));
        leftServiceMenu.click();

        WebElement subMenuFromLeftSupportItem = driver.findElement(By.xpath("//div[@name='navigation-sidebar']//span[text()='Support']"));
        softAssert.assertTrue(subMenuFromLeftSupportItem.isDisplayed());
        WebElement subMenuFromLeftDatesItem = driver.findElement(By.xpath("//div[@name='navigation-sidebar']//span[text()='Dates']"));
        softAssert.assertTrue(subMenuFromLeftDatesItem.isDisplayed());
        WebElement subMenuFromLeftSearchItem = driver.findElement(By.xpath("//div[@name='navigation-sidebar']//span[text()='Search']"));
        softAssert.assertTrue(subMenuFromLeftSearchItem.isDisplayed());
        WebElement subMenuFromLeftComplexTableItem = driver.findElement(By.xpath("//div[@name='navigation-sidebar']//span[text()='Complex Table']"));
        softAssert.assertTrue(subMenuFromLeftComplexTableItem.isDisplayed());
        WebElement subMenuFromLeftUserTableItem = driver.findElement(By.xpath("//div[@name='navigation-sidebar']//span[text()='User Table']"));
        softAssert.assertTrue(subMenuFromLeftUserTableItem.isDisplayed());
        WebElement subMenuFromLeftTableWithPagesItem = driver.findElement(By.xpath("//div[@name='navigation-sidebar']//span[text()='Table with pages']"));
        softAssert.assertTrue(subMenuFromLeftTableWithPagesItem.isDisplayed());
        WebElement subMenuFromLeftDifferentElementsItem = driver.findElement(By.xpath("//div[@name='navigation-sidebar']//span[text()='Different elements']"));
        softAssert.assertTrue(subMenuFromLeftDifferentElementsItem.isDisplayed());

//        Open through the header menu Service -> Different Elements Page
        subMenuFromHeaderDifferentElementsItem.click();

//        Check interface on Different elements page, it contains all needed
//        elements	4 checkboxes, 4 radios, 1 dropdown, 2 buttons


//        Assert that there is Right Section

//        Assert that there is Left Section


//        Select checkboxes	Water, Wind	Elements are checked

    }
}
