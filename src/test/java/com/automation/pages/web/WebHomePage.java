package com.automation.pages.web;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebHomePage extends WebBasePage implements HomePage {

    @FindBy(xpath = "//span[@class='css-17ukzrr euw1lbv4']")
    WebElement userName;

    @FindBy(id = "category_navigation")
    WebElement navigationBar;

    @FindBy(xpath = "//input[@name='search-suggestions-nykaa']")
    WebElement searchInput;

    @FindBy(xpath = "//a//span[@class='ts-text' and contains(text(),'Store')]")
    WebElement storeAndEvents;

    @FindBy(xpath = "//span[@class='ts-text' and contains(text(),'Gift')]")
    WebElement giftCardTab;

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

    @Override
    public void clickOnStoreAndEventsBtn() {
        storeAndEvents.click();
    }

    @Override
    public void clickOnGiftCardTab() {
        giftCardTab.click();
    }

    @Override
    public void userClicksOnCategoryTab(){
    }


}
