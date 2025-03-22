package com.wipro.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.wipro.pages.SearchPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Base;

public class SearchSteps {
	WebDriver driver = Base.driver;   
    SearchPage search;
	ExtentTest test = Hooks.test;
	public SearchSteps() {
	search = new SearchPage(driver,test);
	}
	
	@When("I navigated to search bar")
	public void i_navigated_to_search_bar() {

		search.searchBar();
	}

	@When("I search for the product")
	public void i_search_for() {
		
		search.searchItem();
	}
	
	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		
		search.searchButton();
	}

	@Then("I see the search results")
	public void i_see_the_search_results() {
		search.resultverify();
		boolean actResult=search.itemDisplayed();
		Assert.assertTrue(actResult);
	}
}
