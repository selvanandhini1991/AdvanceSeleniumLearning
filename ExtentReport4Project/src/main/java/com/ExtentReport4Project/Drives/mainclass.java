package com.ExtentReport4Project.Drives;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.ExtentReport4Project.Utils.commonActions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class mainclass{
	public static WebDriver driver;
	public static Properties props;
	public ExtentHtmlReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeSuite
	public void properties_setup() throws IOException{
		
		String path = "./src/main/resources/config.properties";
		File file = new File(path);
		FileReader reader = new FileReader(file);
		props = new Properties();
		props.load(reader);
//		reporter = new ExtentHtmlReporter("C:\\Users\\s.subramaniam\\eclipse-workspace\\ExtentReports\\ExtentReport4Project.html");
		reporter = new ExtentHtmlReporter(props.getProperty("extentreportpath"));
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\s.subramaniam\\Documents\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = props.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
	}	
	
	
	// All the tear down operations occur, since Reporting is done at the end of every test method
		@AfterMethod
		public void tearDown(ITestResult testResult) {
			if(testResult.getStatus()==ITestResult.FAILURE) {
				commonActions ca = new commonActions(driver);
				String screenshot_path = ca.captureScreenshot(testResult.getName());
				try {
					test.fail("details").addScreenCaptureFromPath(screenshot_path);
					driver.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				commonActions ca = new commonActions(driver);
				String screenshot_path = ca.captureScreenshot(testResult.getName());
				try {
					test.pass("details").addScreenCaptureFromPath(screenshot_path);
					driver.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			extent.flush();
			
		}

		// The extent reporting is done for each suite. The extent/HTML report is flushed and closed
		@AfterSuite
		public void flush() {
			extent.flush();
			driver.close();

		}



}
