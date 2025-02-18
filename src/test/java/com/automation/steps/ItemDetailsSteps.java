package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ItemDetailsSteps extends BaseSteps {


    @Then("verify item details page is displayed")
    public void verifyItemDetailsPageIsDisplayed() {
        Assert.assertTrue(itemDetailsPage.verifyItemsDetailsPageIsDisplayed());
    }

    @And("user clicks on the product image")
    public void userClicksOnTheProductImage() {
        itemDetailsPage.userClicksOnProductImage();
    }

    @And("user performs zoom functionality")
    public void userPerformsZoomFunctionality() {
        itemDetailsPage.userPerformZoomFunctionality();
    }


    @When("user swipes left on the product image")
    public void userSwipesLeftOnTheProductImage() {
        itemDetailsPage.userPerformSwipeFunctionality();
    }

    @When("user clicks on the Change Delivery Address option")
    public void userClicksOnTheChangeDeliveryAddressOption() {
        itemDetailsPage.userChangeDeliveryAddress();
    }

    @And("set new pincode {string}")
    public void setNewPincode(String pincode) {
        itemDetailsPage.userSetsPincode(ConfigReader.getConfigValue(pincode));
    }
}
