package com.automation.pages.web;

import com.automation.pages.interfaces.FilterPage;

public class WebFilterPage extends WebBasePage implements FilterPage {

    @Override
    public boolean isFilterPageIsDisplayed(){
        return true;
    }
    @Override
    public void userApplyFilters(){

    }
}
