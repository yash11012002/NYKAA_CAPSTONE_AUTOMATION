package com.automation.steps;

import com.automation.pages.interfaces.ProductListing;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductListingSteps extends BaseSteps {

    @Then("verify product listing page is displayed")
    public void verifyProductListingPageIsDisplayed() {
        Assert.assertTrue(productListing.isProductListingPageDisplayed());
    }
    
    @When("user click on filter tab")
    public void userClickOnFilterTab() {
        productListing.clickOnFilterTab();
    }

    @Then("verify filters are applied correctly")
    public void verifyFiltersAreAppliedCorrectly() {
        Assert.assertTrue(productListing.verifyFiltersApplied());
    }

    @When("user selects the first product")
    public void userSelectsTheFirstProduct() {
        productListing.userClickOnFirstProduct();
    }

    @When("user checks for out-of-stock products")
    public void userChecksForOutOfStockProducts() {
        Assert.assertTrue(productListing.isProductOutOfStock());
    }

    @And("user clicks on the notify button")
    public void userClicksOnTheNotifyButton() {
        productListing.clickOnNotifyBtn();
    }

    @When("user enters the email address and clicks on the proceed button")
    public void userEntersTheEmailAddressAndClicksOnTheProceedButton() {
        productListing.proceedForNotify();
    }

    @Then("verify alert message is displayed")
    public void verifyAlertMessageIsDisplayed() {
        Assert.assertTrue(productListing.isAlertMsgDisplayed());
    }



}
