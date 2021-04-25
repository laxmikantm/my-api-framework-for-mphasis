package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.*;
import io.restassured.response.Response;
import middleware.Controller;
import org.junit.Assert;

import requests.GET_Request;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**************************
 *  (C) L Somni            *
 ***************************/

public class StepDefs {
    TestContext testContext;
    Response response;
    Controller controller;

    GET_Request get_request = new GET_Request();

    public StepDefs(TestContext context) {
        testContext = context;
        response = testContext.getResponse();
        controller = testContext.getController();
    }


    @Given("I use {string} API end point")
    public void iUseAPIEndPoint(final String sEndPoint) {
        get_request.chooseEndPoint(sEndPoint);
        testContext.setMock(false);
    }

    @When("I make a GET request")
    public void iMakeAGETRequest() {
        response = get_request.getRequest();
    }

    @Then("I get success response {int} code")
    public void iGetSuccessResponseCode(final int expectedStatusCode) {
        Assert.assertThat(response.statusCode(), is(equalTo(expectedStatusCode)));
    }

    @And("response contains correct structure")
    public void responseContainsStructure() {
        response.then().body(matchesJsonSchemaInClasspath("schema.json"));
    }

}
