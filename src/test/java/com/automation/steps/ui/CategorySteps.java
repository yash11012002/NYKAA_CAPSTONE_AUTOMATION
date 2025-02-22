package com.automation.steps.ui;

import io.cucumber.java.en.When;

public class CategorySteps extends BaseSteps{

    @When("user clicks on bestseller tab")
    public void userClicksOnBestsellerTab() {
        categoryPage.clickOnBestSeller();
    }
}
