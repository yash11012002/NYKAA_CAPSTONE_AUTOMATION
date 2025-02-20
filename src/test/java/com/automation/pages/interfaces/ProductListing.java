package com.automation.pages.interfaces;

public interface ProductListing {

    boolean isProductListingPageDisplayed();
    void clickOnFilterTab();
    boolean verifyFiltersApplied();
    void userClickOnFirstProduct();
    boolean isProductOutOfStock();

    void clickOnNotifyBtn();

    void proceedForNotify();

    boolean isAlertMsgDisplayed();

    void addFirstProductToBag();

    boolean isProductAddedToBag();

    void addToWishList();

    boolean isProductAddedToWishList();
}
