package com.wipro.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {".\\src\\test\\resources\\features\\Home.feature",
				".\\src\\test\\resources\\features\\Search.feature",
				".\\src\\test\\resources\\features\\Productdetails.feature",
				".\\src\\test\\resources\\features\\ShoppingCart.feature",
				"src\\\\test\\\\resources\\\\Features\\\\OrderPlacement.feature"
				
		},  
	    glue = {"com.wipro.stepDefinition","Hooks"},  
	    plugin = {
	        "pretty",                              
	        "html:target/cucumber-reports.html",  
	        "json:target/cucumber-reports.json",
	        
	    }
	    
	)
public class TotalrunnerTestCase extends AbstractTestNGCucumberTests {

}
