package com.marizueva.laboratory.hw4.voidpageobject.tests;

import com.marizueva.laboratory.hw4.testdata.UsedInTestTerms;
import com.marizueva.laboratory.hw4.utils.testnaming.FeaturesNaming;
import com.marizueva.laboratory.hw4.utils.testnaming.StoriesNaming;
import com.marizueva.laboratory.hw4.voidpageobject.pages.HomePage;
import com.marizueva.laboratory.hw4.voidpageobject.pages.ServiceDifferentElementPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SiteTestWithSoftAssertions extends BaseTest {
    SoftAssert softAssert;
    ServiceDifferentElementPage differentElementPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        softAssert = new SoftAssert();
    }

    @Test
    @Story(value = StoriesNaming.JDI_SITE)
    @Feature(value = FeaturesNaming.DIFFERENT_ELEMENT_PAGE)
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
        List<String> allLogsInStringFormat = differentElementPage.getAllLogsInStringFormat();
        softAssert.assertTrue(allLogsInStringFormat.contains(UsedInTestTerms.diffElWaterTrueLog));


        differentElementPage.clickWindCheckbox();
        softAssert.assertTrue(allLogsInStringFormat.contains(UsedInTestTerms.diffElWindTrueLog));

        differentElementPage.chooseRadioSelen();
        softAssert.assertTrue(allLogsInStringFormat.contains(UsedInTestTerms.diffElSelenLog));


        differentElementPage.openColorDropdown();
        differentElementPage.clickYellowInDropdown();
        softAssert.assertTrue(allLogsInStringFormat
                .contains(UsedInTestTerms.diffElDropdownYellowLog));

        differentElementPage.clickWaterCheckbox();
        softAssert.assertTrue(allLogsInStringFormat.contains(UsedInTestTerms.diffElWaterFalseLog));

        differentElementPage.clickWindCheckbox();
        softAssert.assertTrue(allLogsInStringFormat.contains(UsedInTestTerms.diffElWindFalseLog));

    }

}
