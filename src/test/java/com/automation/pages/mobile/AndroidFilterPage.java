package com.automation.pages.mobile;

import com.automation.pages.interfaces.FilterPage;
import com.automation.pages.web.WebFilterPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AndroidFilterPage extends AndroidBasePage implements FilterPage {

    @FindBy(id = "com.fsn.nykaa:id/txt_title")
    WebElement verifyFilterTitle;

    @FindBy(xpath = "(//android.widget.ImageView[@content-desc=\"imageDesc\"])[8]")
    WebElement filterElement1;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/txt_filter_label\" and @text=\"Adhyay  2\"]")
    WebElement filterElement2;

    @FindBy(id = "com.fsn.nykaa:id/btn_apply_filters")
    WebElement applyFilterTab;

    @Override
    public boolean isFilterPageIsDisplayed() {
        return verifyFilterTitle.isDisplayed();
    }

    @Override
    public void userApplyFilters() {
        filterElement1.click();


        Dimension screenSize = driver.manage().window().getSize();
        int height = screenSize.getHeight();
        int width = screenSize.getWidth();
        int startX = (width / 2) + 30;
        int startY = (int) (height * 0.8);  //
        int endX = startX;// Start closer to the bottom (80% of screen height)
        int endY = (int) (height * 0.2);  // End closer to the top (20% of screen height)
        pause(1000);
        while (!isElementDisplayed(filterElement2)) {
            scroll(startX, startY, endX, endY);
        }
        filterElement2.click();
        applyFilterTab.click();

    }


}
