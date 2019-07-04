package com.collateral360.qa.base;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.collateral360.qa.utilities.Excel;

public class Base {
	public static Excel e;
	public static WebDriver driver;
	public Base() throws Exception {
		try
		{
			e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		}catch (FileNotFoundException e) {
			e.printStackTrace();			
		}catch(IOException e) {
			e.printStackTrace();}
}


	 public WebDriver initialization(String Key) throws Exception
	 {

		browser(Key);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(e.ReadExcel("Sheet1", 2, 1));
		Thread.sleep(5000);
		return driver;
	 }
	 
	 private static void browser(String Key) throws Exception {
			String name = null;
			if(Key.equalsIgnoreCase("collateral"))
			{	
				 name=e.ReadExcel("sheet1", 1, 1);
			}
			else if(Key.equalsIgnoreCase("PARCEL"))
			{
				
				 name=e.ReadExcel("sheet1", 8, 1);
			}
			
			
			if(name.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			
			
			if(name.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
		    }
		
			if(name.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", "src\\test\\resources\\Drivers\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}	
		 
	 }

}
	
