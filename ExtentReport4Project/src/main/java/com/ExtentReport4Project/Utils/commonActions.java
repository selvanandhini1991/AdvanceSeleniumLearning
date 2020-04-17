package com.ExtentReport4Project.Utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class commonActions {
	Actions action;
	Random rand;
	static WebDriver driver;
	
	public commonActions(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
	}
	public void mousehover(WebElement ele) {
		action.moveToElement(ele).perform();	
	}
	public int rand_itemNo(List<WebElement> ele) {
		rand = new Random();
		int rand_number = rand.nextInt(ele.size());
		return rand_number;
	}
	
	public String captureScreenshot(String TCName) {
		try {
			System.out.println(TCName);
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = "C:\\Users\\s.subramaniam\\eclipse-workspace\\BasicProj\\Screenshots"
								+TCName+".png";
			System.out.println(dest);
			File destination = new File(dest);
			FileUtils.copyFile(source,destination);
			System.out.println("Screenshot taken");
			return dest;
		}catch(Exception e) {
			System.out.println("Exception while taking screenshot "+ e.getMessage());
			return e.getMessage();
		}
		
	}
}
