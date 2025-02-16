package com.automation.steps;

import com.automation.pages.interfaces.FilterPage;
import com.automation.pages.interfaces.HomePage;
import com.automation.pages.interfaces.LoginPage;
import com.automation.pages.interfaces.ProductListing;
import com.automation.pages.mobile.AndroidFilterPage;
import com.automation.pages.mobile.AndroidHomePage;
import com.automation.pages.mobile.AndroidLoginPage;
import com.automation.pages.mobile.AndroidProductListingPage;
import com.automation.pages.web.WebFilterPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebLoginPage;
import com.automation.pages.web.WebProductListingPage;
import com.automation.utils.ConfigReader;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    ProductListing productListing;
    FilterPage filterPage;

    public BaseSteps() {
        if (ConfigReader.getConfigValue("platform").equals("web")) {
            loginPage = new WebLoginPage();
            homePage = new WebHomePage();
            productListing=new WebProductListingPage();
            filterPage=new WebFilterPage();
        } else {
            loginPage = new AndroidLoginPage();
            homePage = new AndroidHomePage();
            productListing=new AndroidProductListingPage();
            filterPage=new AndroidFilterPage();
        }
    }
}
