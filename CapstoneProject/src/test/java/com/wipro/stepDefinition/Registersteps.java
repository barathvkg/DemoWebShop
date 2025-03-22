package com.wipro.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.wipro.pages.HomePage;
import com.wipro.pages.RegisterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Base;

public class Registersteps {
	WebDriver driver=Base.driver;
	ExtentTest test=Hooks.test;
	RegisterPage cp;
	
	@Given("Home page of website")
	public void home_page_of_website() {
    	cp = new RegisterPage(driver,test);

	    System.out.println("Visited homepage");
	}

	@When("click on regiter")
	public void click_on_regiter() {
		cp.registerlink();
		 System.out.println("Clicked on register");
	}

	@When("Choose gender")
	public void choose_gender() {
		cp.genderselect();
		 System.out.println("Gender choosen");
	}

	@When("Enter {string} in first name field")
	public void enter_in_first_name_field(String fn) {
		cp.enterfirstname(fn);
		 System.out.println("Firstname entered");
	}

	@When("Enter {string} in second name field")
	public void enter_in_second_name_field(String ln) {
		cp.enterlastname(ln);
		 System.out.println("Lastname entered");
	}

	@When("Enter {string} in email field")
	public void enter_in_email_field(String em) {
		cp.enteremail(em);
		System.out.println("Email entered");
	}

	@When("Enter {string} in password field")
	public void enter_in_password_field(String pass) {
		cp.enterpass(pass);
		System.out.println("Password entered");
	}

	@When("Enter {string} in confirm password field")
	public void enter_in_confirm_password_field(String cnfrmpass) {
		cp.enterconfirmpass(cnfrmpass);
		System.out.println("Confirmpassword entered");
	}

	@When("click on register button")
	public void click_on_register_button() {
		cp.registerbutton();
		System.out.println("Clicked register button");
	}

	@Then("Registered successfuly")
	public void registered_successfuly() {
		Assert.assertTrue(cp.successmsgdisplay());
		cp.clickcontinue();
		System.out.println("Registeration successful");
	}
	@When("Click on logout")
	public void click_on_logout() {
		cp.logoutbtn();
	    System.out.println("Logged out");
	}
	@Then("Invalid email")
	public void invalid_email() {
	    Assert.assertTrue(cp.invalidmsgdisplay());
	    System.out.println("Invalid email");
	}
	@When("Click on login")
	public void click_on_login() {
		cp.clicklogin();
	    System.out.println("Clicked login");
	}

	@When("Click on login button")
	public void click_on_login_button() {
		cp.loginbutton();
	    System.out.println("Clicked login button");
	}

	@Then("Logged in successfully")
	public void logged_in_successfully() {
		Assert.assertTrue(cp.loginsuccess());
	    System.out.println("Login successful");
	}
	@Then("invalid login credentials")
	public void invalid_login_credentials() {
		Assert.assertTrue(cp.invalidlogin());
	   System.out.println("invalid login credentials");
	}
	@When("Click on Forgot password")
	public void click_on_forgot_password() {
		cp.forgotpassword();
	    System.out.println("Clicked on forgot password");
	}

	@When("Click on recover button")
	public void click_on_recover_button() {
		cp.recoverybtn();
	    System.out.println("Clicked on recover button");
	}

	@Then("Email sent message displayed")
	public void email_sent_message_displayed() {
		Assert.assertTrue(cp.emailsent());
	   System.out.println("Email sent successfully");
	}

	@Then("Email does not exist  message displayed")
	public void email_does_not_exist_message_displayed() {
		Assert.assertTrue(cp.emailnotexist());
	    System.out.println("Email does not exist");
	}
}
