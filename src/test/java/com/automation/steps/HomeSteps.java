package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {

    @Then("verify user is successfully logged in")
    public void verifyUserIsSuccessfullyLoggedIn() {
        Assert.assertTrue(homePage.verifyUserSuccessfullyLoggedIn());
    }

    @And("verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user search for product {string}")
    public void userSearchForProduct(String productName) {
        homePage.userSearchProduct(ConfigReader.getConfigValue(productName));
    }


    @When("user clicks on store locator tab")
    public void userClicksOnStoreLocatorTab() {
        homePage.clickOnStoreAndEventsBtn();
    }

    @When("user clicks on gift card tab")
    public void userClicksOnGiftCardTab() {
        homePage.clickOnGiftCardTab();
    }


    @And("user clicks on categories tab")
    public void userClicksOnCategoriesTab() {
        homePage.userClicksOnCategoryTab();
    }
}
