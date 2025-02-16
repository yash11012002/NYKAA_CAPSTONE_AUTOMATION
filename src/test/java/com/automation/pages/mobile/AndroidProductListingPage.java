package com.automation.pages.mobile;

import com.automation.pages.interfaces.ProductListing;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    @Override
    public boolean isProductListingPageIsDisplayed() {
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

        // List to store products containing "Ponds" or "Adhyay"
        List<String> brandCheck = new ArrayList<>();

        // Scroll and verify until the "no more products" element is displayed
        while (!isElementDisplayed(noMoreProduct)) {
            boolean allProductsMatch = true;  // Flag to track if all products match the filter

            // Loop through each product in the list
            for (WebElement product : listOfProducts) {
                String productText = product.getText().toLowerCase();  // Convert to lowercase for case-insensitive comparison

                // If the product doesn't match the filter, set flag to false
                if (!(productText.contains("ponds") || productText.contains("adhyay"))) {
                    allProductsMatch = false;
                    break;  // Exit the loop as soon as a non-matching product is found
                }
            }

            // If all products match the filter, return true
            if (allProductsMatch) {
                return true;
            }

            // Scroll down to load more products
            scroll(startX, startY, endX, endY);  // Placeholder for your scroll logic
        }

        // If the loop ends and we never found all products matching, return false
        return false;
    }
}
