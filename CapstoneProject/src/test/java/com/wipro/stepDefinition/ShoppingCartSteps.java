package com.wipro.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.wipro.pages.ProductDetailPage;
import com.wipro.pages.ShoppingCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Base;

public class ShoppingCartSteps {
	 WebDriver driver = Base.driver;
	  ShoppingCartPage cart;
	  ExtentTest test = Hooks.test;
		public ShoppingCartSteps() {
			cart = new ShoppingCartPage(driver,test);
			}

	    @Given("I am on the home page for shopping cart testing")
	    public void iAmOnTheHomePageForShoppingCartTesting() {
	        // Assuming your setup already navigates to the home page
	    }

	    @When("I search for {string} and add the product to cart")
	    public void iSearchForAndAddTheProductToCart(String product) throws InterruptedException {
	    	cart.searchProduct(product);
	    	cart.clickProductLink();
	    	cart.clickAddToCart();
	    	
	    }

	    @When("I go to the shopping cart")
	    public void iGoToTheShoppingCart() {
	    	boolean actResult=cart.clickShoppingCartLink();
	    	Assert.assertTrue(actResult);
	    }

	    @When("I remove the product from cart")
	    public void iRemoveTheProductFromCart() {
	    	cart.clickRemoveFromCartCheckbox();
	    	cart.clickUpdateCartButton();
	    }

	    @Then("the shopping cart is empty")
	    public void theShoppingCartIsEmpty() {
	    	boolean actResult=cart.verifyEmptyCartMessage("Your Shopping Cart is empty!");
	    	Assert.assertTrue(actResult);
	    }

	    @Then("update shopping cart")
	    public void update_shopping_cart() {
	    	cart.clickUpdateCartButton();
	    }
}
