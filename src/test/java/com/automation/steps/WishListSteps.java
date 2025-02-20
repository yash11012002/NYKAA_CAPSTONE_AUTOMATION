package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class WishListSteps extends BaseSteps{

    @And("user deletes the product from the wishlist")
    public void userDeletesTheProductFromTheWishlist() {
        wishListPage.deleteProductFromWishList();
    }

    @Then("verify that the product has been successfully removed from the wishlist")
    public void verifyThatTheProductHasBeenSuccessfullyRemovedFromTheWishlist() {
        Assert.assertTrue(wishListPage.isItemDeleted());
    }
}
