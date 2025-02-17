package com.automation.pages.web;

import com.automation.pages.interfaces.LoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebLoginPage extends WebBasePage implements LoginPage {

    @FindBy(xpath = "//button[@class='css-1gzc5zn']")
    WebElement signBtn;

    @FindBy(xpath = "//input[@name='emailMobile']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//button[contains(text(), 'Sign in with Mobile / Email')]")
    WebElement signInUsingMobile;

    @FindBy(id = "submitVerification")
    WebElement proceedBtn;

    @FindBy(xpath = "//button[@class='button big fill full ']")
    WebElement verifyBtn;

    @Override
    public void openApplication(){
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    @Override
    public boolean verifySignInPageIsDisplayed(){
        return  isElementPresent(signBtn);
    }

    @Override
    public void doLogin(String phoneNumber){
        signBtn.click();
        signInUsingMobile.click();
        pause(1000);
        mobileNumberInput.sendKeys(phoneNumber);
        pause(2000);
        proceedBtn.click();
        pause(20000);
        verifyBtn.click();
    }

}
