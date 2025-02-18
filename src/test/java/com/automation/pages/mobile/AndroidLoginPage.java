package com.automation.pages.mobile;

import com.automation.pages.interfaces.LoginPage;
import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndroidLoginPage extends AndroidBasePage implements LoginPage {

    @FindBy(id ="com.truecaller:id/continueWithDifferentNumber" )
    WebElement useAnotherNumber;

    @FindBy(id="com.fsn.nykaa:id/mobileNumber")
    WebElement enterMobileNumber;

    @FindBy(id = "com.fsn.nykaa:id/btnGetOtp")
    WebElement otpTab;

    @FindBy(id="com.fsn.nykaa:id/cross")
    WebElement crossTab;

    @FindBy(id="com.fsn.nykaa:id/btnSkip")
    WebElement skipTab;

    @Override
    public void openApplication(){
        if(isElementDisplayed(useAnotherNumber)){
            useAnotherNumber.click();
        }
    }

    @Override
    public boolean verifySignInPageIsDisplayed(){
        return  enterMobileNumber.isDisplayed();
    }

    @Override
    public void doLogin(String phoneNumber){
        enterMobileNumber.sendKeys(phoneNumber);
        otpTab.click();
        if(isElementDisplayed(crossTab)) {
            crossTab.click();
        }
    }
    @Override
    public void userSkipsSignIn(){
        skipTab.click();
    }


}
