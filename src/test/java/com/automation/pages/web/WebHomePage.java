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

    @FindBy(id = "header-bag-icon")
    WebElement bagIcon;


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

    @Override
    public void clickOnProfileSection() {
        actions.moveToElement(userName).perform();
        WebElement profileLink = driver.findElement(By.xpath("//li[@class='list-item']/a[contains(text(),'Profile')]"));
        actions.moveToElement(profileLink).click().perform();
    }

    @Override
    public void clickOnBagIcon() {
        bagIcon.click();
    }

    @Override
    public void openWishListTab() {
        actions.moveToElement(userName).perform();
        WebElement wishListLink = driver.findElement(By.xpath("//li[@class='list-item']/a[contains(text(),'Wishlist')]"));
        actions.moveToElement(wishListLink).click().perform();
    }

    @Override
    public void clickOnLogOutBtn() {
        System.out.println("here");
        actions.moveToElement(userName).perform();
        WebElement wishListLink = driver.findElement(By.xpath("//button[@class='link css-5wdy92 e4p5vsu0']"));
        actions.moveToElement(wishListLink).click().perform();
        driver.findElement(By.xpath("//span[@class='css-1yxjd9r' and text()='Logout']")).click();
    }


}
