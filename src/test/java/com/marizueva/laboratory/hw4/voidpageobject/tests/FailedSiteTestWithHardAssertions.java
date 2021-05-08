package com.marizueva.laboratory.hw4.voidpageobject.tests;

import com.marizueva.laboratory.hw4.testdata.UsedInTestTerms;
import com.marizueva.laboratory.hw4.voidpageobject.pages.HeaderItems;
import com.marizueva.laboratory.hw4.voidpageobject.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedSiteTestWithHardAssertions extends BaseTest {

    @Test
    public void testBrowserTitleForHome() {
        homePage = new HomePage(driver);
        homePage.openSite();
        Assert.assertEquals(driver.getTitle(), homePageTitle);


        homePage.performLogin(userName, password);
        String loggedUserName = homePage.getLoggedUserName();

        Assert.assertEquals(loggedUserName, "ROMAN IOVLEVvv");


        String headerItemHome = homePage.getHeaderItem(HeaderItems.HOME);
        Assert.assertEquals(headerItemHome, HeaderItems.HOME.getRequestedTabText());

        String headerItemContactForm = homePage.getHeaderItem(HeaderItems.CONTACT_FORM);
        Assert.assertEquals(headerItemContactForm, HeaderItems.CONTACT_FORM.getRequestedTabText());

        String headerItemService = homePage.getHeaderItem(HeaderItems.SERVICE);
        Assert.assertEquals(headerItemService, HeaderItems.SERVICE.getRequestedTabText());

        String headerItemMetalAndColors = homePage.getHeaderItem(HeaderItems.METAL_AND_COLORS);
        Assert.assertEquals(headerItemMetalAndColors,
                HeaderItems.METAL_AND_COLORS.getRequestedTabText());


        boolean benefitIcon1 = homePage.isBenefitIconDisplayed(1);
        Assert.assertTrue(benefitIcon1);

        boolean benefitIcon2 = homePage.isBenefitIconDisplayed(2);
        Assert.assertTrue(benefitIcon2);

        boolean benefitIcon3 = homePage.isBenefitIconDisplayed(3);
        Assert.assertTrue(benefitIcon3);

        boolean benefitIcon4 = homePage.isBenefitIconDisplayed(4);
        Assert.assertTrue(benefitIcon4);


        boolean benefitText1 = homePage.checkBenefitTextIsDisplayed(1);
        Assert.assertTrue(benefitText1);

        boolean benefitText2 = homePage.checkBenefitTextIsDisplayed(1);
        Assert.assertTrue(benefitText2);

        boolean benefitText3 = homePage.checkBenefitTextIsDisplayed(1);
        Assert.assertTrue(benefitText3);

        boolean benefitText4 = homePage.checkBenefitTextIsDisplayed(1);
        Assert.assertTrue(benefitText4);


        WebElement mainHeaderEpamWishes = homePage.getMainHeaderEpamWishes();
        Assert.assertTrue(mainHeaderEpamWishes.isDisplayed());
        Assert.assertEquals(mainHeaderEpamWishes.getText().substring(0, 21),
            UsedInTestTerms.homeEpamFrameworkTitle);

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
