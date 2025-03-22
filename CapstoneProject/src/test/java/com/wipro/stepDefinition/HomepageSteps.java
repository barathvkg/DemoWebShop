package com.wipro.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.wipro.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utility.Base;

public class HomepageSteps {
    
    WebDriver driver = Base.driver;   
    HomePage page;
	ExtentTest test = Hooks.test;


    @Given("I open the browser and navigate to {string}")
    public void i_open_the_browser_and_navigate_to(String url) {
    	page = new HomePage(driver,test);
        driver.get(url);
    }
    
    @Then("I should see the Top Offers section")
    public void i_should_see_the_top_offers_section() {
    	boolean actResult=page.isTopOffersSectionDisplayed();
    	Assert.assertFalse(actResult);
    }

    @Then("I should see the Featured Products section")
    public void i_should_see_the_featured_products_section() {
    	boolean actResult=page.isFeaturedProductsSectionDisplayed();
    	Assert.assertTrue(actResult);

    }

    @Then("I should see the search bar")
    public void i_should_see_the_search_bar() {
    	boolean actResult=page.isSearchBarDisplayed();
    	Assert.assertTrue(actResult);
    }
}
