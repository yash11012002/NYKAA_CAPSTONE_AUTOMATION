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

    @When("the user selects the size of a product")
    public void theUserSelectsTheSizeOfAProduct() {
        itemDetailsPage.selectProductSize();
    }

    @And("the user adds {int} the item to the cart")
    public void theUserAddsTheItemToTheCart(int arg0) {
        itemDetailsPage.userAddsProductInCart();
    }

    @Then("the system verifies that the item was successfully added to the cart")
    public void theSystemVerifiesThatTheItemWasSuccessfullyAddedToTheCart() {
        Assert.assertEquals(itemDetailsPage.verifyItemAddedInCart(),1);

    }

    @When("the user clicks on the cart icon")
    public void theUserClicksOnTheCartIcon() {
        itemDetailsPage.userClicsOnCartIcon();
    }
}
