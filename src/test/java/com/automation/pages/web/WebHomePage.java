package com.automation.pages.web;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(xpath = "//span[@class='css-17ukzrr euw1lbv4']")
    WebElement userName;

    @FindBy(id = "category_navigation")
    WebElement navigationBar;

    @FindBy(xpath = "//input[@name='search-suggestions-nykaa']")
    WebElement searchInput;

    @Override
    public boolean isHomePageDisplayed() {
        return isElementPresent(navigationBar);
    }

    @Override
    public boolean verifyUserSuccessfullyLoggedIn() {
        return isElementPresent(userName);
    }

    @Override
    public void userSearchProduct(String productName) {
        searchInput.sendKeys(productName);
        searchInput.sendKeys(Keys.ENTER);
    }
}
