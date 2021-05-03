package com.marizueva.laboratory.hw3.fluentpageobject.tests;

import com.marizueva.laboratory.hw3.fluentpageobject.pages.HomePage;
import com.marizueva.laboratory.hw3.fluentpageobject.pages.ServiceDifferentElementPage;
import com.marizueva.laboratory.hw3.fluentpageobject.pages.ServicesSubCategories;
import com.marizueva.laboratory.hw3.testdata.DataProviders;
import com.marizueva.laboratory.hw3.utils.DriverManager;
import com.marizueva.laboratory.hw3.utils.TestDataProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class SiteTestWithSoftAssertions {
    WebDriver driver;
    SoftAssert softAssert;
    HomePage homePage;
    Properties testDataProps = null;
    String homePageTitle = "Home Page";
    String loggedUser = "ROMAN IOVLEV";

    private String userName; //= "Roman";
    private String password;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {

        testDataProps  = TestDataProperties.getTestDataProps();
        userName = testDataProps.getProperty("username");
        password = testDataProps.getProperty("password");
        softAssert = new SoftAssert();

    }

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.setUpDriver();
    }

    @Test
    public void testCheckBrowserTitle() {
        new HomePage(driver)
                .openSite();
        softAssert.assertEquals(driver.getTitle(), homePageTitle);
    }

    @Test
    public void testCheckLoggedUserName() {
        String loggedUserName = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getLoggedUserName();

        softAssert.assertEquals(loggedUserName, loggedUser);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "servicesSubCategories")
    public void testCheckServicesOptionsFromHeader(ServicesSubCategories subCategories) {
        WebElement subMenuServiceItemFromHeader = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .clickServiceItemFromHeader()
                .getSubMenuServiceItemFromHeader(subCategories);

        Assert.assertTrue(subMenuServiceItemFromHeader.isDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "servicesSubCategories")
    public void testCheckServicesOptionsFromLeftSection(ServicesSubCategories subCategories) {
        WebElement subMenuServiceItemFromHeader = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .clickServiceItemFromLeftSection()
                .getSubMenuServiceItemFromLeftMenu(subCategories);

        Assert.assertTrue(subMenuServiceItemFromHeader.isDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "checkElementsOnDifferentElementPage")
    public void testCheckDifferentElementPageWithRequiredElements(
            ServiceDifferentElementPage.ElementType type, int qty) {
        new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToDifferentElementPageFromHeader()
                .checkElementItemCount(type, qty, softAssert);
    }

    @Test
    public void testCheckExistingRightSectionOnDifferentElementPage() {
        WebElement theRightSection = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToDifferentElementPageFromHeader()
                .getTheRightSection();
        softAssert.assertTrue(theRightSection.isDisplayed());
    }

    @Test
    public void testCheckExistingLeftSectionDifferentElementPage() {
        WebElement leftSection = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToDifferentElementPageFromHeader()
                .getLeftSection();

        softAssert.assertTrue(leftSection.isDisplayed());
    }

    @Test
    public void testLogsForCheckboxesWaterSwitchedOn() {
        WebElement waterLogInTrue = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToDifferentElementPageFromHeader()
                .clickWaterCheckbox()
                .getWaterLogInTrue();
        softAssert.assertTrue(waterLogInTrue.isDisplayed());
        softAssert.assertEquals(waterLogInTrue.getTagName(), "li");

    }

    @Test
    public void testLogsForCheckboxesWindSwitchedOn() {
        WebElement windLogInTrue = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToDifferentElementPageFromHeader()
                .clickWindCheckbox()
                .getWindLogInTrue();

        softAssert.assertTrue(windLogInTrue.isDisplayed());
        softAssert.assertEquals(windLogInTrue.getTagName(), "li");
    }

    @Test
    public void testLogsForRadioButton() {
        WebElement radioSelenLog = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToDifferentElementPageFromHeader()
                .chooseRadioSelen()
                .getRadioSelenLog();
        softAssert.assertTrue(radioSelenLog.isDisplayed());
        softAssert.assertEquals(radioSelenLog.getText().substring(22),
                "changed to Selen");
    }

    @Test
    public void testLogsForDropdown() {
        WebElement dropdownYellowLog = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToDifferentElementPageFromHeader()
                .openColorDropdown()
                .clickYellowInDropdown()
                .getDropdownYellowLog();

        softAssert.assertTrue(dropdownYellowLog.isDisplayed());
        softAssert.assertEquals(dropdownYellowLog.getText().substring(17),
                "value changed to Yellow");
    }

    @Test
    public void testLogsForCheckboxesWaterSwitchedOff() {
        WebElement waterLogFalse = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToDifferentElementPageFromHeader()
                .clickWaterCheckbox()
                .clickWaterCheckbox()
                .getWaterLogInFalse();
        softAssert.assertTrue(waterLogFalse.isDisplayed());
        softAssert.assertEquals(waterLogFalse.getText().substring(9),
                "Water: condition changed to false");

    }

    @Test
    public void testLogsForCheckboxesWindSwitchedOff() {
        WebElement windLogInFalse = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToDifferentElementPageFromHeader()
                .clickWindCheckbox()
                .clickWindCheckbox()
                .getWindLogInFalse();

        softAssert.assertTrue(windLogInFalse.isDisplayed());
        softAssert.assertEquals(windLogInFalse.getText().substring(9),
                "Wind: condition changed to false");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
