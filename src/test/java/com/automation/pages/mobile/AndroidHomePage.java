package com.automation.pages.mobile;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.Keys;
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
        //This is implemented in Web Application
    }
}
