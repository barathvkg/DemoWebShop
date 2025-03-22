package com.wipro.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utility.Reports;

public class SearchPage {
    private WebDriver driver;
    private ExtentTest test;
    private WebDriverWait wait;

    // Constructor
    public SearchPage(WebDriver driver,ExtentTest test) {
    	this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.test = test;

    }

   
    public static By searchBar = By.id("small-searchterms");
    public static By searchButton=By.xpath("//div[@class='header']/..//input[@class='button-1 search-box-button']");
    public static By itemDisplayed=By.xpath("//div[@class='item-box']/..//a[normalize-space()='Health Book']");
    public static By checkBox=By.id("As");
    public static By selectItem=By.xpath("//div[@class='search-input']/..//select[@id='Cid']");
    public static By priceFrom = By.id("Pf");
    public static By priceTo = By.id("Pt");
    public static By productDetails=By.id("Sid");
    public static By productSearch=By.xpath("//div[@class='search-input']/..//input[@class='button-1 search-button']");
    public static By results = By.xpath("//div[@class='product-grid']/div//div[@class='details']/div[@class='add-info']//span[2]");

    public void searchBar() {
    	driver.findElement(searchBar).click();
    }
    public void searchItem() {
    	driver.findElement(searchBar).sendKeys("Book");
    }
    
    public void searchButton() {
    	driver.findElement(searchButton).click();
    	driver.findElement(checkBox).click();
    	driver.findElement(selectItem).click();    	
    	driver.findElement(productDetails).click();
    	driver.findElement(priceFrom).sendKeys("10.00");
    	driver.findElement(priceTo).sendKeys("70.00");
    	driver.findElement(productSearch).click();
    }
    public boolean itemDisplayed() {
    	driver.findElement(itemDisplayed).isDisplayed();
    	boolean actResult=true;
 		try {
 			// explicit wait for Products text
 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='item-box']/..//a[normalize-space()='Health Book']")));
 			Reports.generateReport(driver, test, Status.PASS, "Message is Displayed");
 		} catch (TimeoutException te) {
 			actResult = false;
 			Reports.generateReport(driver, test, Status.FAIL, "Meaaage is not Displayed");

 		}
 			return actResult;
    }
    public boolean resultverify() {
		boolean actresult = true;
		try {
			List<WebElement>res=driver.findElements(results);
			for(WebElement i : res) {
				String price=i.getText();
				System.out.println(price);
				double p = Double.parseDouble(price);
				if(p >=10 || p<=70) {
					actresult=true;
				}else {
					actresult=false;
				}
			}
			Reports.generateReport(driver, test,Status.PASS,"Result filtered" );
		}
		catch(Exception e) {
			actresult = false;
			Reports.generateReport(driver, test,Status.FAIL,"Products not filtered" );
		}
		return actresult;
	}
    
}

