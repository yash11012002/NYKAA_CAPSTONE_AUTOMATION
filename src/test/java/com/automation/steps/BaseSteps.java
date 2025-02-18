package com.automation.steps;

import com.automation.pages.interfaces.*;
import com.automation.pages.mobile.*;
import com.automation.pages.web.*;
import com.automation.utils.ConfigReader;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    ProductListing productListing;
    FilterPage filterPage;
    ItemDetailsPage itemDetailsPage;
    StoreLocatorPage storeLocatorPage;
    CartPage cartPage;
    OfferPage offerPage;
    GiftCardPage giftCardPage;

    public BaseSteps() {
        if (ConfigReader.getConfigValue("platform").equals("web")) {
            loginPage = new WebLoginPage();
            homePage = new WebHomePage();
            productListing=new WebProductListingPage();
            filterPage=new WebFilterPage();
            itemDetailsPage=new WebItemDetailsPage();
            storeLocatorPage = new WebStoreLocatorPage();
            cartPage=new WebCartPage();
            offerPage=new WebOfferPage();
            giftCardPage = new WebGiftCardPage();

        } else {
            loginPage = new AndroidLoginPage();
            homePage = new AndroidHomePage();
            productListing=new AndroidProductListingPage();
            filterPage=new AndroidFilterPage();
            itemDetailsPage=new AndroidItemDetailsPage();
            storeLocatorPage= new AndroidStoreLocatorPage();
            cartPage=new AndroidCartPage();
            offerPage=new AndroidOfferPage();
            giftCardPage = new AndroidGiftCardPage();
        }
    }
}
