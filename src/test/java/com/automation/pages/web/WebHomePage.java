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

    @FindBy(xpath = "//span[@class='css-lg5xc9']")
    List<WebElement> outOfStockProducts;

    @FindBy(xpath = "//span[@class='css-lg5xc9']/../../..//button[@class='fill-bg css-j1ays8']")
    WebElement notifyBtn;

    @FindBy(xpath = "//form[@class='css-1j7pnn7']/input[@placeholder='Your Email' and @class='input']\n")
    WebElement notifyEmail;

    @FindBy(xpath = "//div[@class=\"css-vwa1e2\"]//button[@type='submit']")
    WebElement proceedBtn;

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
    public boolean isProductOutOfStock() {
        return (!outOfStockProducts.isEmpty());
    }

    @Override
    public void clickOnNotifyBtn() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='css-lg5xc9']/../../.."))).perform();
        notifyBtn.click();
    }

    @Override
    public void proceedForNotify() {
        notifyEmail.sendKeys("abc@gmail.com");
        proceedBtn.click();
    }

    @Override
    public boolean isAlertMsgDisplayed() {
        return driver.findElement(By.xpath("//div[@class='body' and contains(text(),\"subscribed\")]")).isDisplayed();
    }
}
