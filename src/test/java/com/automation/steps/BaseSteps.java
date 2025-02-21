package com.automation.steps;

import com.automation.pages.interfaces.*;
import com.automation.pages.mobile.*;
import com.automation.pages.web.*;
import com.automation.utils.ConfigReader;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    ProductListing productListing;
    FilterPage filterPage;
    ItemDetailsPage itemDetailsPage;
    StoreLocatorPage storeLocatorPage;
    CartPage cartPage;
    OfferPage offerPage;
    GiftCardPage giftCardPage;
    CategoryPage categoryPage;
    BestSellerProductPage bestSellerProductPage;
    ProfilePage profilePage;
    WishListPage wishListPage;
    AddressPage addressPage;

    public BaseSteps() {
        if (ConfigReader.getConfigValue("platform").equals("web")) {
            loginPage = new WebLoginPage();
            homePage = new WebHomePage();
            productListing=new WebProductListingPage();
            filterPage=new WebFilterPage();
            itemDetailsPage=new WebItemDetailsPage();
            storeLocatorPage = new WebStoreLocatorPage();
            cartPage=new WebCartPage();
            offerPage=new WebOfferPage();
            giftCardPage = new WebGiftCardPage();
            categoryPage=new WebCategoryPage();
            bestSellerProductPage=new WebBestSellerProductPage();
            profilePage = new WebProfilePage();
            wishListPage = new WebWishListPage();
            addressPage=new WebAddressPage();

        } else {
            loginPage = new AndroidLoginPage();
            homePage = new AndroidHomePage();
            productListing=new AndroidProductListingPage();
            filterPage=new AndroidFilterPage();
            itemDetailsPage=new AndroidItemDetailsPage();
            storeLocatorPage= new AndroidStoreLocatorPage();
            cartPage=new AndroidCartPage();
            offerPage=new AndroidOfferPage();
            giftCardPage = new AndroidGiftCardPage();
            categoryPage=new AndroidCategoryPage();
            bestSellerProductPage=new AndroidBestSellerProductPage();
            profilePage = new AndroidProfilePage();
            wishListPage = new AndroidWishListPage();
            addressPage=new AndroidAddressPage();
        }
    }
}
