package com.apark.bdddemo.steps;

import com.apark.bdddemo.utils.JsonUtil;
import com.apark.bdddemo.utils.RequestResponseHandler;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class BddSteps {


    @Before
    public void init() {

    }
    @Given("^I add following headers:")
    public void addHeaders(Map<String, String> headers) {
        RequestResponseHandler.getHandler().setRequestHeaders(headers);
    }

    @And("^I add following parameters:")
    public void addQueryParams(Map<String, String> params) {
        RequestResponseHandler.getHandler().setQueryParams(params);
    }
    @When("^I make a \"(GET|PUT|DELETE|POST|OPTIONS)\" request$")
    public void makeRequest(List<String> methods) {
        String requestMethod = methods.get(0);
        RequestResponseHandler.getHandler().setRequestMethod(requestMethod);
    }

    @Then("^I receive a response code (\\d+)$")
    public void receiveResponseCode(int code) {
        Assert.assertTrue(code == RequestResponseHandler.getHandler().getResponseStatus());
    }

    @Then ("^I verify following response headers:")
    public void checkResponseHeaders(Map<String, String> responseHeaders) {

    }

    @Then ("^I verify response contains following json response:")
    public void checkResponseBody(Map<String, String> bodys) {
        JsonUtil.verifyPathAndValueExist(bodys, RequestResponseHandler.getHandler().getResponse());
    }

}
