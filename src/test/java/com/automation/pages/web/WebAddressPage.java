package com.automation.pages.web;

import com.automation.pages.interfaces.AddressPage;

public class WebAddressPage extends WebBasePage implements AddressPage {

    @Override
    public boolean verifyIsAddressPageIsDisplayed() {
        return true;
    }

    @Override
    public void userCliksOnAddNewAddress() {

    }
    @Override
    public void userFillAddressDetails(String pincode,String houseName,String colonyName,String name){

    }

    @Override
    public boolean verifyAddressSuccessfullyAdded(){
        return true;
    }
}
