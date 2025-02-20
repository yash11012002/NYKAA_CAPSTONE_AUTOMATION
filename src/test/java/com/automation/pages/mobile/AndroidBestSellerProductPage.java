package com.automation.pages.mobile;

import com.automation.pages.interfaces.BestSellerProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AndroidBestSellerProductPage extends AndroidBasePage implements BestSellerProductPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/actv_brand_name\"]")
    List<WebElement> bestSellerProductTitle;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/actv_guide_filter\" and @text=\"Price Deals\"]")
    WebElement priceDealsFilter;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/actv_guide_filter\" and @text=\"On Offer\"]")
    WebElement OnOfferFilter;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.fsn.nykaa:id/llfooter\"]/android.widget.LinearLayout")
    WebElement stoppingCondition;


    @Override
    public void getBestSellerProductTab() {
//        userApplySomeFilter();
        priceDealsFilter.click();
        OnOfferFilter.click();
        File file = new File("andoird_store_results.txt");
        Dimension screenSize = driver.manage().window().getSize();
        int height = screenSize.getHeight();
        int width = screenSize.getWidth();
        int startX = (width / 2) + 30;
        int startY = (int) (height * 0.8);  //
        int endX = startX;// Start closer to the bottom (80% of screen height)
        int endY = (int) (height * 0.2);  // End closer to the top (20% of screen height)
        pause(1000);
        while (!isElementDisplayed(stoppingCondition)) {
            scroll(startX, startY, endX, endY);
            pause(2000);
            bestSellerProductTitle = driver.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/actv_brand_name\"]"));
            try {
                StringBuilder resultContent = new StringBuilder();
                for (int i = 0; i < bestSellerProductTitle.size(); i++) {
                    String name = bestSellerProductTitle.get(i).getText();

                    resultContent.append("Product Name: ").append(name).append("\n");
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    writer.write(resultContent.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void userApplySomeFilter() {
        priceDealsFilter.click();
        OnOfferFilter.click();
    }
}
