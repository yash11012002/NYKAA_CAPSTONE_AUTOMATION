package com.automation.pages.interfaces;

public interface ProductListing {

    boolean isProductListingPageDisplayed();
    void clickOnFilterTab();
    boolean verifyFiltersApplied();
    void userClickOnFirstProduct();
}
