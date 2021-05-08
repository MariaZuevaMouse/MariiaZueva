package com.marizueva.laboratory.hw4.voidpageobject.tests;

import com.marizueva.laboratory.hw4.testdata.UsedInTestTerms;
import com.marizueva.laboratory.hw4.utils.DriverManager;
import com.marizueva.laboratory.hw4.utils.TestDataProperties;
import com.marizueva.laboratory.hw4.voidpageobject.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    Properties testDataProps = null;
    String homePageTitle = UsedInTestTerms.homePageTitle;
    String loggedUser = UsedInTestTerms.loggedUserName;

    protected String userName;
    protected String password;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.setUpDriver();
        testDataProps  = TestDataProperties.getTestDataProps();
        userName = testDataProps.getProperty("username");
        password = testDataProps.getProperty("password");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
