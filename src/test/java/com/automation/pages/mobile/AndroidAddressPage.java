package com.automation.pages.mobile;

import com.automation.pages.interfaces.AddressPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidAddressPage extends AndroidBasePage implements AddressPage {

    @FindBy(id = "com.fsn.nykaa:id/txt_toolbar_title")
    WebElement addressTitle;

    @FindBy(id = "com.fsn.nykaa:id/tvAddNewAddress")
    WebElement addNewAddressElement;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/tv_section_description\" and @text=\"Manage your saved addresses\"]")
    WebElement addressElement;

    @FindBy(id = "com.fsn.nykaa:id/addManually")
    WebElement addManually;

    @FindBy(id = "com.fsn.nykaa:id/etPincode")
    WebElement inputPincode;

    @FindBy(id = "com.fsn.nykaa:id/etHouseFlatOfficeNo")
    WebElement inputHouseName;

    @FindBy(id = "com.fsn.nykaa:id/etRoadAreaColony")
    WebElement inputColonyName;

    @FindBy(id = "com.fsn.nykaa:id/etName")
    WebElement inputName;

    @FindBy(id = "com.fsn.nykaa:id/tilPhoneNumber")
    WebElement inputPhoneNumber;

    @FindBy(id = "com.fsn.nykaa:id/btnShip")
    WebElement saveAddressBtn;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/tvName\"])[1]")
    WebElement verifyNameInAddress;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/tvAddress\" ])[1]")
    WebElement verifyAddress;

    @Override
    public boolean verifyIsAddressPageIsDisplayed() {
        return addressTitle.isDisplayed();
    }
    @Override
    public void userCliksOnAddNewAddress() {
        addNewAddressElement.click();
        addManually.click();
    }
    @Override
    public void userFillAddressDetails(String pincode,String houseName,String colonyName,String name){
        inputPincode.sendKeys(pincode);
        inputHouseName.sendKeys(houseName);
        inputColonyName.sendKeys(colonyName);
        inputName.clear();
        inputName.sendKeys(name);

        saveAddressBtn.click();
    }

    @Override
    public boolean verifyAddressSuccessfullyAdded(){

        while (!isElementDisplayed(addressElement)) {
            Dimension screensize=driver.manage().window().getSize();
            int height=screensize.getHeight();
            int width=screensize.getWidth();
            int startX = (width / 2);
            int startY = (int) (height * 0.8);  //
            int endX = startX;// Start closer to the bottom (80% of screen height)
            int endY = (int) (height * 0.2);  // End closer to the top (20% of screen height)
            scroll(startX,startY,endX,endY);
        }
        addressElement.click();
        if (verifyNameInAddress.getText().contains(ConfigReader.getConfigValue("name")) &&
                verifyAddress.getText().contains(ConfigReader.getConfigValue("houseName"))) {
            return true;
        }
        return false;  // Add this line to ensure a boolean value is returned.
    }

}
