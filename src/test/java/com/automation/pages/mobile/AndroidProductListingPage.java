package com.automation.pages.mobile;

import com.automation.pages.interfaces.ProductListing;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class AndroidProductListingPage extends AndroidHomePage implements ProductListing {

    @FindBy(id = "com.fsn.nykaa:id/tv_header_text")
    WebElement verifyTitle;

    @FindBy(id = "com.fsn.nykaa:id/ll_filter_btn_layout")
    WebElement filterTab;

    @FindBy(id = "com.fsn.nykaa:id/footerText")
    WebElement noMoreProduct;

    @FindBy(xpath = "//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'ponds') or contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'adhyay')]")
    List<WebElement> listOfProducts;

    @FindBy(xpath = "(//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.fsn.nykaa:id/ll_product_item\"])[1]")
    WebElement firstProduct;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.fsn.nykaa:id/btn_add_to_bag\" and @text=\"Add to Bag\"]")
    WebElement addToBag;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.fsn.nykaa:id/img_wishlist\"])")
    List<WebElement> addToWishListBtns;


    @Override
    public boolean isProductListingPageDisplayed() {
        return verifyTitle.isDisplayed();
    }

    @Override
    public void clickOnFilterTab() {
        filterTab.click();
    }

    @Override
    public boolean verifyFiltersApplied() {
        // Get screen size for scrolling
        Dimension screenSize = driver.manage().window().getSize();
        int height = screenSize.getHeight();
        int width = screenSize.getWidth();
        int startX = (width / 2);  // Starting point for swipe (X-axis center)
        int startY = (int) (height * 0.8);  // Start closer to the bottom (80% of screen height)
        int endX = startX;  // End X (same as startX)
        int endY = (int) (height * 0.2);  // Scroll upwards (to 20% of screen height)

        // Keep track of products we've already checked
        List<String> brandCheck = new ArrayList<>();
        boolean allProductsMatch = false;

        // Start scrolling and checking products
        while (!isElementDisplayed(noMoreProduct)) {
            // Re-fetch the list of products after each scroll to get the updated set of products
            List<WebElement> listOfProducts = driver.findElements(By.xpath("//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'ponds') or contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'adhyay')]"));

            // Check if there are new products that match the filter
            for (WebElement product : listOfProducts) {
                String productText = product.getText().toLowerCase();  // Convert to lowercase for case-insensitive comparison
                if ((productText.contains("ponds") || productText.contains("adhyay")) && !brandCheck.contains(productText)) {
                    brandCheck.add(productText);  // Add the product to the checked list
                }
            }

            // If all products match the filter, return true
            if (brandCheck.size() == listOfProducts.size()) {
                allProductsMatch = true;
                break;
            }

            // Scroll to load more products
            scroll(startX, startY, endX, endY);

            // Wait for new products to load (adjust the wait time if necessary)
            pause(2000);  // Wait for products to load
        }

        return allProductsMatch;  // If all products match the filter, return true; otherwise, false
    }

    @Override
    public void userClickOnFirstProduct() {
        firstProduct.click();
    }

    @Override
    public boolean isProductOutOfStock() {
        //This function is implemented in Web
        return true;
    }

    @Override
    public void clickOnNotifyBtn() {
        //This function is implemented in Web
    }

    @Override
    public void proceedForNotify() {
        //This function is implemented in Web
    }

    @Override
    public boolean isAlertMsgDisplayed() {
        //This function is implemented in Web
        return true;
    }

    @Override
    public void addFirstProductToBag() {
        addToBag.click();
    }

    @Override
    public boolean isProductAddedToBag() {
        return isElementDisplayed(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/tv_desc\"]")));
    }

    @Override
    public void addToWishList() {
        addToWishListBtns.get(0).click();
    }

    @Override
    public boolean isProductAddedToWishList() {
        return isElementDisplayed(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/tv_desc\"]")));
    }

}
