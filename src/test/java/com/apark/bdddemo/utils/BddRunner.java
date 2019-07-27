package com.apark.bdddemo.utils;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/src/test/resources/",
                glue = {"com.apark.bdddemo"},
                plugin = {"pretty", "json:cucumber.json"})
public class BddRunner {

}
