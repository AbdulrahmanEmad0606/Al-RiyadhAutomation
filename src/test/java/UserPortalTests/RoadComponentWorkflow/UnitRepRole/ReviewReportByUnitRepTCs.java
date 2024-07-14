package UserPortalTests.RoadComponentWorkflow.UnitRepRole;

import GlobalSetup.GlobalSetup;
import Pages.UserPortal.GenericPages.HomePage;
import Pages.UserPortal.GenericPages.LoginPage;
import org.testng.annotations.Test;

public class ReviewReportByUnitRepTCs extends GlobalSetup {

    LoginPage loginPage = new LoginPage(driver.getWebDriver());
    HomePage homePage = new HomePage(driver.getWebDriver());
    @Test
    public void approveReportByUnitRep() throws InterruptedException {
       // loginPage.fillLoginForm("44VV", "123456");
      //  homePage.navigateToTaskPage().navigateToReportDetailsPage().approveReportByUnitRepAndAssignToUnitCont();
    }
    /**Reject the assigned report**/
    @Test
    public void rejectReportByUnitRep() throws InterruptedException {
        //loginPage.fillLoginForm("44VV", "123456");
        //homePage.navigateToTaskPage().navigateToReportDetailsPage().rejectReportByUnitRep();
    }
    @Test
    public void assignToUnitConTC() throws InterruptedException {
        //loginPage.fillLoginForm("44VV", "123456");
       // homePage.navigateToTaskPage().navigateToReportDetailsPage().assignToUnitCon();
    }

}
