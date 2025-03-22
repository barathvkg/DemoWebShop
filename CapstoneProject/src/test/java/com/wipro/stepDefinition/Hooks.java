package com.wipro.stepDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utility.Base;

public class Hooks extends Base {
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	
    @BeforeAll
    public static void setUpOnce() {
		try {
			sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");

		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("Initializing the browser before all tests...");
        Base.initBrowser();  
    }

    @Before
    public void setUp() {
		test  = extent.createTest("Demo Web Shop Tricentis");

        System.out.println("Starting a new scenario...");
    }

    @After
    public void tearDownScenario() {
        System.out.println("Scenario execution completed.");
    }

    @AfterAll
    public static void tearDownOnce() {
        System.out.println("Closing the browser after all tests...");
        try {
            Base.closeBrowser();
        } catch (Exception e) {
            System.out.println("Error while closing browser: " + e.getMessage());
        }
        extent.flush();
    }
}
