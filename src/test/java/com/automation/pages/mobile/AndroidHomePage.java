package com.automation.pages.mobile;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(id = "com.fsn.nykaa:id/ts_search_bar")
    WebElement productInput;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.fsn.nykaa:id/navigation_bar_item_icon_view\"])[5]")
    WebElement accountTab;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.fsn.nykaa:id/tv_login_status\"]")
    WebElement verifyAccount;

    @FindBy(id = "com.fsn.nykaa:id/ts_search_bar")
    WebElement searchProductFeild;

    @FindBy(id = "com.fsn.nykaa:id/search_field")
    WebElement enterProduct;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.fsn.nykaa:id/rv_recent_suggestion_new\"]/android.view.ViewGroup[1]")
    WebElement selectFromSuggestion;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.fsn.nykaa:id/navigation_bar_item_icon_view\"])[3]")
    WebElement categoryTab;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.fsn.nykaa:id/container_layout\"])[8]")
    WebElement addressElement;


    @Override
    public boolean isHomePageDisplayed() {
        driver.navigate().back();
        return productInput.isDisplayed();

    }

    @Override
    public boolean verifyUserSuccessfullyLoggedIn() {
        accountTab.click();
        return verifyAccount.isDisplayed();
    }

    @Override
    public void userSearchProduct(String productName) {
        searchProductFeild.click();
        enterProduct.sendKeys(productName);
        selectFromSuggestion.click();

    }

    @Override
    public void clickOnStoreAndEventsBtn() {
        //This function is implemented in Web
    }

    @Override
    public void clickOnGiftCardTab() {
        //This function is implemented in Web
    }

    @Override
    public void userClicksOnCategoryTab(){
        categoryTab.click();
    }

    @Override
    public void clickOnProfileSection() {
    }

    @Override
    public void clickOnAddressSection(){
        accountTab.click();

        while (!isElementDisplayed(addressElement)){
            Dimension screensize=driver.manage().window().getSize();
            int height=screensize.getHeight();
            int width=screensize.getWidth();
            int startX = (width / 2);
            int startY = (int) (height * 0.8);  //
            int endX = startX;// Start closer to the bottom (80% of screen height)
            int endY = (int) (height * 0.2);  // End closer to the top (20% of screen height)
            scroll(startX,startY,endX,endY);
        }
        addressElement.click();
    }

    @Override
    public void clickOnBagIcon() {

    }

    @Override
    public void openWishListTab() {

    }

    @Override
    public void clickOnLogOutBtn() {

    }

}
