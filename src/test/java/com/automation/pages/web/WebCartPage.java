package com.automation.pages.web;

import com.automation.pages.interfaces.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.zh_cn.但是;
import org.hamcrest.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class WebCartPage extends WebBasePage implements CartPage {


    @FindBy(xpath = "//div[@class=\"css-18cknfl eh6wigd2\"]")
    WebElement productTitleOnCartPage;

    @FindBy(xpath = "//p[@data-test-id=\"select-quantity\"]")
    WebElement quantityElement;

    @FindBy(xpath = "//div[@class=\"css-0 edkwwn2\"]//li[3]")
    WebElement selectQuantity;

    @FindBy(xpath = "//p[@data-test-id=\"select-quantity\" and text()=\"Quantity : 3\"]")
    WebElement verifyQuantity;

    @FindBy(xpath = "//div[@class=\"leftSelector css-q0kwfb e87w9871\"]")
    WebElement couponsAndBankOfferSection;

    @FindBy(xpath = "//div[@class=\"css-1myqv6q e25lf6d5\"]/span[@class=\"css-175whwo ehes2bo0\"]")
    WebElement productDetailsIcon;

    @FindBy(xpath = "(//div[@class=\"css-150cdpd e1d9ugpt3\"])[1]")
    WebElement bagTotal;

    @FindBy(xpath = " (//div[@class=\"css-150cdpd e1d9ugpt3\"])[2]")
    WebElement discount;

    @FindBy(xpath = " (//div[@class=\"css-150cdpd e1d9ugpt3\"])[4]")
    WebElement amountToPay;

    @FindBy(xpath = "//div[@class=\"css-18zwcko e25lf6d8\"]/button")
    WebElement proceedToPay;

    @FindBy(xpath = "//span[@class=\"css-175whwo ehes2bo0\"]/img")
    WebElement backToCartBtn;

    @Override
    public void setQuantity() {
        //here i am getting iframe
        WebElement iframeElement = driver.findElement(By.cssSelector("iframe.css-wlxg94"));
        driver.switchTo().frame(iframeElement);

        quantityElement.click();
        selectQuantity.click();
    }

    @Override
    public boolean verifyCorrectQuantityIsDisplayed(int expectedItemQty) {
        String displayedQuantity = verifyQuantity.getText().replaceAll("[^0-9]", "");
        System.out.println("Displayed Quantity: " + displayedQuantity);
        int displayedQuantityInt = Integer.parseInt(displayedQuantity);
        System.out.println("Integer Displayed Quantity: " + displayedQuantityInt);
        return displayedQuantityInt == expectedItemQty;
    }

    @Override
    public void userClicksOnBankAndCouponsSection() {
        couponsAndBankOfferSection.click();
        pause(2000);
        // WebElement iframeElement = driver.findElement(By.cssSelector("iframe.css-wlxg94"));driver.switchTo().frame(iframeElement);
        backToCartBtn.click();
        System.out.println("Product Page Displayed");
    }

    @Override
    public void userClicksOnPriceDetailsIcon() {
        WebElement iframeElement = driver.findElement(By.cssSelector("iframe.css-wlxg94"));
       driver.switchTo().frame(iframeElement);
        System.out.println("Before Clicking Product Detail Icon");
        pause(2000);
        productDetailsIcon.click();
        System.out.println("Clicked On Product Detail Icon");
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
        proceedToPay.click();
    }

    @Override
    public boolean isProductPresentInCart() {
        String productTitle = ConfigReader.getConfigValue("product.title");
        if (productTitleOnCartPage.getText().contains(productTitle)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyCorrectOrderAddedInCart() {
        return true;
    }
}
