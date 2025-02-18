package com.automation.steps;

import com.automation.pages.mobile.AndroidHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {

    @Then("verify user is successfully logged in")
    public void verifyUserIsSuccessfullyLoggedIn() {
        Assert.assertTrue(homePage.verifyUserSuccessfullyLoggedIn());
    }

    @And("verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user search for product {string}")
    public void userSearchForProduct(String productName) {
        homePage.userSearchProduct(ConfigReader.getConfigValue(productName));
    }


    @When("user search for products {string}")
    public void userSearchForProducts(String productsName) {
        homePage.userSearchProduct(productsName);
    }
}
