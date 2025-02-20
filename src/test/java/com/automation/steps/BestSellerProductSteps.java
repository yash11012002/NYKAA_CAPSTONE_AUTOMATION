package com.automation.steps;

import io.cucumber.java.en.And;

public class BestSellerProductSteps extends BaseSteps{

    @And("extract all store information in text file")
    public void extractAllStoreInformationInTextFile() {
        bestSellerProductPage.getBestSellerProductTab();
    }

    @And("apply some filter")
    public void applySomeFilter() {
        bestSellerProductPage.userApplySomeFilter();
    }
}
