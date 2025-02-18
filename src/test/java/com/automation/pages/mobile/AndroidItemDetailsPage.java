package com.automation.pages.mobile;

import com.automation.pages.interfaces.ItemDetailsPage;
import org.openqa.selenium.Dimension;
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

    @FindBy(id = "com.fsn.nykaa:id/btn_change_edd")
    WebElement changeAddressBtn;

    @FindBy(id = "com.fsn.nykaa:id/tv_hint_label")
    WebElement enterPincodeElement;

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
        Dimension screenSize = driver.manage().window().getSize();
        int height = screenSize.getHeight();
        int width = screenSize.getWidth();
        int startX = (width / 2) + 350;
        int startY = height / 2;  //
        int endX = (width / 2) - 350;// Start closer to the bottom (80% of screen height)
        int endY = startY;  // End closer to the top (20% of screen height)
        while (!isElementDisplayed(stoppingCondition)){
            scroll(startX,startY,endX,endY);
        }

    }
    @Override
    public void userChangeDeliveryAddress(){
        Dimension screenSize = driver.manage().window().getSize();
        int height = screenSize.getHeight();
        int width = screenSize.getWidth();
        int startX = (width / 2) + 30;
        int startY = (int) (height * 0.8);  //
        int endX = startX;// Start closer to the bottom (80% of screen height)
        int endY = (int) (height * 0.2);  // End closer to the top (20% of screen height)
        pause(1000);
        while (!isElementDisplayed(changeAddressBtn)){
            scroll(startX,startY,endX,endY);
        }
        changeAddressBtn.click();

    }
    @Override
    public void userSetsPincode(String pincode){
        enterPincodeElement.sendKeys(pincode);
    }


}
