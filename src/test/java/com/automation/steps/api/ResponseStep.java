package com.automation.steps.api;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class ResponseStep {

    @Then("verify status code {int}")
    public void verifyStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @And("verify response body contains a list of users")
    public void verifyResponseBodyContainsAListOfUsers() {        
        List<?> dataList = RestAssuredUtils.getResponse().jsonPath().getList("data");
        Assert.assertTrue( !dataList.isEmpty());
    }

    @And("verify error message contains {string}")
    public void verifyErrorMessageContains(String errorMessage) {
        String responseMessage = RestAssuredUtils.getResponse().getBody().asString().replaceAll("\"","");
        System.out.println("Msg: "+responseMessage);
        Assert.assertEquals( responseMessage ,errorMessage);
    }

    @And("verify response body contains the user with ID {string}")
    public void verifyResponseBodyContainsTheUserWithID(String userId) {
        int response_userId = RestAssuredUtils.getResponse().jsonPath().getInt("id");
        Assert.assertEquals(response_userId, Integer.parseInt(ConfigReader.getConfigValue(userId)));
    }

    @And("verify response body contains {string}")
    public void verifyResponseBodyContains(String expectedContent) {
        String responseBody = RestAssuredUtils.getResponse().getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedContent));
    }

    @And("verify response body contains {string} with value {string}")
    public void verifyResponseBodyContainsWithValue(String key, String value) {
        String expectedValue = RestAssuredUtils.getValueFromConfigOrResponse(value);
        Assert.assertEquals(expectedValue, RestAssuredUtils.getResponse().jsonPath().getString(key));
    }

    @And("store the {string} in a variable {string}")
    public void storeTheInAVariable(String field, String variableName) {
        String id = RestAssuredUtils.getResponse().jsonPath().getString(field);
        ConfigReader.setConfigValue(variableName,id);
    }
}
