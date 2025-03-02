package com.automation.steps.ui;

import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginSteps extends BaseSteps {

    @Given("user opens application")
    public void userOpensApplication() {
        loginPage.openApplication();
    }

    @Then("verify user is on sign-in page")
    public void verifyUserIsOnSignInPage() {
        Assert.assertTrue(loginPage.verifySignInPageIsDisplayed());
    }

    @When("user enters mobile number as {string}")
    public void userEntersMobileNumberAs(String phoneNumber) {
        loginPage.doLogin(ConfigReader.getConfigValue(phoneNumber));
    }

    @Then("verify user successfully logged out")
    public void verifyUserSuccessfullyLoggedOut() {
        Assert.assertTrue(loginPage.verifySignInPageIsDisplayed());
    }

    @When("user skips sign in")
    public void userSkipsSignIn() {
        loginPage.userSkipsSignIn();
    }


}
