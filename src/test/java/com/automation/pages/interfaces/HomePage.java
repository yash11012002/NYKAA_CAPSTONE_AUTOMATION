package com.automation.pages.interfaces;

public interface HomePage {

    boolean isHomePageDisplayed();

    boolean verifyUserSuccessfullyLoggedIn();

    void userSearchProduct(String productName);
    void clickOnStoreAndEventsBtn();
}
