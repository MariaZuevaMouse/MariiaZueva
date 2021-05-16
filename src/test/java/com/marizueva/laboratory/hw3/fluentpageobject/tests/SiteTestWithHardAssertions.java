package com.marizueva.laboratory.hw3.fluentpageobject.tests;

import com.marizueva.laboratory.hw3.fluentpageobject.pages.HeaderItems;
import com.marizueva.laboratory.hw3.fluentpageobject.pages.HomePage;
import com.marizueva.laboratory.hw3.testdata.UsedInTestTerms;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SiteTestWithHardAssertions extends BaseTest {

    @Test
    public void testBrowserTitleForHome() {
        homePage = new HomePage(driver)
                .openSite();
        Assert.assertEquals(driver.getTitle(), homePageTitle);

        String loggedUserName = new HomePage(driver)
                .openSite()
                .performLogin(userName, password)
                .getLoggedUserName();

        Assert.assertEquals(loggedUserName, loggedUser);


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


        boolean benefitText1 = homePage.isBenefitTextDisplayed(1);
        Assert.assertTrue(benefitText1);

        boolean benefitText2 = homePage.isBenefitTextDisplayed(2);
        Assert.assertTrue(benefitText2);

        boolean benefitText3 = homePage.isBenefitTextDisplayed(3);
        Assert.assertTrue(benefitText3);

        boolean benefitText4 = homePage.isBenefitTextDisplayed(4);
        Assert.assertTrue(benefitText4);


        WebElement mainHeaderEpamWishes = homePage
                .getMainHeaderEpamWishes();
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


        boolean isEpamLogoInFrameDisplayed = homePage
                .goToCentralIframe()
                .isEpamLogoDisplayed();

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
