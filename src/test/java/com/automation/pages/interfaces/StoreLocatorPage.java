package com.automation.pages.interfaces;

public interface StoreLocatorPage {
    boolean isStoreLocatorPageDisplayed();

    void checkCity(String cityName);

    void verifyAndStoreTheResult();
}
