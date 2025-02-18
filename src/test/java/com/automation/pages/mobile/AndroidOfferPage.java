package com.automation.pages.mobile;

import com.automation.pages.interfaces.OfferPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidOfferPage extends AndroidBasePage implements OfferPage {

    @FindBy(id = "com.fsn.nykaa:id/collectBtn")
    WebElement couponCollectTab;

    @FindBy(id = "com.fsn.nykaa:id/got_it")
    WebElement confirmOffer;

    @FindBy(id = "com.fsn.nykaa:id/cta")
    WebElement viewBag;

    @Override
    public boolean verifyIsOfferPageIsDisplayed(){
        return viewBag.isDisplayed();
    }

    @Override
    public void userApplyCouponsOffers(){
        if(isElementDisplayed(couponCollectTab)){
            couponCollectTab.click();
        }
        confirmOffer.click();
    }
    @Override
    public void userClicksViewBag(){
        viewBag.click();
    }
}
