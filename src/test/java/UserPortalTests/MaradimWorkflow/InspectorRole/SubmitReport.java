package UserPortalTests.MaradimWorkflow.InspectorRole;

import Pages.UserPortal.GenericPages.HomePage;
import Pages.UserPortal.GenericPages.ReportDetailsPage;
import Pages.UserPortal.MaradimCustomPages.MaradimCheckList;
import UserPortalTests.Generic.LoginTests;
import UserPortalTests.Generic.LogoutTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import GlobalSetup.GlobalSetup;

/**
 * This class contains tests for the report submission functionality of the user portal.
 * It extends the GlobalSetup class to inherit its setup and teardown methods.
 */
public class SubmitReport extends GlobalSetup {
    /**
     * HomePage object representing the home page of the user portal.
     */
    HomePage homePage = new HomePage(driver.getWebDriver());

    /**
     * MaradimCheckList object representing the Maradim checklist page of the user portal.
     */
    MaradimCheckList maradimCheckList = new MaradimCheckList(driver.getWebDriver());

    /**
     * ReportDetailsPage object representing the report details page of the user portal.
     */
    ReportDetailsPage reportDetailsPage = new ReportDetailsPage(driver.getWebDriver());

    /**
     * LogoutTests object representing the logout tests of the user portal.
     */
    LogoutTests logoutTests = new LogoutTests();

    /**
     * The path to the JSON file containing the test data for the report submission tests.
     */
    String testData = "TestData/Data/MaradimData.json";

    /**
     * Prepares the data for the test by logging in as an inspector and filling out the Maradim checklist.
     */
    @BeforeMethod(description = "prepare the data for the test")
    public void fillTestDate() {
        // Implementation omitted for brevity
    }

    /**
     * Tests that the inspector can submit a report.
     * Asserts that the successful message is displayed and that the report state and assignee are correct.
     */
    @Test(description = "Check that the inspector can navigate to Maradim CheckList" )
    public void checkThatTheInspectorCanSubmitReport() {
        // Implementation omitted for brevity
    }

    /**
     * Logs out after the test class has finished executing all tests.
     */
    @AfterClass
    public void clickOnSignOut() {
        // Implementation omitted for brevity
    }
}