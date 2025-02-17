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
    public BaseSteps() {
        if (ConfigReader.getConfigValue("platform").equals("web")) {
            loginPage = new WebLoginPage();
            homePage = new WebHomePage();
            productListing=new WebProductListingPage();
            filterPage=new WebFilterPage();
            itemDetailsPage=new WebItemDetailsPage();
        } else {
            loginPage = new AndroidLoginPage();
            homePage = new AndroidHomePage();
            productListing=new AndroidProductListingPage();
            filterPage=new AndroidFilterPage();
            itemDetailsPage=new AndroidItemDetailsPage();
        }
    }
}
