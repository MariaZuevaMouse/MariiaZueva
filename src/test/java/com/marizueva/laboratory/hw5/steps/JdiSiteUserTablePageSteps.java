package com.marizueva.laboratory.hw5.steps;

import com.marizueva.laboratory.hw5.context.TestContext;
import com.marizueva.laboratory.hw5.pages.UserTablePage;
import com.marizueva.laboratory.hw5.utils.UsedInTestTerms;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdiSiteUserTablePageSteps {
    UserTablePage userTablePage;

    {
        userTablePage = new UserTablePage(TestContext.getInstance()
                .getTestObject(TestContext.WEB_DRIVER));
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void chooseVipCheckboxForSergeyIvan() {
        userTablePage
                .chooseVipCheckboxForSergeyIvan();
    }

    @Then("1 log row has 'Vip: condition changed to true' text in log section")
    public void vipConditionChangedToTrueLog() {
        List<String> actualAllLogs = userTablePage
                .getAllLogs();

        assertEquals(actualAllLogs.size(), 1);
        assertEquals(actualAllLogs.get(0).substring(9), UsedInTestTerms.userPageVipLog);

    }

    @Then("'User Table' page should be opened")
    public void userTablePageOpened() {
        boolean userTableOpened = userTablePage.isUserTableOpened();

        assertTrue(userTableOpened);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void dropdownQuantityOnUserTablePage(int count) {
        List<WebElement> dropdownItemsOnPage = userTablePage
                .getDropdownItemsOnPage();

        assertEquals(dropdownItemsOnPage.size(), count);

    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernameQuantityOnUserTablePage(int count) {
        List<WebElement> allUserNames = userTablePage
                .getAllUserNamesInTable();

        assertEquals(allUserNames.size(), count);
    }

    @Then("{int} Description texts under images should"
            + " be displayed on Users Table on User Table Page")
    public void descriptionQuantityOnUserTablePage(int count) {
        List<WebElement> allUserDescriptions = userTablePage
                .getAllUserDescriptions();

        assertEquals(allUserDescriptions.size(), count);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesQuantityOnUserTablePage(int count) {
        List<WebElement> allCheckboxes = userTablePage
                .getAllCheckboxes();

        assertEquals(allCheckboxes.size(), count);
    }

    @Then("User table should contain following values:")
    public void listOfUsersOnUserTablePage(DataTable table) {
        List<List<String>> tableValues = table.asLists();
        List<String> firstNumberColumn = new ArrayList<>();
        List<String> secondUserColumn = new ArrayList<>();
        List<String> thirdDescColumn = new ArrayList<>();
        for (int i = 1; i < tableValues.size(); i++) {
            firstNumberColumn.add((tableValues.get(i).get(0)));
            secondUserColumn.add((tableValues.get(i).get(1)));
            thirdDescColumn.add((tableValues.get(i).get(2)));
        }

        assertEquals(firstNumberColumn, userTablePage.getAllNumbersInTableAsString());
        assertEquals(secondUserColumn, userTablePage.getAllUsersInTableAsString());
        assertEquals(thirdDescColumn, userTablePage.getAllDescriptionInTableAsString());

    }

    @Then("droplist should contain values in column Type for user Roman")
    public void dropdownValuesOnUserTablePage(DataTable table) {
        List<String> actualDropboxValues =  table.asList();
        actualDropboxValues =
                new ArrayList<>(actualDropboxValues.subList(1, actualDropboxValues.size()));

        assertEquals(actualDropboxValues, userTablePage.getAllDropdownValuesAsString());
    }
}
