package com.automation.steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProfileSteps extends BaseSteps{

    @Then("verify that the user is on the profile page")
    public void verifyThatTheUserIsOnTheProfilePage() {
        Assert.assertTrue(profilePage.isProfilePageDisplayed());
    }


    @When("user changes the personal details")
    public void userChangesThePersonalDetails() {
        profilePage.changeAddress();
    }

    @And("user clicks on save details")
    public void userClicksOnSaveDetails() {
        profilePage.saveDetails();
    }

    @Then("verify that the personal details are updated")
    public void verifyThatThePersonalDetailsAreUpdated() {
        Assert.assertTrue(profilePage.isUpdatesVisible());
    }
}
