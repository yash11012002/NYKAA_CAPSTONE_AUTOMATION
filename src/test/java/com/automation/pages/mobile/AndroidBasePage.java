package com.automation.pages.mobile;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class AndroidBasePage {

    AppiumDriver driver;
    WebDriverWait wait;

    public AndroidBasePage() {
        driver = (AppiumDriver) DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver,Duration.ofSeconds(60));
    }
    public void setTimeout(int sec){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }
    public boolean isElementDisplayed(WebElement element){
        try {
            setTimeout(20);
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }finally {
            setTimeout(60);
        }
    }
    public static String getFormattedDate(String expectedFormat, String date, String currentDateFormat) {
        try {
            SimpleDateFormat currentFormatter = new SimpleDateFormat(currentDateFormat);
            Date dateObject = currentFormatter.parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateObject);

            SimpleDateFormat expectedFormatter = new SimpleDateFormat(expectedFormat);
            return expectedFormatter.format(calendar.getTime());
        } catch (Exception e) {
            throw new RuntimeException("Invalid date format " + expectedFormat);
        }
    }
    public void scroll(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(5), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
          driver.perform(Collections.singletonList(sequence));
    }
    public void pause(int miliSec){
        try {
            Thread.sleep(miliSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
