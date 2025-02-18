package com.automation.pages.web;

import com.automation.pages.interfaces.ProductListing;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebProductListingPage extends WebBasePage implements ProductListing {

    @FindBy(xpath = "//button[@class=' css-1aucgde']/span[@class='sort-name']")
    WebElement sortBtn;

    List<WebElement> productTitles;

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
    public void userClickOnFirstProduct() {

    }
}
