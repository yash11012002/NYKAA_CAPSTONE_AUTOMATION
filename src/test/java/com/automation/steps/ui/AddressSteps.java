package com.automation.steps.ui;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddressSteps extends BaseSteps{


    @Then("verify that the user is on the addresses page")
    public void verifyThatTheUserIsOnTheAddressesPage() {
        Assert.assertTrue(addressPage.verifyIsAddressPageIsDisplayed());
    }

    @When("user adds new address")
    public void userAddsNewAddress() {
        addressPage.userCliksOnAddNewAddress();
        addressPage.userFillAddressDetails(ConfigReader.getConfigValue("pincode"), ConfigReader.getConfigValue("houseName"),ConfigReader.getConfigValue("colonyName"),ConfigReader.getConfigValue("name"));
    }

    @Then("verify address added successfully")
    public void verifyAddressAddedSuccessfully() {
        Assert.assertTrue(addressPage.verifyAddressSuccessfullyAdded());
    }
}
//String pincode,String houseName,String colonyName,String name, String phoneNumber