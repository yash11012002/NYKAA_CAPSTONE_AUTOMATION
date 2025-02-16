package com.automation.pages.web;

import com.automation.pages.interfaces.LoginPage;

public class WebLoginPage extends WebBasePage implements LoginPage {

    @Override
    public void openApplication(){

    }

    @Override
    public boolean verifySignInPageIsDisplayed(){
        return  true;
    }

    @Override
    public void doLogin(String phoneNumber){

    }

}
