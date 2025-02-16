package com.automation.pages.interfaces;

public interface LoginPage {

    void openApplication();

    boolean verifySignInPageIsDisplayed();

    void doLogin(String phoneNumber);
}
