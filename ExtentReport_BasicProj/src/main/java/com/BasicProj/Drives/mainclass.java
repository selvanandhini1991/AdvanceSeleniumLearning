package com.BasicProj.Drives;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class mainclass {
	public static WebDriver driver;
	public static Properties props;
	
	@BeforeSuite
	public static void properties_setup() throws IOException{
		String path = "./src/main/resources/config.properties";
		File file = new File(path);
		FileReader reader = new FileReader(file);
		props = new Properties();
		props.load(reader);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\s.subramaniam\\Documents\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = props.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
	}	
//	// All the tear down operations occur, since Reporting is done at the end of every test method
//		@AfterMethod
//		public void tearDown(ITestResult testResult) {
//			if (driver != null)
//				driver.quit();
//		}
	
//	@AfterSuite
//	public static void tearDown() {
//		driver.quit();
//	}


}
