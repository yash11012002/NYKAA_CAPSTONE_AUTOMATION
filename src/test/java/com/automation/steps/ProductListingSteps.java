package com.automation.steps;

import com.automation.pages.interfaces.ProductListing;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductListingSteps extends BaseSteps {

    @Then("verify product listing page is displayed")
    public void verifyProductListingPageIsDisplayed() {
        productListing.isProductListingPageIsDisplayed();
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
    }
}
