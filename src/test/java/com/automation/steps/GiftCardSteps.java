package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GiftCardSteps extends BaseSteps{

    @When("user selects a particular gift card")
    public void userSelectsAParticularGiftCard() {
        giftCardPage.selectParticularGiftCard();
    }


    @Then("verify user is on gift card page")
    public void verifyUserIsOnGiftCardPage() {
        Assert.assertTrue((giftCardPage.isGiftCardPageDisplayed()));
    }

    @And("user enters the details")
    public void userEntersTheDetails() {
        giftCardPage.enterGiftCardDetails();
    }

    @Then("verify user is on payment page")
    public void verifyUserIsOnPaymentPage() {
        Assert.assertTrue(giftCardPage.isPaymentPageDisplayed());
    }
}
