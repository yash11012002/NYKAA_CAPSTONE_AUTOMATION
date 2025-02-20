package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OfferSteps extends BaseSteps{


    @Then("the system verifies that the offer page is displayed")
    public void theSystemVerifiesThatTheOfferPageIsDisplayed() {
        Assert.assertTrue(offerPage.verifyIsOfferPageIsDisplayed());
    }

    @And("the system collects valid offers for the user")
    public void theSystemCollectsValidOffersForTheUser() {
        offerPage.userApplyCouponsOffers();
    }

    @When("the user clicks on view bag")
    public void theUserClicksOnViewBag() {
        offerPage.userClicksViewBag();
    }


}
