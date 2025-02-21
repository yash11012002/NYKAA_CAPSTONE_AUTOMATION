package com.automation.pages.interfaces;

public interface AddressPage {

     boolean verifyIsAddressPageIsDisplayed();

     void userCliksOnAddNewAddress();

     void userFillAddressDetails(String pincode,String houseName,String colonyName,String name);
     boolean verifyAddressSuccessfullyAdded();
}
