package com.wipro.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\resources\\Features\\Home.feature",  
    glue = {"com.wipro.stepDefinition"},  
    plugin = {
        "pretty",                              
        "html:target/cucumber-reports.html",  
        "json:target/cucumber-reports.json",
        
    }
    
)
public class Homerunner extends AbstractTestNGCucumberTests {
}

