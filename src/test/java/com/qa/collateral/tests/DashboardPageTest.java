package com.qa.collateral.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.collateral360.JPMC.RES.Pages.AdminDashboardPage;
import com.collateral360.JPMC.RES.Pages.DashboardPage;
import com.collateral360.JPMC.RES.Pages.LoginPage;
import com.collateral360.qa.base.*;

public class DashboardPageTest extends Base{

	
	 public DashboardPageTest() throws Exception {
		super();
	}

	 LoginPage loginPageObj;
	 AdminDashboardPage adminDashboardPageObj;
	 public WebDriver driver;
	 String aid=null;
	 DashboardPage dashboardPageObj;
	 
	@BeforeMethod
	public void setup() throws Exception
	{
		driver=initialization("Collateral");
		loginPageObj=new LoginPage();
		loginPageObj.SignIn();
		adminDashboardPageObj=new AdminDashboardPage();
		adminDashboardPageObj.Impersonate("collateral", aid);
	    dashboardPageObj=new DashboardPage();
	}
	
	@Test(priority=1)
	public void dashboardPageTitleTest()
	{
		String currentTitle=dashboardPageObj.dashboardPageTitle();
		Assert.assertEquals(currentTitle, "Collateral360");
	}
	
	@Test(priority=2)
	public void logoTest() throws InterruptedException
	{
		boolean currentLogo=dashboardPageObj.logo();
		Assert.assertTrue(currentLogo, "Logo not displayed");
	}
	
	
	@Test(priority=3)
	public void CreateRequestButtonTest()
	{
		boolean IsButtonAvailable=dashboardPageObj.validateCreateRequestButton();
		Assert.assertTrue(IsButtonAvailable, "Create Request Button is not available");
	}

	@AfterMethod
	public void teardown(ITestResult result)
	{
		System.out.println("Passed  " + result.getMethod().getMethodName());
		driver.quit();
	}
}
