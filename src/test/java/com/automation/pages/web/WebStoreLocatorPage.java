package com.automation.pages.web;

import com.automation.pages.interfaces.StoreLocatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WebStoreLocatorPage extends WebBasePage implements StoreLocatorPage{
    String parentWindow,childWindow;

    @Override
    public boolean isStoreLocatorPageDisplayed() {
        switchToNewTab();
        pause(2000);
        WebElement storeSearchInput = driver.findElement(By.xpath("//input[@id='nw-store-search' and @placeholder='Search City']"));
        return isElementPresent(storeSearchInput);
    }

    @Override
    public void checkCity(String cityName) {
        pause(2000);
        WebElement storeSearchInput = driver.findElement(By.id("nw-store-search"));
        storeSearchInput.sendKeys(cityName);
        driver.findElement(By.xpath("//div[@class='nw-search-box nw-search-box-city']//div/a")).click();
        File file = new File("store_results.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuilder resultContent = new StringBuilder();
            resultContent.append("City: ").append(cityName).append("\n\n");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(resultContent.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void verifyAndStoreTheResult() {
        List<WebElement> storeName= driver.findElements(By.xpath("//div[@class='nw-store-box-name']"));
        List<WebElement> storeAddress = driver.findElements(By.xpath("//div[@class='nw-store-box-address']"));

        File file = new File("store_results.txt");
        try {
            StringBuilder resultContent = new StringBuilder();
            for (int i = 0; i < storeName.size(); i++) {
                String name = storeName.get(i).getText();
                String address = storeAddress.get(i).getText();

                resultContent.append("Store Name: ").append(name).append("\n");
                resultContent.append("Address: ").append(address).append("\n\n");
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(resultContent.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
