package com.automation.pages.web;

import com.automation.pages.interfaces.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.zh_cn.但是;

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

    @Override
    public boolean isProductPresentInCart() {
       return true;
    }

    @Override
    public boolean verifyCorrectOrderAddedInCart() {
        return true;
    }
}
