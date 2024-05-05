package com.New_Framework.generic;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Baseclass {
	public static WebDriver driver;
	@BeforeClass
	@Before(order=1)
	public void OpenBrowser() {
System.out.println("Open Browser");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod
	@Before(order=2)
	public void login() throws IOException
	{
		System.out.println("Login app");

		Reporter.log("Login",true);
		FileLib fl=new FileLib();

		String url=fl.getPropertyFileData("url");
		driver.get(url);
		String un=fl.getPropertyFileData("username");
		String pwd=fl.getPropertyFileData("pwd");
		driver.findElement(By.id("userName")).sendKeys(un);
		driver.findElement(By.id("passWord")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();

	}
	@AfterMethod
	@After(order=2)
	public void Logout() {
		System.out.println("Logout");

		Reporter.log("Logout",true);
		//driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		//Reporter.log("Logout");
	}
	@AfterClass
	@After(order=1)
	public void CloseBrowser() {
		System.out.println("Close Browser");

		//driver.quit();
	}
}






