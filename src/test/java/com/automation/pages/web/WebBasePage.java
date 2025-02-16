package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebBasePage {
    static WebDriver driver;

    public WebBasePage(){
        driver= DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public boolean isElementPresent(WebElement element){
        try {
            element.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public void pause(long millisec){
        try {
            Thread.sleep(millisec);
        }catch (Exception e){
            System.out.println("Exception: "+e);
        }
    }
}
