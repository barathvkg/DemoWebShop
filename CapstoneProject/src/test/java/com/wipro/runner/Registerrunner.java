package com.wipro.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\resources\\Features\\RegisterDetails.feature",  
    glue = {"com.wipro.stepDefinition"},  
    plugin = {
        "pretty",                              
        "html:target/cucumber-reports.html",  
        "json:target/cucumber-reports.json"   
    },
    tags="@createaccountwithvalidemail"
    		
    		
    		
    		
    
)
public class Registerrunner extends AbstractTestNGCucumberTests {
}
