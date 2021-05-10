package com.marizueva.laboratory.hw5.steps;

import com.marizueva.laboratory.hw5.context.TestContext;
import com.marizueva.laboratory.hw5.pages.CommonPage;
import com.marizueva.laboratory.hw5.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStep {

    @Given("I open JDI GitHub site")
    public void openJdiGithubSite() {
        new HomePage(TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER)).openSite();

    }

    @Given("I login as user 'Roman Iovlev'")
    public void performLogin() {
        new HomePage(TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER))
                .performLogin();
    }

    @When("I click on {string} button in Header")
    public void clickOnService(String header) {
        new CommonPage(TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER))
                .clickOnServiceFromHeader();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickDifferentElementFromHeaderService(String serviceSubCategory) {
        new CommonPage(TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER))
                .goToServiceSubMenuFromHeader(serviceSubCategory);
    }
}
