package com.marizueva.laboratory.hw5.steps;

import com.marizueva.laboratory.hw5.context.TestContext;
import com.marizueva.laboratory.hw5.pages.Checkboxes;
import com.marizueva.laboratory.hw5.pages.DifferentElementPage;
import com.marizueva.laboratory.hw5.utils.UsedInTestTerms;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class JdiSiteDifferentElementPageSteps {
    DifferentElementPage differentElementPage;

    {
        differentElementPage = new DifferentElementPage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
    }

    @When("I select {string} checkbox")
    public void selectWaterCheckbox(String checkbox) {
        differentElementPage
                .clickCheckbox(checkbox);
        updateLogList();
    }



    @When("I select Selen radio")
    public void selectRadioSelen() {
        differentElementPage
                .chooseRadioSelen();

        updateLogList();
    }

    @When("I select Yellow in color dropdown")
    public void selectYellowDropdown() {
        differentElementPage
                .chooseYellowDropdown();

        updateLogList();
    }

    @Then("separate log for Water checkbox in log section with true status")
    public void checkboxWaterInTrueStatus() {
        List<String> expectedLogs = TestContext.getInstance()
                .getTestObject(TestContext.ALL_LOGS_FROM_DIFFERENT_ELEMENT_PAGE);

        List<WebElement> actualLogs = differentElementPage
                .getAllLogs();
        List<String> actualLogsInStringFormat = allLogsWithoutDate(actualLogs);

        assertTrue(expectedLogs.containsAll(actualLogsInStringFormat));
        assertTrue(actualLogsInStringFormat.contains(UsedInTestTerms.diffElWaterTrueLog));
    }

    @Then("separate log for Wind checkbox in log section with true status")
    public void checkboxWindInTrueStatus() {
        List<String> expectedLogs = TestContext.getInstance()
                .getTestObject(TestContext.ALL_LOGS_FROM_DIFFERENT_ELEMENT_PAGE);

        List<WebElement> actualLogs = differentElementPage
                .getAllLogs();
        List<String> actualLogsInStringFormat = allLogsWithoutDate(actualLogs);

        assertTrue(expectedLogs.containsAll(actualLogsInStringFormat));
        assertTrue(actualLogsInStringFormat.contains(UsedInTestTerms.diffElWindTrueLog));
    }

    @Then("separate log for Selen radio in log section with true status")
    public void radioSelenInTrueStatus() {
        List<String> expectedLogs = TestContext.getInstance()
                .getTestObject(TestContext.ALL_LOGS_FROM_DIFFERENT_ELEMENT_PAGE);

        List<WebElement> actualLogs = differentElementPage
                .getAllLogs();
        List<String> actualLogsInStringFormat = allLogsWithoutDate(actualLogs);


        System.out.println(expectedLogs.toString());
        System.out.println(actualLogsInStringFormat.toString());
        assertTrue(expectedLogs.containsAll(actualLogsInStringFormat));
        assertTrue(actualLogsInStringFormat.contains(UsedInTestTerms.diffElChosenSelenLog));
    }

    @Then("separate log for Yellow dropdown in log section with true status")
    public void yellowDropdownInTrueStatus() {
        List<String> expectedLogs = TestContext.getInstance().getTestObject(TestContext
                .ALL_LOGS_FROM_DIFFERENT_ELEMENT_PAGE);

        List<WebElement> actualLogs = differentElementPage
                .getAllLogs();
        List<String> actualLogsInStringFormat = allLogsWithoutDate(actualLogs);

        assertTrue(expectedLogs.containsAll(actualLogsInStringFormat));
        assertTrue(actualLogsInStringFormat.contains(UsedInTestTerms
                .diffElDropdownYellowLogInTrue));
    }

    private void updateLogList() {
        List<WebElement> allLogs = differentElementPage
                .getAllLogs();

        List<String> allLogsString = allLogsWithoutDate(allLogs);

        TestContext.getInstance().setTestObject(TestContext
                .ALL_LOGS_FROM_DIFFERENT_ELEMENT_PAGE, allLogsString);
    }

    private List<String> allLogsWithoutDate(List<WebElement> fullLogs) {
        List<String> logsWithoutDate =
                fullLogs.stream()
                        .map(WebElement::getText)
                        .map(e -> e.substring(9))
                        .collect(Collectors.toList());
        return logsWithoutDate;
    }
}
