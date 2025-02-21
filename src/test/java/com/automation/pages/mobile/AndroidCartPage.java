package com.automation.pages.mobile;

import com.automation.pages.interfaces.CartPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidCartPage extends AndroidBasePage implements CartPage {

    @FindBy(id = "com.fsn.nykaa:id/tvQuantityInCard")
    WebElement quantity;

    @FindBy(xpath = "(//android.widget.RadioButton[@resource-id=\"com.fsn.nykaa:id/rbQuantity\"])[3]")
    WebElement getQuantity;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Select Quantity\"]")
    WebElement verifyQuantity;

    @FindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.fsn.nykaa:id/collapsedSection\"]/android.view.ViewGroup[1]")
    WebElement couponsAndBankOffersSection;

    @FindBy(id = "com.fsn.nykaa:id/revampGrandTotalMsgInfoIv")
    WebElement priceDetailsIcon;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View//android.view.View//android.widget.TextView[2]")
    WebElement bagTotal;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View//android.view.View//android.widget.TextView[4]")
    WebElement discount;

    @FindBy(xpath = "(//android.view.View//android.widget.TextView)[11]")
    WebElement amountToPay;

    @FindBy(xpath = "//android.widget.ImageView")
    WebElement crossTab;

    @FindBy(id = "com.fsn.nykaa:id/revampLlProceedBtn")
    WebElement proceedToPay;

    @FindBy(id = "com.fsn.nykaa:id/tvProductTitle")
    WebElement productTitleOnCartPage;

    @FindBy(id = "com.truecaller:id/confirm")
    WebElement continueWithNumber;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Delete\"]")
    WebElement deleteBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Yes, remove\"]")
    WebElement removeItemBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/bag\"]")
    WebElement cartText;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"back\"]")
    WebElement backBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/tvProductTitle\"]")
    WebElement itemDescription;

    @Override
    public void setQuantity() {
        quantity.click();
        getQuantity.click();
    }

    @Override
    public boolean verifyCorrectQuantityIsDisplayed(int expectedItemQty) {
        String itemQuantityText = verifyQuantity.getText();
        System.out.println("text format " + itemQuantityText);

        String quantityOnly = itemQuantityText.replaceAll("[^0-9]", "");
        int displayedQuantity = Integer.parseInt(quantityOnly);
        System.out.println("Extracted Quantity: " + displayedQuantity);
        System.out.println("integer format " + displayedQuantity);
        return displayedQuantity == expectedItemQty;  // Returns true if they match, otherwise false
    }

    @Override
    public void userClicksOnBankAndCouponsSection() {
        couponsAndBankOffersSection.click();
        continueWithNumber.click();
        pause(2000);
    }

    @Override
    public void userClicksOnPriceDetailsIcon() {
        priceDetailsIcon.click();
    }

    @Override
    public boolean verifyPriceDetails() {
        String totalPrice = bagTotal.getText().replaceAll("[^0-9]", "");
        System.out.println("text " + totalPrice);
        int totalPriceInt = Integer.parseInt(totalPrice);
        System.out.println("int " + totalPriceInt);
        String discountPrice = discount.getText().replaceAll("[^0-9]", "");
        System.out.println("text " + discountPrice);
        int discountPriceInt = Integer.parseInt(discountPrice);
        System.out.println("int: " + discountPriceInt);
        String payableAmount = amountToPay.getText().replaceAll("[^0-9]", "");
        int payableAmountInt = Integer.parseInt(payableAmount);
        System.out.println("text " + payableAmount);
        System.out.println("int " + payableAmountInt);

        return payableAmountInt == (totalPriceInt - discountPriceInt);
    }

    @Override
    public void userClicksOnProceedToPay() {
        crossTab.click();
        proceedToPay.click();
    }

    @Override
    public boolean isProductPresentInCart() {
        String productTitle = ConfigReader.getConfigValue("product.title");
        if (productTitleOnCartPage.getText().contains(productTitle)) {
            ConfigReader.setConfigValue("android_product_details",productTitleOnCartPage.getText());
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyCorrectOrderAddedInCart() {
        return isProductPresentInCart();
    }

    @Override
    public boolean isCartPageDisplayed() {
        return isElementDisplayed(cartText);
    }

    @Override
    public boolean cartPersistency() {
        return itemDescription.getText().contains(ConfigReader.getConfigValue("android_product_details"));
    }

    @Override
    public void deleteFromCart() {
        deleteBtn.click();
        removeItemBtn.click();
    }

    @Override
    public boolean isProductDeleted() {
        pause(2000);
        return isElementDisplayed(driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.fsn.nykaa:id/frameLayout\"]")));
    }

    @Override
    public void navigateBack() {
        backBtn.click();
        driver.navigate().back();
        driver.navigate().back();
    }
}
