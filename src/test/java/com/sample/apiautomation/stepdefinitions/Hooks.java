package com.sample.apiautomation.stepdefinitions;

import com.sample.apiautomation.utils.PropertyUtil;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.*;

public class Hooks implements En {

    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    private Scenario scenario;
    private RequestSpecification request;
    private static final String PROXY_ADDRESS = PropertyUtil.getConfigProp("proxy.address");
    private static Integer PROXY_PORT = null;

    static {
        try {
            PROXY_PORT = Integer.valueOf(PropertyUtil.getConfigProp("proxy.port"));
        } catch (NumberFormatException nfe) {
            LOGGER.error("Invalid number format for proxy port value!", nfe.getMessage());
        }
    }

    public Hooks() {

        Before((Scenario scenario) -> {
            LOGGER.traceEntry();
            this.scenario = scenario;
            LOGGER.info("Starting scenario: [{}]", scenario.getName());
            proxy(PROXY_ADDRESS, PROXY_PORT);
            LOGGER.traceExit();
        });



    }
}
