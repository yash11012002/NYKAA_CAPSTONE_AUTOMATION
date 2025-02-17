package com.automation.pages.mobile;

import com.automation.pages.interfaces.ItemDetailsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidItemDetailsPage extends AndroidBasePage implements ItemDetailsPage {

    @FindBy(id = "com.fsn.nykaa:id/product_image")
    WebElement productIcon;

    @FindBy(id = "com.fsn.nykaa:id/main_parent")
    WebElement parentProductIcon;

    @FindBy(xpath = "//androidx.viewpager.widget.ViewPager[@resource-id=\"com.fsn.nykaa:id/viewer\"]/android.widget.RelativeLayout/android.widget.ImageView")
    WebElement zoomIcon;

    @FindBy(id = "com.fsn.nykaa:id/close_fullscreen")
    WebElement crossTab;

    @FindBy(xpath = "//android.view.View[@resource-id=\"com.fsn.nykaa:id/exo_subtitles\"]")
    WebElement stoppingCondition;

    @Override
    public boolean verifyItemsDetailsPageIsDisplayed() {
        return productIcon.isDisplayed();
    }

    @Override
    public void userClicksOnProductImage() {
        productIcon.click();
    }

    @Override
    public void userPerformZoomFunctionality() {
        zoom(zoomIcon, true);
        zoom(zoomIcon, false);
        crossTab.click();
    }

    @Override
    public void userPerformSwipeFunctionality() {
        int iconHeight = parentProductIcon.getSize().height;
        int iconWidth = parentProductIcon.getSize().width;
        int startX = iconWidth - 100;
        int startY = iconHeight / 2;
        int endX = (startX / 2) - 300;
        int endY = startY;

        //while (!isElementDisplayed(stoppingCondition)){
      //  scroll();
            swipe(startX,startY,endX,endY);
       // }
    }


}
