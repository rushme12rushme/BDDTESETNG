package com.New_Framework.testscript;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.New_Framework.POM.CampaignDetails;
import com.New_Framework.POM.CampaignListPage;
import com.New_Framework.POM.CampaignPage;
import com.New_Framework.POM.HomePage;
import com.New_Framework.generic.Baseclass;
import com.New_Framework.generic.FileLib;

public class CampaignModule {
@Test
public void CreateCampaign() throws EncryptedDocumentException, InvalidFormatException, IOException
{
	WebDriver driver=Baseclass.driver;
	HomePage h=new HomePage(driver);
	h.setCampaignsTab();
	CampaignListPage cl=new CampaignListPage(driver);
	cl.setNewCampaign();
	CampaignPage cp=new CampaignPage(driver);
	FileLib f=new FileLib();
	ArrayList<String> al=new ArrayList<>();
	for(int i=0;i<11;i++)
	{
	String data=f.getExcelFileData("CreateCampaign", 1, i);
	al.add(data);
	}
	cp.setCampaignNametxtbx(al.get(0));
	cp.setStartDatetbx(al.get(1));
	cp.setExpectedRevenuetbx(al.get(2));
	cp.setActualCosttbx(al.get(3));
	cp.setNumSenttbx(al.get(4));
	cp.setCampaignTypeDropDown( al.get(5));
	cp.setCampaignStatusDropDown( al.get(6));
	cp.setEndDatetbx(al.get(7));
	cp.setBudgetedCosttbx(al.get(8));
	cp.setExpectedResponsetbx(al.get(9));
	cp.setDescriptiontbx(al.get(10));
	cp.setSaveBtn();
	CampaignDetails cd=new CampaignDetails(driver);
	String actual=cd.getCampaignNameValue();
	String exp=al.get(0);
	Assert.assertEquals(actual, exp);
}
	
}
