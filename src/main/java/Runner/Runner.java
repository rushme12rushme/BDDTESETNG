package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="./FeatureFiles/CampaignModule.feature",
glue= {"StepDefinitions","com.New_Framework.generic"},
dryRun=false,plugin="html:target/report.html",
tags="@CreateCampaign")
public class Runner extends AbstractTestNGCucumberTests {
}

