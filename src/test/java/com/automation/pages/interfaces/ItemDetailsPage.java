package com.automation.pages.interfaces;

public interface ItemDetailsPage {

    boolean verifyItemsDetailsPageIsDisplayed();
    void userClicksOnProductImage();
    void userPerformZoomFunctionality();
    void userPerformSwipeFunctionality();
    void userChangeDeliveryAddress();
    void userSetsPincode(String pincode);
    void selectProductSize();
    void userAddsProductInCart();
    int verifyItemAddedInCart();
    void userClicsOnCartIcon();

}
