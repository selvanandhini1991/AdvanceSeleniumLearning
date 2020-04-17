package com.BasicProj.Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasicProj.Drives.mainclass;
import com.BasicProj.Utils.commonActions;

public class HomePage extends mainclass{
	@FindBy(xpath = "//svg[@id='mau_logo']")
	WebElement logo;
	
	@FindBy(xpath= "//ul[@class='mar-nav  ']")
	WebElement menuBar;
	
	@FindBy(xpath="//ul[@class='mar-subnav-links-column']")
	WebElement hoverMenu;
	
	@FindBy(xpath= "//a[@class='asc-nav-parent menu asc-nav-category'][contains(text(),'CLOTHING')]")
	WebElement clothing;
	
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verify_menuBar() {
		return menuBar.isDisplayed();
	}
	
	public void nav_clothing() {
		clothing.click();
	}
	
	public boolean hoverMenu_dis() {
		return hoverMenu.isDisplayed();
	}
	public void verify_clothing_submenu() {
		commonActions ca = new commonActions(driver);
		ca.mousehover(clothing);
		boolean hover = hoverMenu_dis();
		if (hover) {
			System.out.println("Hover menu is displayed");
		}else {
			System.out.println("Hovermenu is not displayed");
		}
		
	}

}
