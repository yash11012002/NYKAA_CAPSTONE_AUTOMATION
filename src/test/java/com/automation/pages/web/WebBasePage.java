package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

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

    public void switchToNewTab() {
        String currentWindowHandle = driver.getWindowHandle();

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
