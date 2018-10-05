package com.sample.apiautomation.stepdefinitions;

import static org.hamcrest.CoreMatchers.is;

import com.sample.apiautomation.utils.PropertyUtil;
import cucumber.api.java8.En;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class SampleGetUsersStepdefinition implements En {

    private static final Logger LOGGER = LogManager.getLogger(SampleGetUsersStepdefinition.class);
    private RequestSpecification request;
    private Response response;

    public SampleGetUsersStepdefinition() {

        Given("I have access to the system", () -> {

        });

        When("I retrieve all users in the system", () -> {
            final String usersPath = PropertyUtil.getConfigProp("base.uri") + PropertyUtil.getConfigProp("users.uri");
            response = when().get(usersPath);
            LOGGER.info(response.asString());
        });

        Then("I should see the list of users in the system", () -> {

        });

        And("the status code is '(.*)'", (String code) -> {
            boolean isEqual = Integer.valueOf(code) == response.getStatusCode();
            Assert.assertThat("Verify status code is 200", isEqual, is(true));

        });


    }

}
