package com.automation.pages.web;

import com.automation.pages.interfaces.ProductListing;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebProductListingPage extends WebBasePage implements ProductListing {

    @FindBy(xpath = "//button[@class=' css-1aucgde']/span[@class='sort-name']")
    WebElement sortBtn;

    @FindBy(xpath = "//div[@class='css-xrzmfa']")
    List<WebElement> productTitles;

    @Override
    public boolean isProductListingPageDisplayed() {
        return isElementPresent(sortBtn);
    }

    @Override
    public void clickOnFilterTab(){
//  This is implemented in the Android Application
    }
    public boolean verifyFiltersApplied(){
        for(WebElement productTitle:productTitles){
            if(!(productTitle.equals("Ponds")||productTitle.equals("Adhyay")))
                return false;
        }
        return true;
    }
}
