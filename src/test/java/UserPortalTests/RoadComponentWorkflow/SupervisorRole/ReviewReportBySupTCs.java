package UserPortalTests.RoadComponentWorkflow.SupervisorRole;

import GlobalSetup.GlobalSetup;
import Pages.UserPortal.GenericPages.HomePage;
import Pages.UserPortal.GenericPages.LoginPage;
import org.testng.annotations.Test;

public class ReviewReportBySupTCs extends GlobalSetup {
    LoginPage loginPage = new LoginPage(driver.getWebDriver());
    HomePage homePage = new HomePage(driver.getWebDriver());
    /**Assign To MOS TCs after reviewing**/
    @Test
    public void reviewReportTestAndAssignToMOS() throws InterruptedException {
      //  loginPage.fillLoginForm("33K", "123456");
        //homePage.navigateToTaskPage().navigateToReportDetailsPage().firstLevelOfApprove();
    }
    /**Assign To Unit TCs after reviewing**/
    @Test
    public void reviewReportTestAndAssignToUnit() throws InterruptedException {
       // loginPage.fillLoginForm("33K", "123456");
        //homePage.navigateToTaskPage().navigateToReportDetailsPage().assignReportToUnit();
    }
    /**Reject the assigned report TCs after reviewing**/
    @Test
    public void rejectAssignedReportTest() throws InterruptedException {
       // loginPage.fillLoginForm("33K", "123456");
       // homePage.navigateToTaskPage().navigateToReportDetailsPage().rejectReportBySup();
    }
    /**Reject the assigned report TCs after reviewing and close it**/
    @Test
    public void CloseTheRejectedReportTest() throws InterruptedException {
       // loginPage.fillLoginForm("33K", "123456");
       // homePage.navigateToTaskPage().navigateToReportDetailsPage().CloseTheRejectedReportBySup();
    }
    /**assign the rejected report to the inspector after reviewing it**/
    @Test
    public void AssignTheRejectedReportToInspector() throws InterruptedException {
       // loginPage.fillLoginForm("33K", "123456");
       // homePage.navigateToTaskPage().navigateToReportDetailsPage().assignReportToInspector();
    }
    /**Review the MOS treatment**/
    @Test
    public void reviewProcessingOFMOSTcs() throws InterruptedException {
       // loginPage.fillLoginForm("33K", "123456");
       // homePage.navigateToTaskPage().navigateToReportDetailsPage().approveMOS();
    }
    /**Review the Unit Con treatment and approve**/
    @Test
    public void reviewProcessingOFUnitConTcs() throws InterruptedException {
        //loginPage.fillLoginForm("33K", "123456");
       // homePage.navigateToTaskPage().navigateToReportDetailsPage().reviewTheReportHandledByUnitConAndApprove();
    }
}
