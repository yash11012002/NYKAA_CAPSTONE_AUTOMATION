package com.automation.steps.api;

import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RequestStep {

    @Given("user set the endpoint to {string}")
    public void userSetTheEndpointTo(String endPoint) {
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @And("set header {string} to {string}")
    public void setHeaderTo(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }

    @And("search the details of the user {string}")
    public void searchTheDetailsOfTheUser(String detail) {
        RestAssuredUtils.setEndPointWithDetails(detail);
    }

    @And("user set request body from file {string}")
    public void userSetRequestBodyFromFile(String filePath) {
        RestAssuredUtils.setBody(filePath);
    }

    @When("user send a GET request")
    public void userSendAGETRequest() {
        RestAssuredUtils.get();
    }

    @When("user send a POST request")
    public void userSendAPOSTRequest() {
        RestAssuredUtils.post();
    }

    @When("user send a PUT request")
    public void userSendAPUTRequest() {
        RestAssuredUtils.put();
    }

    @When("user send a DELETE request")
    public void userSendADELETERequest() {
        RestAssuredUtils.delete();
    }
}
