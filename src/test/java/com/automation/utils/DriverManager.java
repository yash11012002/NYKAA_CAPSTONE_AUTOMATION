package com.automation.utils;

import freemarker.core.UndefinedCustomFormatException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver(){
        if(ConfigReader.getConfigValue("platform").equals("web")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (ConfigReader.getConfigValue("platform").equals("mobile")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("automationName",ConfigReader.getConfigValue("automation.name"));
            capabilities.setCapability("platformName",ConfigReader.getConfigValue("platform.name"));
            capabilities.setCapability("deviceName",ConfigReader.getConfigValue("device.name"));
            capabilities.setCapability("app",ConfigReader.getConfigValue("app.path"));
            capabilities.setCapability("appActivity",ConfigReader.getConfigValue("app.activity"));
            capabilities.setCapability("appPackage",ConfigReader.getConfigValue("app.package"));
            capabilities.setCapability("autoGrantPermissions", true);

            driver = new AndroidDriver(capabilities);

        }
        else {
//            ("Platform should be either Web or Mobile");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
