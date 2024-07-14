package UserPortalTests.RoadComponentWorkflow.UnitSupervisor;

import GlobalSetup.GlobalSetup;
import Pages.UserPortal.GenericPages.HomePage;
import Pages.UserPortal.GenericPages.LoginPage;
import org.testng.annotations.Test;

public class ReviewReportUnitSupTCs extends GlobalSetup {
    LoginPage loginPage = new LoginPage(driver.getWebDriver());
    HomePage homePage = new HomePage(driver.getWebDriver());
    /***Reject the treatment of the contractor**/
    @Test
    public void reviewAndRejectByUnitSup() throws InterruptedException {
       // loginPage.fillLoginForm("bb7", "123456");
        //homePage.navigateToTaskPage().navigateToReportDetailsPage().reviewTheReportByUnitSupAndReject();
    }
    /**approve the assigned report**/
    @Test
    public void approveReportByUnitRep() throws InterruptedException {
        //loginPage.fillLoginForm("bb7", "123456");
        //homePage.navigateToTaskPage().navigateToReportDetailsPage().reviewTheReportByUnitSupAndApprove();
    }
}
