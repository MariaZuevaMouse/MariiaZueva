package com.marizueva.laboratory.hw3.voidpageobject.tests;

import com.marizueva.laboratory.hw3.voidpageobject.pages.HeaderItems;
import com.marizueva.laboratory.hw3.voidpageobject.pages.HomePage;
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

import java.util.Properties;

public class SiteTestWithHardAssertions {
    WebDriver driver;
    HomePage homePage;
    Properties testDataProps = null;
    String homePageTitle = "Home Page";
    String loggedUser = "ROMAN IOVLEV";


    private String userName; //= "Roman";
    private String password; //= "Jdi1234";


    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        testDataProps  = TestDataProperties.getTestDataProps();
        userName = testDataProps.getProperty("username");
        password = testDataProps.getProperty("password");

    }

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.setUpDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testBrowserTitleForHome() {
        homePage.openSite();
        Assert.assertEquals(driver.getTitle(), homePageTitle);
    }

    @Test
    public void testCheckLoggedUserName() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        String loggedUserName = homePage.getLoggedUserName();

        Assert.assertEquals(loggedUserName, loggedUser);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "headerItemsFromEnum")
    public void testHeaderItems(HeaderItems headerItem) {
        homePage.openSite();
        homePage.performLogin(userName, password);
        String headerItemActual = homePage.getHeaderItem(headerItem);

        Assert.assertEquals(headerItemActual, headerItem.requestedTab);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "benefitIconsTextIndex")
    public void testCheckBenefitImages(int index) {
        homePage.openSite();
        homePage.performLogin(userName, password);
        boolean result = homePage.checkBenefitIconIsDisplayed(index);

        Assert.assertTrue(result);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "benefitIconsTextIndex")
    public void testCheckBenefitText(int index) {
        homePage.openSite();
        homePage.performLogin(userName, password);
        boolean result = homePage.checkBenefitTextIsDisplayed(index);

        Assert.assertTrue(result);
    }

    @Test
    public void testMainHeader() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        WebElement mainHeaderEpamWishes = homePage.getMainHeaderEpamWishes();

        Assert.assertTrue(mainHeaderEpamWishes.isDisplayed());
        Assert.assertEquals(mainHeaderEpamWishes.getText().substring(0, 21),
                "EPAM FRAMEWORK WISHES");
    }

    @Test
    public void testMainHeaderText() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        WebElement mainHeaderEpamLorem = homePage.getMainHeaderEpamLorem();

        Assert.assertTrue(mainHeaderEpamLorem.isDisplayed());
        Assert.assertEquals(mainHeaderEpamLorem.getText().substring(0, 11), "LOREM IPSUM");
    }

    @Test
    public void testCheckCentralIframeExisting() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        WebElement centralIframe = homePage.getCentralIframe();

        Assert.assertTrue(centralIframe.isDisplayed());
    }

    @Test
    public void testCheckEpamLogoInIframe() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        homePage.goToCentralIframe();
        WebElement epamLogo = homePage.getEpamLogo();

        Assert.assertTrue(epamLogo.isDisplayed());
    }

    @Test
    public void testJdiGithubHeaderHasProperLink() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        WebElement jdiHeader = homePage.getJdiHeader();

        Assert.assertTrue(jdiHeader.isDisplayed());
        //Assert.assertEquals(jdiHeader.getAttribute("href"), "https://github.com/epam/JDI");
    }

    @Test
    public void testCheckExistingLeftSection() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        WebElement leftSection = homePage.getLeftSection();

        Assert.assertTrue(leftSection.isDisplayed());
    }

    @Test
    public void testCheckExistingFooter() {
        homePage.openSite();
        homePage.performLogin(userName, password);
        WebElement footer = homePage.getFooter();
        Assert.assertTrue(footer.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
