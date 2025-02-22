package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

import static io.restassured.config.SSLConfig.sslConfig;

public class Hooks {

    @Before("@android or web")
    public void setUpMobile() {
        ConfigReader.initConfigurations();
        DriverManager.createDriver();
    }


    @Before("@api")
    public void setUpAPI() {
        RestAssured.baseURI = "https://67b85650699a8a7baef3a6c7.mockapi.io/api/v1";
        ConfigReader.initConfigurations();
        RestAssured.config = RestAssured.config().sslConfig(sslConfig().allowAllHostnames());
        RestAssured.useRelaxedHTTPSValidation();
    }

    @After("@android or @web")
    public void cleanUpMobile() {
        DriverManager.getDriver().quit();
    }

}
