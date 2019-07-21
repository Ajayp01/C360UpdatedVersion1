package com.collateral360.JPMC.RES.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.collateral360.qa.base.Base;
import com.collateral360.qa.utilities.Wait;
public class DashboardPage extends Base {
	
	public DashboardPage() throws Exception {
		super();
	}
	
	//Dashbaord
		By OpenTab=By.xpath("//*[@id='divDashBody']/div/ul/li[2]/a");
		//ul[@class='nav nav-tabs lp-tabs']/li[2]/a[@href='#openOrders']"
		By LoanLabel=By.xpath("//label[@class='inline']");
		By EnterProjectName=By.xpath("//div[@id='openOrders']//thead//tr[2]/th[5]");
		//By EnterBorrowerName=By.xpath("//div[@id='openOrders']//thead//tr[2]/th[19]");
		By EnterAddress=By.xpath("//div[@id='openOrders']//thead//tr[2]/th[6]");
		By logo=By.xpath("//img[@id='imgLogo']");
		//By logo=By.xpath("//img[@id='imgLogo']");
		By createRequestButton=By.xpath("//a[@data-title='Create New Request']");
		By settingsButton=By.xpath("//button[contains(@id,'SettingsButton')]");
	
	 String projectname;
	 String address;
	 String Borrower;
	 int i;
	 Actions g;
	 
	public void verifyCreatedLoan() throws Exception
	{
		Thread.sleep(5000);
		//driver.switchTo().defaultContent();
		driver.findElement(OpenTab).click();
	    projectname=e.ReadExcel("JPMC", 5, 1);
		address=e.ReadExcel("JPMC", 9, 4);
		
		//Thread.sleep(15000);
		i=enterDataInFilter("Address");
		g=new Actions(driver);
		g.moveToElement(driver.findElement(By.xpath("//div[@id='openOrders']//thead//tr[2]/th["+i+"]"))).click().sendKeys(address).build().perform();
		
		i=enterDataInFilter("Project Name");
		g.moveToElement(driver.findElement(By.xpath("//div[@id='openOrders']//thead//tr[2]/th["+i+"]"))).click().sendKeys(projectname).build().perform();

		Thread.sleep(15000);
			try {	
			String p=driver.findElement(By.xpath("//tbody/tr/td/label")).getText();	
			if(p.contains(address))
			{
				System.out.println("Laon Created Successfully ");
			}
			}
			catch(Exception e)
			{
				System.out.println("Loan has not created so not found on dashboard ");
			}
		
	}
	
	
	public void openLoan() throws InterruptedException
	{
		Thread.sleep(7000);
		try
		{
			    Actions a=new Actions(driver);
				//a.moveToElement(driver.findElement(By.xpath("//*[@id='openOrders-table']/tbody/tr[td[8 and text()='"+address+"'] and td[6 and text()='"+projectname+"']]"))).doubleClick().build().perform();
			    a.moveToElement(driver.findElement(By.xpath("//*[@id='openOrders-table']/tbody/tr[2]"))).doubleClick().build().perform();
		}
		catch(Exception e)
		{
			System.out.println("Loan not created or not found on dashboard ");
			
		}
		Thread.sleep(25000);
			
	}
	
	public String dashboardPageTitle()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
	    wait.until(ExpectedConditions.titleContains("Collateral360"));
		return driver.getTitle();
	}
	
	public boolean logo() throws InterruptedException
	{
		/*WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(logo));*/
		Thread.sleep(10000);
		return driver.findElement(logo).isDisplayed();
	}
	
	public boolean validateCreateRequestButton()
	{
		return driver.findElement(createRequestButton).isDisplayed();
	}
	
	public void clickOnCreateRequestButton()
	{
		WebElement Button=driver.findElement(settingsButton);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(Button));
		driver.findElement(createRequestButton).click();
	}
	
	private int enterDataInFilter(String key) {

		int totalColumns=driver.findElements(By.xpath("//div[@id='openOrders']/div/div[2]/table/thead/tr[1]//th")).size();
		int count;
		for(count=1;count<=totalColumns;count++) {
			String value=driver.findElement(By.xpath("//div[@id='openOrders']/div/div[2]/table/thead/tr[1]//th["+count+"]")).getText();
			if(value.equalsIgnoreCase(key)) {
				break;
			}	
		}
		return count;
	}
	
	

}
