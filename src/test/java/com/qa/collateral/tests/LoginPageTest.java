package com.qa.collateral.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.collateral360.JPMC.RES.Pages.LoginPage;
import com.collateral360.qa.base.*;

public class LoginPageTest extends Base{
			
			
	public LoginPageTest() throws Exception {
		super();
	}			
	LoginPage loginPageObj;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		driver=initialization("Collateral");
		loginPageObj=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String currentTitle=loginPageObj.validateLoginPageTitle();
		Assert.assertEquals(currentTitle, "Collateral360");
	}
	
	@Test(priority=2)
	public void signTest() throws Exception
	{
		loginPageObj.SignIn();
 	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		System.out.println(" Passed: "  + result.getMethod().getMethodName());
		driver.quit();
	}

}
