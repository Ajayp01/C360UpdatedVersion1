package com.collateral360.JPMC.RES.Pages;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.collateral360.qa.base.Base;

public class ReportStatusPage extends Base {

	public ReportStatusPage() throws Exception {
		super();
	}
	
	By ReportStatusButton=By.xpath("//div[@id='siteMenu']/ul/li[4]/a[text()='Report Status']");
	public void checkRFPStatus(int i) throws Exception
	{
		@SuppressWarnings("unchecked")
		ArrayList<String> VALService=e.ReadServices("SERVICES", 2, 0);
		Object s= VALService.get(0);
		String fee=e.ReadExcel("RFP", 5, 16);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(ReportStatusButton).click();
		Thread.sleep(5000);
		String Status=driver.findElement(By.xpath("//*[@id='procuredServicesInner']/table[1]/tbody/tr[//td[contains(text(),'"+fee+"')] and //td[text()='"+s+"']]//td[8]")).getText();
		if(i==1)
		{
			Assert.assertEquals(Status, "Awarded");
			
		}	
		else if(i==2)
		{
			Assert.assertEquals(Status, "Accepted");
		}
		else
	    {
			Assert.assertEquals(Status, "Uploaded");
	    }
			
	}
	
	
}
