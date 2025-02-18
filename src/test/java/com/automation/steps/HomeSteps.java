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

    @When("user checks for out-of-stock products")
    public void userChecksForOutOfStockProducts() {
        Assert.assertTrue(homePage.isProductOutOfStock());
    }

    @And("user clicks on the notify button")
    public void userClicksOnTheNotifyButton() {
        homePage.clickOnNotifyBtn();
    }

    @When("user enters the email address and clicks on the proceed button")
    public void userEntersTheEmailAddressAndClicksOnTheProceedButton() {
        homePage.proceedForNotify();
    }

    @Then("verify alert message is displayed")
    public void verifyAlertMessageIsDisplayed() {
        Assert.assertTrue(homePage.isAlertMsgDisplayed());
    }
}
