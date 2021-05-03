package com.marizueva.laboratory.hw3.fluentpageobject.tests;

import com.marizueva.laboratory.hw3.fluentpageobject.pages.HeaderItems;
import com.marizueva.laboratory.hw3.testdata.DataProviders;
import com.marizueva.laboratory.hw3.utils.DriverManager;
import com.marizueva.laboratory.hw3.fluentpageobject.pages.HomePage;
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

public class SiteTestWithHardAssertions {
    WebDriver driver;
    HomePage homePage;
    Properties testDataProps = null;
    String homePageTitle = "Home Page";
    String loggedUser = "ROMAN IOVLEV";


    private String userName; //= "Roman";
    private String password; //= "Jdi1234";
    private String title;
    private String name;
    private String headerItem;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        testDataProps  = TestDataProperties.getTestDataProps();
        userName = testDataProps.getProperty("username");
        password = testDataProps.getProperty("password");

    }

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.setUpDriver();
    }

    @Test
    public void testBrowserTitleForHome() {
        homePage = new HomePage(driver)
                .openSite();
        Assert.assertEquals(driver.getTitle(), homePageTitle);
    }

    @Test
    public void testCheckLoggedUserName() {
        String loggedUserName = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getLoggedUserName();

        Assert.assertEquals(loggedUserName, loggedUser);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "headerItemsEn")
    public void testHeaderItems(HeaderItems headerItem) {
        String headerItemActual = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getHeaderItem(headerItem);

        Assert.assertEquals(headerItemActual, headerItem.requestedTab);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "benefitIconsTextIndex")
    public void testCheckBenefitImages(int index) {
        boolean result = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .checkBenefitIconIsDisplayed(index);

        Assert.assertTrue(result);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "benefitIconsTextIndex")
    public void testCheckBenefitText(int index) {
        boolean result = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .checkBenefitTextIsDisplayed(index);

        Assert.assertTrue(result);
    }

    @Test
    public void testMainHeader() {
        WebElement mainHeaderEpamWishes = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getMainHeaderEpamWishes();
        Assert.assertTrue(mainHeaderEpamWishes.isDisplayed());
        Assert.assertEquals(mainHeaderEpamWishes.getText().substring(0, 21), //
                "EPAM FRAMEWORK WISHES");
    }

    @Test
    public void testMainHeaderText() {
        WebElement mainHeaderEpamLorem = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getMainHeaderEpamLorem();
        Assert.assertTrue(mainHeaderEpamLorem.isDisplayed());
        Assert.assertEquals(mainHeaderEpamLorem.getText().substring(0, 11), "LOREM IPSUM");
    }

    @Test
    public void testCheckCentralIframeExisting() {
        WebElement centralIframe = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getCentralIframe();
        Assert.assertTrue(centralIframe.isDisplayed());
    }

    @Test
    public void testCheckEpamLogoInIframe() {
        WebElement epamLogo = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .goToCentralIframe()
                .getEpamLogo();

        Assert.assertTrue(epamLogo.isDisplayed());
    }

    @Test
    public void testJdiGithubHeaderHasProperLink() {
        WebElement jdiHeader = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getJdiHeader();
        
        Assert.assertTrue(jdiHeader.isDisplayed());
        Assert.assertEquals(jdiHeader.getAttribute("href"), "https://github.com/epam/JDI");
    }

    @Test
    public void testCheckExistingLeftSection() {
        WebElement leftSection = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getLeftSection();

        Assert.assertTrue(leftSection.isDisplayed());
    }

    @Test
    public void testCheckExistingFooter() {
        WebElement footer = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getFooter();
        Assert.assertTrue(footer.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
