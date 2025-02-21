package com.automation.pages.mobile;

import com.automation.pages.interfaces.WishListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidWishListPage extends AndroidBasePage implements WishListPage {

    @FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.fsn.nykaa:id/wish_img\"]")
    WebElement unselectWishListBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/add_product_wish_text\"]")
    WebElement EmptyWishList;

    @Override
    public void deleteProductFromWishList() {
        unselectWishListBtn.click();
    }

    @Override
    public boolean isItemDeleted() {
        pause(2000);
        return isElementDisplayed(EmptyWishList);
    }
}
