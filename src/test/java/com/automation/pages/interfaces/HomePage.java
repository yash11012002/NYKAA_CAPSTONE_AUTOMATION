package com.automation.pages.interfaces;

public interface HomePage {

    boolean isHomePageDisplayed();

    boolean verifyUserSuccessfullyLoggedIn();

    void userSearchProduct(String productName);

    void clickOnStoreAndEventsBtn();

    void clickOnGiftCardTab();

    void userClicksOnCategoryTab();

    void clickOnProfileSection();

    void clickOnBagIcon();

    void openWishListTab();

    void clickOnLogOutBtn();


}
