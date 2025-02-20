package com.automation.pages.mobile;

import com.automation.pages.interfaces.CategoryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidCategoryPage extends AndroidBasePage implements CategoryPage {

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.fsn.nykaa:id/banner_v2_img\"])[4]")
    WebElement bestseller;

    @Override
    public void clickOnBestSeller(){
        bestseller.click();
    }
}
