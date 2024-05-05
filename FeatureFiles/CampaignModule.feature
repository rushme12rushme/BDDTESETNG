@CreateCampaign
Feature: Campaign
Scenario: Create Campaign
Given User Should be present in Altius HomePage "Zoho CRM - Home Page"
And User Clicks on Campaign Tab
And User Clicks on New Campaign
Then Create Campaign page should be displayed "Zoho CRM - Create Campaign"	
And User enters all the campaign details
When User Clicks on Save Button
Then New Campaign should be created