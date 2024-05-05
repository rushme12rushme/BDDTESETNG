package com.New_Framework.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		@FindBy (xpath="//a[contains(text(),'Campaigns')]")
		private WebElement CampaignsTab;
		
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setCampaignsTab() {
		CampaignsTab.click();
	}
	 
	
	
}
