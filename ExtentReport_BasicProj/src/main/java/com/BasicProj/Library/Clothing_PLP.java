package com.BasicProj.Library;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasicProj.Drives.mainclass;
import com.BasicProj.Utils.commonActions;

public class Clothing_PLP extends mainclass{
	
	@FindBy(xpath ="//h1[@class='mar-plp-header-title']")
	WebElement PLP_Title;
	
	@FindBy(xpath="//div[@class='mar-product-item-image-holder']")
	List<WebElement> PLP_Items;
	
	public Clothing_PLP(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean PLP_Title() {
		return PLP_Title.isDisplayed();
	}
	
	public String PLP_TextTitle() {
		return PLP_Title.getText();
	}
	public boolean PLP_Items() {
		int count = PLP_Items.size();
		if(count>0) {
			return true;
		}else return false;
	}
	public void pick_random_item() {
		commonActions ca = new commonActions(driver);
		int idx=ca.rand_itemNo(PLP_Items);
		PLP_Items.get(idx).click();
	}

}
