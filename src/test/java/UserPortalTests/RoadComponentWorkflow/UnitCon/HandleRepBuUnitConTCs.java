package UserPortalTests.RoadComponentWorkflow.UnitCon;

import GlobalSetup.GlobalSetup;
import Pages.UserPortal.GenericPages.HomePage;
import Pages.UserPortal.GenericPages.LoginPage;
import org.testng.annotations.Test;

public class HandleRepBuUnitConTCs extends GlobalSetup {

    LoginPage loginPage = new LoginPage(driver.getWebDriver());
    HomePage homePage = new HomePage(driver.getWebDriver());
    /**Handle the report by the contractor and assign to unit sup**/
    @Test
    public void HandleReportTCs() throws InterruptedException {
        //loginPage.fillLoginForm("CCAQ", "123456");
        //homePage.navigateToTaskPage().navigateToReportDetailsPage().handleTheReportByUnitCon();
    }
}
