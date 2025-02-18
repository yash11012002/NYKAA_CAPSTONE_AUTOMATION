package com.automation.pages.interfaces;

public interface CartPage {

    void setQuantity();
    boolean verifyCorrectQuantityIsDisplayed(int expectedItemQty);
    void userClicksOnBankAndCouponsSection();
    void userClicksOnPriceDetailsIcon();
    boolean verifyPriceDetails();
    void userClicksOnProceedToPay();
}
