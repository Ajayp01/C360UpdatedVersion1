package collateral.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.collateral360.JPMC.RES.Pages.AdminDashboardPage;
import com.collateral360.JPMC.RES.Pages.CollateralOverview;
import com.collateral360.JPMC.RES.Pages.DashboardPage;
import com.collateral360.JPMC.RES.Pages.LoginPage;
import com.collateral360.JPMC.RES.Pages.RFP;
import com.collateral360.qa.base.Base;

public class RFPTest extends Base {

	public RFPTest() throws Exception {
		super();
	}
	
	//OR
	LoginPage LoginPageObj;
	AdminDashboardPage AdminDashboardPageObj;
	String aid=null;
	DashboardPage DashboardPageObj;
	CollateralOverview CollateralOverviewObj;
	RFP RFPObj;
	String vendorId=null;
	@BeforeMethod
	public void setup() throws Exception {
		driver=initialization("collateral");
		LoginPageObj=new LoginPage();
		LoginPageObj.SignIn();
		AdminDashboardPageObj=new AdminDashboardPage();
		AdminDashboardPageObj.Impersonate("collateral", aid);
		DashboardPageObj=new DashboardPage();
		DashboardPageObj.verifyCreatedLoan();
		DashboardPageObj.openLoan();
		CollateralOverviewObj=new CollateralOverview();
		CollateralOverviewObj.AddNewServices();
		CollateralOverviewObj.ClickOnValuation();
		RFPObj=new RFP();
	}
	
	@Test(priority=1)
	public void createRfpTest() throws Exception {
		vendorId=RFPObj.createRFP();
		System.out.println("RFP has procured to Vendor with id= " + vendorId);
	}
}
