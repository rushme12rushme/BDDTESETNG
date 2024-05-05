package StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.New_Framework.POM.CampaignDetails;
import com.New_Framework.POM.CampaignListPage;
import com.New_Framework.POM.CampaignPage;
import com.New_Framework.POM.HomePage;
import com.New_Framework.generic.Baseclass;
import com.New_Framework.generic.FileLib;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CampaignModule {
	WebDriver driver=Baseclass.driver;
	CampaignPage cp=new CampaignPage(driver);
	ArrayList<String> al=new ArrayList<>();

	@Given("User Should be present in Altius HomePage {string}")
	public void user_should_be_present_in_altius_home_page(String HomePageTitle) {
		String actual=driver.getTitle();
		actual=actual.trim();
		System.out.println(actual);
		Assert.assertEquals(actual, HomePageTitle);
	}
	@Given("User Clicks on Campaign Tab")
	public void user_clicks_on_campaign_tab() {
		HomePage h=new HomePage(driver);
		h.setCampaignsTab();
	}

	@And("User Clicks on New Campaign")
	public void user_clicks_on_new_campaign() {
		CampaignListPage cl=new CampaignListPage(driver);
		cl.setNewCampaign();
	}

	@Then("Create Campaign page should be displayed {string}")
	public void create_campaign_page_should_be_displayed(String CrCampaignPageTitle) {
		String actual=driver.getTitle();
		actual=actual.trim();
		System.out.println(actual);
		Assert.assertEquals(actual, CrCampaignPageTitle);
	}

	@And("User enters all the campaign details")
	public void user_enters_all_the_campaign_details() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileLib f=new FileLib();
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
	}

	@When("User Clicks on Save Button")
	public void user_clicks_on_save_button() {
		cp.setSaveBtn();
	}

	@Then("New Campaign should be created")
	public void new_campaign_should_be_created() {
		CampaignDetails cd=new CampaignDetails(driver);
		String actual=cd.getCampaignNameValue();
		String exp=al.get(0);
		System.out.println(actual);
		Assert.assertEquals(actual, exp);
	}





}
