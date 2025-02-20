package com.automation.pages.web;

import com.automation.pages.interfaces.ProductListing;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebProductListingPage extends WebBasePage implements ProductListing {

    @FindBy(xpath = "//button[@class=' css-1aucgde']/span[@class='sort-name']")
    WebElement sortBtn;

    List<WebElement> productTitles;

    @FindBy(xpath = "//span[@class='css-lg5xc9']")
    List<WebElement> outOfStockProducts;

    @FindBy(xpath = "//span[@class='css-lg5xc9']/../../..//button[@class='fill-bg css-j1ays8']")
    WebElement notifyBtn;

    @FindBy(xpath = "//form[@class='css-1j7pnn7']/input[@placeholder='Your Email' and @class='input']\n")
    WebElement notifyEmail;

    @FindBy(xpath = "//div[@class=\"css-vwa1e2\"]//button[@type='submit']")
    WebElement proceedBtn;

    @FindBy(xpath = "//span[@class='btn-text']")
    WebElement addToBag;

    @FindBy(xpath = "//button[@class='wishlist_button_text css-a66yfw']")
    WebElement addToWishListBtn;


    @Override
    public boolean isProductListingPageDisplayed() {
        return isElementPresent(sortBtn);
    }

    @Override
    public void clickOnFilterTab(){
//  This is implemented in the Android Application
    }
    public boolean verifyFiltersApplied() {
        productTitles = driver.findElements(By.xpath("//div[@class='css-1rd7vky']/div[@class='css-xrzmfa']"));
        System.out.println(productTitles.size());
        for (WebElement productTitle : productTitles) {
            String titleText = productTitle.getText().toLowerCase().replace("'", "");
            System.out.println(titleText);

            if (!((titleText.contains("ponds") || titleText.contains("adhyay")))) {
                Assert.fail("Product does not match filter criteria: " + productTitle.getText());
                return false;
            }
        }
        return true;
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

    @Override
    public void userClickOnFirstProduct() {
        productTitles = driver.findElements(By.xpath("//div[@class='css-1rd7vky']/div[@class='css-xrzmfa']"));
        productTitles.get(0).click();
    }

    @Override
    public void addFirstProductToBag() {
        productTitles = driver.findElements(By.xpath("//div[@class='css-1rd7vky']/div[@class='css-xrzmfa']"));
        actions.moveToElement(productTitles.get(0)).perform();
        addToBag.click();
    }

    @Override
    public boolean isProductAddedToBag() {
        return isElementPresent(driver.findElement(By.xpath("//div[@id='view_bag_snackbar']")));
    }

    @Override
    public void addToWishList() {
        productTitles = driver.findElements(By.xpath("//div[@class='css-1rd7vky']/div[@class='css-xrzmfa']"));
        actions.moveToElement(productTitles.get(0)).perform();
        addToWishListBtn.click();
    }

    @Override
    public boolean isProductAddedToWishList() {
        return isElementPresent(driver.findElement(By.xpath("//div[@class='container active']")));
    }
}
