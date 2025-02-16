package com.automation.pages.web;

import com.automation.pages.interfaces.HomePage;

public class WebHomePage extends WebBasePage implements HomePage {

    @Override
    public boolean isHomePageDisplayed() {
        return true;
    }

    @Override
    public boolean verifyUserSuccessfullyLoggedIn() {
        return true;
    }
}
