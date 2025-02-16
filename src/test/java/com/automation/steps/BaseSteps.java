package com.automation.steps;

import com.automation.pages.interfaces.HomePage;
import com.automation.pages.interfaces.LoginPage;
import com.automation.pages.mobile.AndroidHomePage;
import com.automation.pages.mobile.AndroidLoginPage;
import com.automation.pages.web.WebHomePage;
import com.automation.pages.web.WebLoginPage;
import com.automation.utils.ConfigReader;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;

    public BaseSteps() {
        if (ConfigReader.getConfigValue("platform").equals("web")) {
            loginPage = new WebLoginPage();
            homePage = new WebHomePage();
        } else {
            loginPage = new AndroidLoginPage();
            homePage = new AndroidHomePage();
        }
    }
}
