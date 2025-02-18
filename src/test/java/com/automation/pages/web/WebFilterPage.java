package com.automation.pages.web;

import com.automation.pages.interfaces.FilterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebFilterPage extends WebBasePage implements FilterPage {

    @FindBy(xpath = "//div[@class='filter-open css-1gdff5r']/span[ contains(text(), 'Brand')]")
    WebElement brandBtn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchInput;

    @Override
    public boolean isFilterPageIsDisplayed(){
        return true;
    }
    @Override
    public void userApplyFilters(){
        brandBtn.click();
        applyFilter("Ponds");
        applyFilter("Adhyay");
    }
    private void applyFilter(String filter){
        searchInput.clear();
        searchInput.clear();
        searchInput.sendKeys(filter);
        driver.findElement(By.xpath("//div[@class='control-value']/span[@class='title']")).click();
    }
}
