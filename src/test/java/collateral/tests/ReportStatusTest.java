package collateral.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.collateral360.JPMC.RES.Pages.AdminDashboardPage;
import com.collateral360.JPMC.RES.Pages.CollateralOverview;
import com.collateral360.JPMC.RES.Pages.DashboardPage;
import com.collateral360.JPMC.RES.Pages.LoginPage;
import com.collateral360.JPMC.RES.Pages.RFP;
import com.collateral360.JPMC.RES.Pages.ReportStatusPage;
import com.collateral360.qa.base.Base;

public class ReportStatusTest extends Base {

	public ReportStatusTest() throws Exception {
		super();
	}

	LoginPage LoginPageObj;
	AdminDashboardPage AdminDashboardPageObj;
	DashboardPage DashboardPageObj;
	CollateralOverview CollateralOverviewObj;
	RFP RFPObj;
	ReportStatusPage ReportStatusPageObj;
	String aid=null;
	
	
	
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
	}
	
	@Test(priority=1)
	public void validateServiceStatus() throws Exception {
		ReportStatusPageObj=new ReportStatusPage();
		ReportStatusPageObj.checkRFPStatus(1);
	}
	
	
	
	
}
