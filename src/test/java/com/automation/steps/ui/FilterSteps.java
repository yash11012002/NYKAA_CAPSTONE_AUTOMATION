package com.automation.steps.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FilterSteps extends BaseSteps{

    @Then("verify filter page is displayed")
    public void verifyFilterPageIsDisplayed() {
        Assert.assertTrue(filterPage.isFilterPageIsDisplayed());
    }

    @When("user applies selected filters")
    public void userAppliesSelectedFilters() {
        filterPage.userApplyFilters();
    }

    @When("user applies multiple filters")
    public void userAppliesMultipleFilters() {
    }


}
