package com.marizueva.laboratory.hw3.voidpageobject.tests;

import com.marizueva.laboratory.hw3.testdata.UsedInTestTerms;
import com.marizueva.laboratory.hw3.voidpageobject.pages.HomePage;
import com.marizueva.laboratory.hw3.voidpageobject.pages.ServiceDifferentElementPage;
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
        homePage = new HomePage(driver);
        homePage.openSite();
        softAssert.assertEquals(driver.getTitle(), homePageTitle);

        homePage.openSite();
        homePage.performLogin(userName, password);
        String loggedUserName = homePage.getLoggedUserName();
        softAssert.assertEquals(loggedUserName, loggedUser);

        differentElementPage = homePage
                .goToDifferentElementPageFromHeader();
        boolean theRightSectionDisplayed = differentElementPage
                .isTheRightSectionDisplayed();
        softAssert.assertTrue(theRightSectionDisplayed);

        WebElement leftSection = differentElementPage
                .getLeftSection();

        softAssert.assertTrue(leftSection.isDisplayed());

        differentElementPage.clickWaterCheckbox();
        WebElement waterLogInTrue = differentElementPage.getWaterLogInTrue();
        softAssert.assertTrue(waterLogInTrue.isDisplayed());
        softAssert.assertEquals(waterLogInTrue.getTagName(), "li");

        differentElementPage.clickWindCheckbox();
        WebElement windLogInTrue = differentElementPage.getWindLogInTrue();

        softAssert.assertTrue(windLogInTrue.isDisplayed());
        softAssert.assertEquals(windLogInTrue.getTagName(), "li");

        differentElementPage.chooseRadioSelen();
        WebElement radioSelenLog = differentElementPage.getRadioSelenLog();
        softAssert.assertTrue(radioSelenLog.isDisplayed());
        softAssert.assertEquals(radioSelenLog.getText().substring(22),
                UsedInTestTerms.diffElSelenLog);


        differentElementPage.openColorDropdown();
        differentElementPage.clickYellowInDropdown();
        WebElement dropdownYellowLog = differentElementPage.getDropdownYellowLog();

        softAssert.assertTrue(dropdownYellowLog.isDisplayed());
        softAssert.assertEquals(dropdownYellowLog.getText().substring(17),
                UsedInTestTerms.diffElDropdownYellowLog);

        differentElementPage.clickWaterCheckbox();
        differentElementPage.clickWaterCheckbox();
        WebElement waterLogInFalse = differentElementPage.getWaterLogInFalse();
        softAssert.assertTrue(waterLogInFalse.isDisplayed());
        softAssert.assertEquals(waterLogInFalse.getText().substring(9),
                UsedInTestTerms.diffElWaterFalseLog);

        differentElementPage.clickWindCheckbox();
        differentElementPage.clickWindCheckbox();
        WebElement windLogInFalse = differentElementPage.getWindLogInFalse();

        softAssert.assertTrue(windLogInFalse.isDisplayed());
        softAssert.assertEquals(windLogInFalse.getText().substring(9),
                UsedInTestTerms.diffElWindFalseLog);
    }

}
