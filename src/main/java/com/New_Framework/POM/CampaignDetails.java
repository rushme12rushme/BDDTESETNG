package com.New_Framework.POM;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignDetails {
	@FindBy (id="value_Campaign Name")
	private WebElement CampaignNameValue;
	
	public CampaignDetails(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getCampaignNameValue()
	{
		
		return CampaignNameValue.getText();
	}

}
