package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps extends BaseSteps {

    @And("the user sets the quantity")
    public void theUserSetsTheQuantity() {
        cartPage.setQuantity();
    }

    @Then("the system verifies that the correct quantity is displayed")
    public void theSystemVerifiesThatTheCorrectQuantityIsDisplayed() {
        int expectedQuantity = ConfigReader.getConfigIntValue("expected.qty");
        Assert.assertTrue(cartPage.verifyCorrectQuantityIsDisplayed(3));

    }

    @When("the user checks for available coupons and bank offers")
    public void theUserChecksForAvailableCouponsAndBankOffers() {
        cartPage.userClicksOnBankAndCouponsSection();
    }

    @And("the user clicks on the price details icon")
    public void theUserClicksOnThePriceDetailsIcon() {
        cartPage.userClicksOnPriceDetailsIcon();
    }

    @Then("the system verifies the applied offer discount")
    public void theSystemVerifiesTheAppliedOfferDiscount() {
    Assert.assertTrue(cartPage.verifyPriceDetails());

    }

    @And("the user proceeds to the payment section")
    public void theUserProceedsToThePaymentSection() {
        cartPage.userClicksOnProceedToPay();
    }
}
