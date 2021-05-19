package com.marizueva.laboratory.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/cucumberfeatures"})
public class RunAllCucumberTests extends AbstractTestNGCucumberTests {
}
