package collateral.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.collateral360.JPMC.RES.Pages.*;
import com.parcel.pages.AllProjects;
import com.parcel.pages.PARCELDashboard;
import com.parcel.pages.ProjectDetails;
import com.collateral360.qa.base.*;;

public class SrfTest extends Base {
	
	
	public SrfTest() throws Exception {
		super();
	}
	
	public String aid;
	LoginPage loginPageObj;
	AdminDashboardPage adminDashboardPageObj;
	DashboardPage dashboardPage;
	SrfPage l;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		driver=initialization("Collateral");
		loginPageObj=new LoginPage();
		loginPageObj.SignIn();
		adminDashboardPageObj=new AdminDashboardPage();
		adminDashboardPageObj.Impersonate("collateral", aid);
		dashboardPage=new DashboardPage();
		dashboardPage.clickOnCreateRequestButton();	
		l=new SrfPage();
	}
	
	//@Test(priority=1)
	public void closeButtonTest()
	{
		l.validateCloseButton();
	}
	@Test(priority=2)
	public void resCreateSRF() throws Exception
	{		
		l.RESCreateLoan();
	}
	//@Test(priority=3)
	public void isSRFCreated() throws Exception
	{
		DashboardPage d=new DashboardPage();
		d.verifyCreatedLoan();
		
	}
	
	//@Test(priority=4)
	public void openLoanCreated() throws Exception 
	{
		DashboardPage d=new DashboardPage();
		d.verifyCreatedLoan();
		d.openLoan();
		
	}
	
	//@Test(priority=5)
	public void OpenExistingLoan() throws Exception 
	{
		DashboardPage d=new DashboardPage();
		
		
	}
	
	//@Test(priority=6)
	public void Taskpipeline() throws Exception
	
	{
		CollateralOverview j=new CollateralOverview();
		j.AddNewServices();
		j.CheckServicesAddedOrNOT();
	}
	
    //@Test(priority=7)
	public void CreateRFP() throws Exception
	{
		RFP r=new RFP();
		r.createRFP();
		ReportStatusPage s=new ReportStatusPage();
		s.checkRFPStatus(1);
	}
   
   //@Test(priority=8)
	public void UpdateRFP() throws Exception
	{
		RFP u=new RFP();
		aid=u.updateRFP();	
	}	
   
    //@Test(priority=9)
	public void OpenPARCEL() throws Exception
	{
		driver=initialization("PARCEL");
		AdminDashboardPage o=new AdminDashboardPage();
		o.Impersonate("parcel",aid);
	}
	
	//@Test(priority=10)
	public void CheckBidAtPARCEL() throws Exception
	{
		PARCELDashboard p=new PARCELDashboard();
		p.OpenBid();
	}
	
	//@Test(priority=11)
	public void AcceptAward() throws Exception
	{
		ProjectDetails p=new ProjectDetails();
		p.AcceptAward();
		ReportStatusPage r=new ReportStatusPage();
		r.checkRFPStatus(2);
	}
	
	//@Test(priority=12)
	public void SendReport() throws Exception
	{
		AllProjects r=new AllProjects();
		r.ViewDetails();
		ProjectDetails p=new ProjectDetails();
		p.SendReport();
	}
	
	//@Test(priority=13)
	public void ReportStatus() throws Exception
	{
		ReportStatusPage r=new ReportStatusPage();
		r.checkRFPStatus(3);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}
	
	
}
