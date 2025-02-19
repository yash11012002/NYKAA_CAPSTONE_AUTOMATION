package com.automation.pages.web;

import com.automation.pages.interfaces.ItemDetailsPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebItemDetailsPage extends WebBasePage implements ItemDetailsPage {

    @FindBy(xpath = "//div[@class='css-vp18r8']/button[@class=' css-13zjqg6']/span[@class='btn-text' and contains(text(),'Add to Bag')]")
    WebElement addToBagBtn;

    @FindBy(xpath = "//button[@class='css-1aoz7x2']")
    WebElement changeAddressBtn;

    @FindBy(xpath = "//input[@name='pin code']")
    WebElement pinCodeInput;

    @FindBy(xpath = "//button[@class='css-1ivth7r']")
    WebElement checkBtn;

    @FindBy(xpath = "//span[@class='css-ew9amy']")
    WebElement deliveryLocation;

    @Override
    public boolean verifyItemsDetailsPageIsDisplayed() {
        switchToNewTab();
        pause(2000);
        return isElementPresent(addToBagBtn);
    }

    @Override
    public void userClicksOnProductImage() {
        //This is implemented in Android
    }

    @Override
    public void userPerformZoomFunctionality() {
        //This is implemented in Android
    }

    @Override
    public void userPerformSwipeFunctionality() {
        //This is implemented in Android
    }

    @Override
    public void userChangeDeliveryAddress(){
        changeAddressBtn.click();
    }
    @Override
    public void userSetsPincode(String pincode){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 50);");
        pinCodeInput.click();
        pinCodeInput.sendKeys(pincode);
        pause(2000);
        checkBtn.click();
    }

    @Override
    public void selectProductSize(){


    }

    @Override
    public void userAddsProductInCart(){
    }

    @Override
    public int verifyItemAddedInCart(){
        return 0;
    }

    @Override
    public void userClicksOnCartIcon(){
    }

    @Override
    public boolean verifyCity(String cityName) {
        return deliveryLocation.getText().contains(cityName);
    }

}
