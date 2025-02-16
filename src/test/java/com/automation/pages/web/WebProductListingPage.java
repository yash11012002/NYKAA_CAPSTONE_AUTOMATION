package com.automation.pages.web;

import com.automation.pages.interfaces.ProductListing;

public class WebProductListingPage extends WebBasePage implements ProductListing {

    @Override
    public boolean isProductListingPageIsDisplayed() {
        return true;
    }

    @Override
    public void clickOnFilterTab(){

    }
    public boolean verifyFiltersApplied(){
        return true;
    }
}
