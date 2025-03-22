package com.wipro.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Reports;

public class HomePage {
    private WebDriver driver;
    private ExtentTest test;
    private WebDriverWait wait;

    // Constructor
    public HomePage(WebDriver driver,ExtentTest test) {
        this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.test=test;
    }
    public static By topOffersSection = By.xpath("//div[@class='master-wrapper-page']/..//a[@href='https://academy.tricentis.com']");
    public static By featuredProductsSection = By.xpath("//div[@class='title']/strong[contains(text(),'Featured')]");
    public static By searchBar = By.id("small-searchterms");
 
    public boolean isFeaturedProductsSectionDisplayed() {
        driver.findElement(featuredProductsSection).isDisplayed();
    	boolean actResult=true;
		try {
			// explicit wait for Products text
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title']/strong[contains(text(),'Featured')]")));
			Reports.generateReport(driver, test, Status.PASS, "Feature product is displayed");
		} catch (TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Feature product is not Displayed");

		}
         return actResult;
    }

    public boolean isSearchBarDisplayed() {
        driver.findElement(searchBar).isDisplayed();
    	boolean actResult=true;
		try {
			// explicit wait for Products text
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
			Reports.generateReport(driver, test, Status.PASS, "Search Bar is Displayed");
		} catch (TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Search Bar is not Displayed");

		}
        return actResult;
    }
    // Methods to check if elements exist
    public boolean isTopOffersSectionDisplayed() {
		driver.findElement(topOffersSection).isDisplayed();
    	boolean actResult=true;
		try {
			// explicit wait for Products text
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='master-wrapper-page']/..//a[@href='https://academy.tricentis.com']")));
			Reports.generateReport(driver, test, Status.PASS, "Top Offer is Displayed");
		} catch (TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Top Offer is not Displayed");

		}
			return actResult;
    }

}
