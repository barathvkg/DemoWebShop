package com.wipro.stepDefinition;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.wipro.pages.ProductDetailPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Base;

public class ProductDetailsSteps {
	WebDriver driver=Base.driver;
	ExtentTest test=Hooks.test;
	ProductDetailPage page =new ProductDetailPage(Base.driver,test);
	
	
	@Given("Searching for {string}")
	public void searching_for(String string) {
		page.searchbar(string);
	}

	@When("I click on the product")
	public void i_click_on_the_product() {
		page.searchHBook();
		page.Clickbook();
	}

	@Then("I see the product title")
	public void i_see_the_product_title() {
		boolean actResult=page.verifyPtitle();
		Assert.assertTrue(actResult);
	}

	@Then("I see the product description")
	public void i_see_the_product_description() {
		boolean actResult=page.verifyPdescription();
		Assert.assertTrue(actResult);

	}

	@Then("I see the product price")
	public void i_see_the_product_price() {
		boolean actResult=page.verifyPprice();
		Assert.assertTrue(actResult);

	}

	@Then("I see the product images")
	public void i_see_the_product_images() {
		boolean actResult=page.verifyPimage();
		Assert.assertTrue(actResult);

	}

	@Then("I see the product availabity")
	public void i_see_the_product_availabity() {
		boolean actResult=page.verifyPavailability();
		Assert.assertTrue(actResult);

	}

	@When("I click on add to wishlist")
	public void i_click_on_add_to_wishlist() {
		page.clickAddWish();
	}

	@And("I click on add to cart")
	public void i_click_on_add_to_cart()   {
		page.clickAddCart();
	}

	@Then("product is added")
	public void product_is_added() {
	   System.out.println("Product is added");
	}
}
