package com.wipro.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src\\test\\resources\\Features\\ShoppingCart.feature",  
	    glue = {"com.wipro.stepDefinition"},  
	    plugin = {
	        "pretty",                              
	        "html:target/cucumber-reports.html",  
	        "json:target/cucumber-reports.json"   
	    }
	    )
public class ShoppingCartrunner extends AbstractTestNGCucumberTests {

}
