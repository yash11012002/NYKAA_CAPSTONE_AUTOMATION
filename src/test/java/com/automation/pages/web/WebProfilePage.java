package com.automation.pages.web;

import com.automation.pages.interfaces.ProfilePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebProfilePage extends WebBasePage implements ProfilePage {


    @FindBy(xpath = "//a[@class='name' and contains(text(),'My Profile')]")
    WebElement profileElement;

    @FindBy(xpath = "//div[@class='css-13a34fv' and contains(text(),'ADD')]")
    WebElement addNewAddressBtn;

    @FindBy(xpath = "//input[@label='Name']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@label='Mobile Number']")
    WebElement mobileInput;

    @FindBy(xpath = "//input[@label='Postal Code']")
    WebElement postalCodeInput;

    @FindBy(xpath = "//textArea[@placeholder='Address']")
    WebElement addressInput;

    @FindBy(xpath = "//button[@class='css-14sosqo']")
    WebElement addAddressBtn;

    @FindBy(xpath = "//div[@class='css-ftcyff']")
    WebElement addressTab;

    @Override
    public boolean isProfilePageDisplayed() {
        return isElementPresent(profileElement);
    }

    @Override
    public void changeAddress() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 100);");
        addNewAddressBtn.click();
    }

    @Override
    public void saveDetails() {
        nameInput.sendKeys("Vishal");
        mobileInput.sendKeys("9980578176");
        postalCodeInput.sendKeys("560094");
        addressInput.sendKeys("This is a demo address for automation testing");
        addAddressBtn.click();
    }

    @Override
    public boolean isUpdatesVisible() {
        return isElementPresent(addressTab);
    }
}
