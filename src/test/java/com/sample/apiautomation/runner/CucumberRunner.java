package com.sample.apiautomation.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@sampletest"}, // run a single scenario while developing or troubleshooting
        features = {"src/test/resources/features"}, // feature file path
        glue = {"com.sample.apiautomation.stepdefinitions"}, // step definition package
        plugin = {"pretty",
                "html:target/testresults/html", // test results as html
                "json:target/testresults/cucumber.json", // test results as json
                "junit:target/testresults/cucumber.xml"}
)
public class CucumberRunner {
}
