package UserPortalTests.RoadComponentWorkflow.MOSRole;

import GlobalSetup.GlobalSetup;
import Pages.UserPortal.GenericPages.HomePage;
import Pages.UserPortal.GenericPages.LoginPage;
import org.testng.annotations.Test;

public class ApproveByMOSTCs extends GlobalSetup {
    LoginPage loginPage=new LoginPage(driver.getWebDriver());
    HomePage homePage=new HomePage(driver.getWebDriver());
    @Test
    public void approveReportTest() throws InterruptedException {
        //loginPage.fillLoginForm("MM11","123456");
        //homePage.navigateToTaskPage().navigateToReportDetailsPage().ApproveByMOS();
    }
}
