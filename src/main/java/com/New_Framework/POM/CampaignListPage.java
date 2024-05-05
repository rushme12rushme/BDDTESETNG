package com.New_Framework.POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignListPage {
	@FindBy (xpath="//input[@value='New Campaign']")
	private WebElement NewCampaignBtn;

	public CampaignListPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void setNewCampaign()
	{
		NewCampaignBtn.click();
	}
}

