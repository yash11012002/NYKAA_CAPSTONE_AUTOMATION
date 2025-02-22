package com.automation.steps.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StoreLocatorSteps extends BaseSteps{

    @Then("verify user is on store locator page")
    public void verifyUserIsOnStoreLocatorPage() {
        Assert.assertTrue(storeLocatorPage.isStoreLocatorPageDisplayed());
    }

    @When("user searches city {string} and press search button")
    public void userSearchesCityAndPressSearchButton(String cityName) {
        storeLocatorPage.checkCity(cityName);
    }

    @Then("verify search lists with city name and store in file")
    public void verifySearchListsWithCityNameAndStoreInFile() {
        storeLocatorPage.verifyAndStoreTheResult();
    }
}
