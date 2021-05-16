package com.marizueva.laboratory.hw4.voidpageobject.tests;

import com.marizueva.laboratory.hw4.testdata.UsedInTestTerms;
import com.marizueva.laboratory.hw4.utils.testnaming.FeaturesNaming;
import com.marizueva.laboratory.hw4.utils.testnaming.StoriesNaming;
import com.marizueva.laboratory.hw4.voidpageobject.pages.HeaderItems;
import com.marizueva.laboratory.hw4.voidpageobject.pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FailedSiteTestWithHardAssertions extends BaseTest {

    @Test
    @Story(value = StoriesNaming.JDI_SITE)
    @Feature(value = FeaturesNaming.HOME_PAGE)
    public void testBrowserTitleForHome() {
        homePage = new HomePage(driver);
        homePage.openSite();
        Assert.assertEquals(driver.getTitle(), homePageTitle);


        homePage.performLogin(userName, password);
        String loggedUserName = homePage.getLoggedUserName();

        Assert.assertEquals(loggedUserName, loggedUserName);


        String headerItemHome = homePage.getHeaderItem(HeaderItems.HOME);
        Assert.assertEquals(headerItemHome, HeaderItems.HOME.getRequestedTabText());

        String headerItemContactForm = homePage.getHeaderItem(HeaderItems.CONTACT_FORM);
        Assert.assertEquals(headerItemContactForm, HeaderItems.CONTACT_FORM.getRequestedTabText());

        String headerItemService = homePage.getHeaderItem(HeaderItems.SERVICE);
        Assert.assertEquals(headerItemService, HeaderItems.SERVICE.getRequestedTabText());

        String headerItemMetalAndColors = homePage.getHeaderItem(HeaderItems.METAL_AND_COLORS);
        Assert.assertEquals(headerItemMetalAndColors,
                HeaderItems.METAL_AND_COLORS.getRequestedTabText());


        List<WebElement> benefitIcons = homePage.getBenefitIcons();

        for (WebElement e : benefitIcons) {
            Assert.assertTrue(e.isDisplayed());
        }

        String[] iconExpectedText = new String[]{"To include good practices\n"
                + "and ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\n"
                        + "some external projects),\nwish to get more"};

        List<WebElement> benefitTexts = homePage.getBenefitTexts();

        for (int i = 0; i < benefitTexts.size() - 1; i++) {
            Assert.assertTrue(benefitTexts.get(i).isDisplayed());
            Assert.assertEquals(benefitTexts.get(i).getText(), iconExpectedText[i]);
        }
        Assert.assertTrue(benefitTexts.get(3).isDisplayed());
        Assert.assertEquals(benefitTexts.get(3).getText().substring(0, 87), iconExpectedText[3]);


        WebElement mainHeaderEpamWishes = homePage.getMainHeaderEpamWishes();
        Assert.assertTrue(mainHeaderEpamWishes.isDisplayed());
        Assert.assertEquals(mainHeaderEpamWishes.getText().substring(0, 21),
            UsedInTestTerms.homeEpamFrameworkTitle + "me");

        WebElement mainHeaderEpamLorem = homePage
                .getMainHeaderEpamLorem();
        Assert.assertTrue(mainHeaderEpamLorem.isDisplayed());
        Assert.assertEquals(mainHeaderEpamLorem.getText().substring(0, 11),
                UsedInTestTerms.homeLoremTitle);

        boolean isCentralIframeDisplayed = homePage
                .isCentralIframeDisplayed();
        Assert.assertTrue(isCentralIframeDisplayed);

        homePage.goToCentralIframe();
        boolean isEpamLogoInFrameDisplayed = homePage.isEpamLogoDisplayed();

        Assert.assertTrue(isEpamLogoInFrameDisplayed);


        homePage.getBackFromIframeToMainSite();

        boolean isJdiHeaderDisplayed = homePage
                .isJdiHeaderDisplayed();
        Assert.assertTrue(isJdiHeaderDisplayed);

        boolean leftSectionDisplayed = homePage
                .isLeftSectionDisplayed();

        Assert.assertTrue(leftSectionDisplayed);
    }

}
