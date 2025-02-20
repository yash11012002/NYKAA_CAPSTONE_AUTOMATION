package com.automation.pages.web;

import com.automation.pages.interfaces.WishListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebWishListPage extends WebBasePage implements WishListPage {

    @FindBy(xpath = "//button[@class='css-190ul11']")
    WebElement deleteBtn;

    @Override
    public void deleteProductFromWishList() {
        deleteBtn.click();
    }

    @Override
    public boolean isItemDeleted() {
        return isElementPresent(driver.findElement(By.xpath("//div[@class='css-1gwmmua']")));
    }
}
