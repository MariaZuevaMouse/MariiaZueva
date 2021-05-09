package com.marizueva.laboratory.hw5.steps;

import com.marizueva.laboratory.hw5.pages.CommonPage;
import com.marizueva.laboratory.hw5.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStep {

    @Given("I open JDI GitHub site")
    public void openJdiGithubSite() {
        new HomePage("").openSite();

    }
    @Given("I login as user 'Roman Iovlev'")
    public void performLogin() {
        new HomePage("").performLogin();
    }

    @When("I click on {string} button in Header")
    public void clickOnService(String header) {
        new CommonPage("").clickOnServiceFromHeader();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickDifferentElementFromHeaderService(String serviceSubCategory) {
        new CommonPage("").goToSubMenuFromHeader(serviceSubCategory);
    }
}
