package com.BasicProj.Utils;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class commonActions {
	Actions action;
	Random rand;
	WebDriver driver;
	
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

}
