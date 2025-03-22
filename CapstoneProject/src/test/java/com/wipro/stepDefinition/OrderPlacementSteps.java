package com.wipro.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.wipro.pages.OrderPlacementPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Base;

public class OrderPlacementSteps {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	OrderPlacementPage order = new OrderPlacementPage(driver, test);

	@Given("I search {string} for adding to cart")
	public void i_search_for_adding_to_cart(String product) {
		order.searchfinProduct(product);
	}

	@When("I add the product to cart")
	public void i_add_the_product_to_cart() throws InterruptedException {
		order.addfinProductCart();
	}

	@When("I click on shopping cart link")
	public void i_click_on_shopping_cart_link() {
		order.shoppinglink();
	}

	@When("I click on checkout")
	public void i_click_on_checkout() {
		order.checkbox();
	}

	@When("I login and proceed to checkout")
	public void i_login_and_proceed_to_checkout() {
		order.loginproceed();
		order.checkbox();
	}

	@When("I enter billing address")
	public void i_enter_billing_address() {
		order.billcontinue();
	}

	@When("I continue with shipping address")
	public void i_continue_with_shipping_address() {
		order.shippingContinue();
	}

	@When("I continue with shipping method")
	public void i_continue_with_shipping_method() {
		order.shipMethodcon();
	}

	@When("I continue with payment methods")
	public void i_continue_with_payment_methods() {
		order.payContinue();
		order.payinfoContinue();
	}

	@When("I confirm order")
	public void i_confirm_order() {
		order.clickconfirm();
	}

	@Then("I validate the successfully processed order")
	public void i_validate_the_successfully_processed_order() {
	   boolean res= order.successorderdisplay();
	   Assert.assertTrue(res);
	}
}