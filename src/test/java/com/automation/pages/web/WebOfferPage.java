package com.automation.pages.web;

import com.automation.pages.interfaces.OfferPage;

public class WebOfferPage extends  WebBasePage implements OfferPage {

    @Override
    public void userApplyCouponsOffers(){

    }
    @Override
    public void userClicksViewBag(){
    }

    @Override
    public boolean verifyIsOfferPageIsDisplayed(){
        //will do something
        driver.navigate().back();
        return true;
    }
}
