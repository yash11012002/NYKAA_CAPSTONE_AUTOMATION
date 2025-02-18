package com.automation.pages.web;

import com.automation.pages.interfaces.GiftCardPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebGiftCardPage extends WebBasePage implements GiftCardPage {

    @FindBy(xpath = "//div[contains(text(),'Birthday Wishes')]/../../button")
    WebElement giftCartSelection;

    @FindBy(id = "name")
    WebElement toInput;

    @FindBy(id = "recipientEmail")
    WebElement receiveMobileInput;

    @FindBy(xpath = "//textarea")
    WebElement description;

    @FindBy(xpath = "//input[@placeholder = 'Enter Amount(Max. 10000)']")
    WebElement maxAmount;

    @FindBy(id = "senderName")
    WebElement fromInput;

    @FindBy(id = "senderMobile")
    WebElement fromMobileInput;

    @FindBy(xpath = "//p[@class='subtitle css-1duc8ix eoygcm00']")
    WebElement paymentText;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement proceedToPayBtn;

    @Override
    public void selectParticularGiftCard() {
        giftCartSelection.click();
    }

    @Override
    public boolean isGiftCardPageDisplayed() {
        switchToNewTab();
        pause(2000);
        return isElementPresent(giftCartSelection);
    }

    @Override
    public void enterGiftCardDetails() {
        toInput.sendKeys("Yash");
        receiveMobileInput.sendKeys("8830497023");
        description.sendKeys("Wishing you the Happiest Birthday ever!");
        maxAmount.sendKeys("500");
        fromInput.sendKeys("Vishal");
        fromMobileInput.sendKeys("9980578176");
        proceedToPayBtn.click();
    }

    @Override
    public boolean isPaymentPageDisplayed() {
        return isElementPresent(paymentText);
    }
}
