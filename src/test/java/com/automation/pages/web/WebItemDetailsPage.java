package com.automation.pages.web;

import com.automation.pages.interfaces.ItemDetailsPage;
import org.openqa.selenium.Dimension;

public class WebItemDetailsPage extends WebBasePage implements ItemDetailsPage {

    @Override
    public boolean verifyItemsDetailsPageIsDisplayed() {
        return true;
    }

    @Override
    public void userClicksOnProductImage() {

    }

    @Override
    public void userPerformZoomFunctionality() {

    }
    @Override
    public void userPerformSwipeFunctionality() {

    }
    @Override
    public void userChangeDeliveryAddress(){

    }
    @Override
    public void userSetsPincode(String pincode){

    }

    @Override
    public void selectProductSize(){


    }
    @Override
    public void userAddsProductInCart(){
    }
    @Override
    public int verifyItemAddedInCart(){
       return 0;
    }
    @Override
    public void userClicsOnCartIcon(){
    }

}
