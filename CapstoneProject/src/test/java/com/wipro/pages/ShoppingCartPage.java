package com.wipro.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Reports;

public class ShoppingCartPage {
	private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    
 // Constructor
    public ShoppingCartPage(WebDriver driver,ExtentTest test) {
    	this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.test = test;

    }

    public static By searchBox = By.id("small-searchterms");
    public static By searchButton = By.xpath("//input[@value='Search']");
    public static By productLink = By.cssSelector("h2[class='product-title'] a");
    public static By addToCartButton = By.id("add-to-cart-button-43");
    public static By shoppingCartLink = By.xpath("//span[normalize-space()='Shopping cart']");
    public static By removeFromCartCheckbox = By.xpath("//input[@name='removefromcart']");
    public static By updateCartButton = By.xpath("//input[@name='updatecart']");
    public static By emptyCartMessage = By.xpath("//div[@class='order-summary-content']");
    public static By updateQuantities=By.xpath("//form/table[@class='cart']/tbody/tr/td[@class='qty nobr']/input[@class='qty-input']");



    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    public void clickProductLink() {
        wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public boolean clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
        driver.findElement(updateQuantities).clear();
        driver.findElement(updateQuantities).sendKeys("3");
    	boolean actResult=true;
 		try {
 			// explicit wait for Products text
 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/table[@class='cart']/tbody/tr/td[@class='qty nobr']/input[@class='qty-input']")));
 			Reports.generateReport(driver, test, Status.PASS, "Quantity is Updated");
 		} catch (TimeoutException te) {
 			actResult = false;
 			Reports.generateReport(driver, test, Status.FAIL, "Quantity is not Updated");

 		}
 			return actResult;

    }


    public void clickRemoveFromCartCheckbox() {
        driver.findElement(removeFromCartCheckbox).click();
    }

    public void clickUpdateCartButton() {
        driver.findElement(updateCartButton).click();
    }

    public boolean verifyEmptyCartMessage(String expectedMessage) {
        driver.findElement(emptyCartMessage).isDisplayed();
    	boolean actualResult=true;
		try {
			// explicit wait for Products text
	        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)).getText();
			Reports.generateReport(driver, test, Status.PASS, "Shopping Cart Empty is displayed");
		} catch (TimeoutException te) {
			actualResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Shopping Cart Empty is not Displayed");

		}
         return actualResult ; 
    }
    
    
}
