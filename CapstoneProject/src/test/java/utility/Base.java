package utility;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public static WebDriver driver;

    // Method to initialize the WebDriver
    public static void initBrowser() {
        System.out.println("Opening the Browser: Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demowebshop.tricentis.com");
    }

    // Method to close the WebDriver
    public static void closeBrowser() {
        if (driver != null) {
            System.out.println("Closing the Browser");
            //driver.quit();
        }
    }
}