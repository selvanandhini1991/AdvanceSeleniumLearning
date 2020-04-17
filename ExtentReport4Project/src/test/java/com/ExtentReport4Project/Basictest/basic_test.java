package com.ExtentReport4Project.Basictest;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ExtentReport4Project.Drives.mainclass;
import com.ExtentReport4Project.Library.Clothing_PLP;
import com.ExtentReport4Project.Library.HomePage;
import com.aventstack.extentreports.Status;

public class basic_test extends mainclass{
	public static WebDriver driver;
	static HomePage hp ;
	static Clothing_PLP plp;
	
	public basic_test() {
		super();
	}
	
	@BeforeMethod
	public static void setUp() {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\s.subramaniam\\Documents\\Selenium\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://www.maurices.com/");
//		driver.manage().window().maximize();
		hp = new HomePage();
		plp = new Clothing_PLP();
		
	}
	
	@Test(priority=1)
	public void HomePage_Title() {
		test =extent.createTest("HomePage_Title");
		String title = 	hp.homePageTitle();
		Assert.assertEquals(title,"maurices | Women's Fashion Clothing for Sizes 0-24 | maurices");
		test.log(Status.PASS, "Homepage title is verified");
	}
	@Test(priority=2)
	public void Clothing_Submenu() {
		test = extent.createTest("Clothing_Submenu");
		hp.verify_clothing_submenu();
		test.log(Status.PASS, "Clothing submenu is verified");
	}
	@Test(priority=3)
	public void Navigate_Clothing() {
		hp.nav_clothing();
	}
	@Test(priority=4)
	public void Clothing_Title() {	
		if(plp.PLP_Title()){
			String plp_title = plp.PLP_TextTitle();
			Assert.assertEquals(plp_title, "clothing");
		}else {
			System.out.println("clothing title is not displayed");
		}
	}
	@Test(priority=5)
	public static void nav_PDP() {
		if(plp.PLP_Items()) {
			plp.pick_random_item();
		}else {
			System.out.println("No items are displayed in PLP");
		}
	}
	

}
