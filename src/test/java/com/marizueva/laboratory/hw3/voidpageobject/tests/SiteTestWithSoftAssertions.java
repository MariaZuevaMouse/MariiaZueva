package com.marizueva.laboratory.hw3.voidpageobject.tests;

import com.marizueva.laboratory.hw3.voidpageobject.pages.HomePage;
import com.marizueva.laboratory.hw3.voidpageobject.pages.ServiceDifferentElementPage;
import com.marizueva.laboratory.hw3.voidpageobject.pages.ServicesSubCategories;
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
    ServiceDifferentElementPage serviceDifferentElementPage;
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
        homePage = new HomePage(driver);
        serviceDifferentElementPage = new ServiceDifferentElementPage(driver);
    }

    @Test
    public void testCheckBrowserTitle() {
        homePage.openSite();
        softAssert.assertEquals(driver.getTitle(), homePageTitle);
    }

    @Test
    public void testCheckLoggedUserName() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        String loggedUserName = homePage.getLoggedUserName();

        softAssert.assertEquals(loggedUserName, loggedUser);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "servicesSubCategories")
    public void testCheckServicesOptionsFromHeader(ServicesSubCategories subCategories) {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.clickServiceItemFromHeader();
        WebElement subMenuServiceItemFromHeader =
                homePage.getSubMenuServiceItemFromHeader(subCategories);


        Assert.assertTrue(subMenuServiceItemFromHeader.isDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "servicesSubCategoriesData")
    public void testCheckServicesOptionsFromLeftSection(ServicesSubCategories subCategories) {

        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.clickServiceItemFromLeftSection();
        WebElement subMenuServiceItemFromHeader =
                homePage.getSubMenuServiceItemFromLeftMenu(subCategories);

        Assert.assertTrue(subMenuServiceItemFromHeader.isDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "checkElementsOnDifferentElementPage")
    public void testCheckDifferentElementPageWithRequiredElements(
            ServiceDifferentElementPage.ElementType type, int qty) {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToDifferentElementPageFromHeader();
        serviceDifferentElementPage.checkElementItemCount(type, qty, softAssert);
    }

    @Test
    public void testCheckExistingRightSectionOnDifferentElementPage() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToDifferentElementPageFromHeader();
        WebElement theRightSection = serviceDifferentElementPage.getTheRightSection();

        softAssert.assertTrue(theRightSection.isDisplayed());
    }

    @Test
    public void testCheckExistingLeftSectionDifferentElementPage() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToDifferentElementPageFromHeader();
        WebElement leftSection = serviceDifferentElementPage
                .getLeftSection();

        softAssert.assertTrue(leftSection.isDisplayed());
    }

    @Test
    public void testLogsForCheckboxesWaterSwitchedOn() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToDifferentElementPageFromHeader();
        serviceDifferentElementPage
                .clickWaterCheckbox();
        WebElement waterLogInTrue = serviceDifferentElementPage
                .getWaterLogInTrue();
        softAssert.assertTrue(waterLogInTrue.isDisplayed());
        softAssert.assertEquals(waterLogInTrue.getTagName(), "li");

    }

    @Test
    public void testLogsForCheckboxesWindSwitchedOn() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToDifferentElementPageFromHeader();
        serviceDifferentElementPage
                .clickWindCheckbox();
        WebElement windLogInTrue = serviceDifferentElementPage
                .getWindLogInTrue();

        softAssert.assertTrue(windLogInTrue.isDisplayed());
        softAssert.assertEquals(windLogInTrue.getTagName(), "li");
    }

    @Test
    public void testLogsForRadioButton() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToDifferentElementPageFromHeader();
        serviceDifferentElementPage
                .chooseRadioSelen();
        WebElement radioSelenLog = serviceDifferentElementPage
                .getRadioSelenLog();
        softAssert.assertTrue(radioSelenLog.isDisplayed());
        softAssert.assertEquals(radioSelenLog.getText().substring(22),
                "changed to Selen");
    }

    @Test
    public void testLogsForDropdown() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToDifferentElementPageFromHeader();
        serviceDifferentElementPage
                .openColorDropdown();
        serviceDifferentElementPage
                .clickYellowInDropdown();
        WebElement dropdownYellowLog = serviceDifferentElementPage
                .getDropdownYellowLog();

        softAssert.assertTrue(dropdownYellowLog.isDisplayed());
        softAssert.assertEquals(dropdownYellowLog.getText().substring(17),
                "value changed to Yellow");
    }

    @Test
    public void testLogsForCheckboxesWaterSwitchedOff() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToDifferentElementPageFromHeader();
        serviceDifferentElementPage
               .clickWaterCheckbox();
        serviceDifferentElementPage
               .clickWaterCheckbox();
        WebElement waterLogFalse = serviceDifferentElementPage
                .getWaterLogInFalse();
        softAssert.assertTrue(waterLogFalse.isDisplayed());
        softAssert.assertEquals(waterLogFalse.getText().substring(9),
                "Water: condition changed to false");

    }

    @Test
    public void testLogsForCheckboxesWindSwitchedOff() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToDifferentElementPageFromHeader();
        serviceDifferentElementPage
                .clickWindCheckbox();
        serviceDifferentElementPage
                .clickWindCheckbox();
        WebElement windLogInFalse = serviceDifferentElementPage
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
