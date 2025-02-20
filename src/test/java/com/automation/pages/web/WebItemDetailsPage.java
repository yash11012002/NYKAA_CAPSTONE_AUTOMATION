package com.automation.pages.web;

import com.automation.pages.interfaces.ItemDetailsPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//span[@class=\"active css-d3w64v\"]")
    WebElement sizeOfProduct;

    @FindBy(xpath = "//span[@class=\"cart-count\"]")
    WebElement cartCount;

    @FindBy(id = "header-bag-icon")
    WebElement cartIcon;

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
        sizeOfProduct.click();
    }

    public void userAddsProductInCart(){
        ConfigReader.setConfigValue("productDetail",driver.findElement(By.xpath("//h1[@class='css-1gc4x7i']")).getText());
        System.out.println("Added");
        System.out.println(ConfigReader.getConfigValue("productDetail"));
        addToBagBtn.click();
    }

    @Override
    public int verifyItemAddedInCart(){
        String numberOnCart=cartCount.getText().trim();
        int numberOnCartInt=Integer.parseInt(numberOnCart);
        return numberOnCartInt;
    }

    @Override
    public void userClicksOnCartIcon(){
        cartIcon.click();
    }

    @Override
    public boolean verifyCity(String cityName) {
        return deliveryLocation.getText().contains(cityName);
    }

}
