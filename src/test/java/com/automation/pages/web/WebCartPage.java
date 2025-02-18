package com.automation.pages.web;

import com.automation.pages.interfaces.CartPage;

public class WebCartPage extends WebBasePage implements CartPage {

    @Override
    public void setQuantity() {

    }
    @Override
    public boolean verifyCorrectQuantityIsDisplayed(int expectedItemQty) {
        return true;
    }

    @Override
    public void userClicksOnBankAndCouponsSection() {
    }

    @Override
    public void userClicksOnPriceDetailsIcon() {
    }

    @Override
    public boolean verifyPriceDetails() {
        return true;
    }

    @Override
    public void userClicksOnProceedToPay() {

    }
}
