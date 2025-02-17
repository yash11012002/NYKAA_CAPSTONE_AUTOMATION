package com.automation.pages.mobile;

import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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

import static java.util.Arrays.asList;

public class AndroidBasePage {

    AppiumDriver driver;
    WebDriverWait wait;

    public AndroidBasePage() {
        driver = (AppiumDriver) DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void setTimeout(int sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            setTimeout(10);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setTimeout(60);
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

    public void pause(int miliSec) {
        try {
            Thread.sleep(miliSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void zoom(WebElement element, boolean zoomIn) {
        Point imageLocation = element.getLocation();
        Dimension imageSize = element.getSize();

        int startX1 = imageLocation.getX() + imageSize.width / 4;
        int startY1 = imageLocation.getY() + imageSize.height / 2;
        int startX2 = imageLocation.getX() + 3 * imageSize.width / 4;
        int startY2 = imageLocation.getY() + imageSize.height / 2;

        int endX1 = zoomIn ? startX1 - 200 : startX1 + 200;
        int endY1 = startY1;
        int endX2 = zoomIn ? startX2 + 200 : startX2 - 200;
        int endY2 = startY2;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence sequence1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX1, startY1))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX1, endY1))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence sequence2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX2, startY2))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX2, endY2))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(asList(sequence1, sequence2));
    }

    public void swipe(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(4), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

}
