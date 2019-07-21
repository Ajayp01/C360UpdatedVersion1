package com.qa.collateral.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.collateral360.JPMC.RES.Pages.AdminDashboardPage;
import com.collateral360.JPMC.RES.Pages.LoginPage;
import com.collateral360.qa.base.*;

public class AdminDashboardPageTest extends Base{
     public AdminDashboardPageTest() throws Exception {
		super();
	}
     
	 AdminDashboardPage adminDashboardPageObj;
	 LoginPage loginPageObj;
	 String aid=null;
	
	 
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization("Collateral");
		loginPageObj=new LoginPage();
	}
	
	@Test(priority=1)
	public void loggedUserNameTest()
	{
		String UserName=adminDashboardPageObj.validateLoggedUserName();
		Assert.assertEquals(UserName, "AJAY", "User name did not match");
	}
	
	@Test(priority=2)
	public void impersonateTest() throws Exception
	{
		adminDashboardPageObj.Impersonate("collateral",aid);
	} 
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		System.out.println("Passed  " + result.getMethod().getMethodName());
		driver.quit();
	}
	
	
	
	
	
	
	
}
