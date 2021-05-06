package com.marizueva.laboratory.hw3.fluentpageobject.tests;

import com.marizueva.laboratory.hw3.fluentpageobject.pages.HomePage;
import com.marizueva.laboratory.hw3.fluentpageobject.pages.ServiceDifferentElementPage;
import com.marizueva.laboratory.hw3.testdata.UsedInTestTerms;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SiteTestWithSoftAssertions extends BaseTest {
    SoftAssert softAssert;
    ServiceDifferentElementPage differentElementPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        softAssert = new SoftAssert();
    }

    @Test
    public void testCheckBrowserTitle() {
        homePage = new HomePage(driver)
                .openSite();
        softAssert.assertEquals(driver.getTitle(), homePageTitle);


        String loggedUserName = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getLoggedUserName();
        softAssert.assertEquals(loggedUserName, loggedUser);

        differentElementPage = homePage
                .goToDifferentElementPageFromHeader();
        boolean theRightSectionDisplayed = differentElementPage
                .isTheRightSectionDisplayed();
        softAssert.assertTrue(theRightSectionDisplayed);

        WebElement leftSection = differentElementPage
                .getLeftSection();

        softAssert.assertTrue(leftSection.isDisplayed());


        WebElement waterLogInTrue = differentElementPage
                .clickWaterCheckbox()
                .getWaterLogInTrue();
        softAssert.assertTrue(waterLogInTrue.isDisplayed());
        softAssert.assertEquals(waterLogInTrue.getTagName(), "li");


        WebElement windLogInTrue = differentElementPage
                .clickWindCheckbox()
                .getWindLogInTrue();

        softAssert.assertTrue(windLogInTrue.isDisplayed());
        softAssert.assertEquals(windLogInTrue.getTagName(), "li");


        WebElement radioSelenLog = differentElementPage
                .chooseRadioSelen()
                .getRadioSelenLog();
        softAssert.assertTrue(radioSelenLog.isDisplayed());
        softAssert.assertEquals(radioSelenLog.getText().substring(22),
                UsedInTestTerms.diffElSelenLog);


        WebElement dropdownYellowLog = differentElementPage
                .openColorDropdown()
                .clickYellowInDropdown()
                .getDropdownYellowLog();

        softAssert.assertTrue(dropdownYellowLog.isDisplayed());
        softAssert.assertEquals(dropdownYellowLog.getText().substring(17),
                UsedInTestTerms.diffElDropdownYellowLog);


        WebElement waterLogFalse = differentElementPage
                .clickWaterCheckbox()
                .clickWaterCheckbox()
                .getWaterLogInFalse();
        softAssert.assertTrue(waterLogFalse.isDisplayed());
        softAssert.assertEquals(waterLogFalse.getText().substring(9),
                UsedInTestTerms.diffElWaterFalseLog);


        WebElement windLogInFalse = differentElementPage
                .goToDifferentElementPageFromHeader()
                .clickWindCheckbox()
                .clickWindCheckbox()
                .getWindLogInFalse();

        softAssert.assertTrue(windLogInFalse.isDisplayed());
        softAssert.assertEquals(windLogInFalse.getText().substring(9),
                UsedInTestTerms.diffElWindFalseLog);
    }

}
