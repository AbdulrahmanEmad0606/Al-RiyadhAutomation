package UserPortalTests.MaradimWorkflow.SupervisorRole;

import GlobalSetup.GlobalSetup;
import Pages.UserPortal.GenericPages.HomePage;
import Pages.UserPortal.GenericPages.ReportDetailsPage;
import Pages.UserPortal.MaradimCustomPages.MaradimCheckList;
import UserPortalTests.Generic.LoginTests;
import UserPortalTests.Generic.LogoutTests;
import org.testng.annotations.*;

/**
 * This class contains tests for the supervisor role in the Maradim workflow.
 * It extends the GlobalSetup class to inherit its setup and teardown methods.
 */
public class NavigateToTasksTCs extends GlobalSetup {
    /**
     * HomePage object representing the home page of the user portal.
     */
    HomePage homePage;

    /**
     * ReportDetailsPage object representing the report details page of the user portal.
     */
    ReportDetailsPage reportDetailsPage;

    /**
     * LoginTests object representing the login tests of the user portal.
     */
    LoginTests loginTests;

    /**
     * The path to the JSON file containing the test data for the supervisor tests.
     */
    String testData;

    /**
     * MaradimCheckList object representing the Maradim checklist page of the user portal.
     */
    MaradimCheckList maradimCheckList = new MaradimCheckList(driver.getWebDriver());

    /**
     * LogoutTests object representing the logout tests of the user portal.
     */
    LogoutTests logoutTests = new LogoutTests();

    /**
     * Sets up the test environment by initializing the HomePage, ReportDetailsPage, and LoginTests objects,
     * setting the path to the test data, and logging in as a supervisor.
     */
    @BeforeClass
    public void setup() {
        homePage = new HomePage(driver.getWebDriver());
        reportDetailsPage = new ReportDetailsPage(driver.getWebDriver());
        loginTests = new LoginTests();
        testData = "TestData/Data/MaradimData.json";
        loginTests.testSupervisorValidLogin();
    }

    /**
     * Tests that the supervisor can navigate to the currently submitted report.
     * The test is performed by calling the private method performTask.
     */
    @Test(priority = 1, description = "Check that the supervisor can navigate to tasks")
    public void checkThatTheSupervisorCanNavigateToTheCurrentlySubmittedReportTC() {
        performTask("status1", "assignee1");
    }

    /**
     * Tests that the supervisor can approve the report.
     * The test is performed by calling the private method performApproval.
     * This test depends on the successful execution of the checkThatTheSupervisorCanNavigateToTheCurrentlySubmittedReportTC test.
     */
    @Test(priority = 2, description = "Check that the supervisor can approve the report", dependsOnMethods = "checkThatTheSupervisorCanNavigateToTheCurrentlySubmittedReportTC")
    public void checkThatTheSupervisorCanApproveTheReportTCs() {
        performApproval("action1", "option1", "option2", "status3", "assignee2");
        softAssert.assertAll();
    }

    /**
     * Navigates to the task page, shows all tasks, navigates to the report details page,
     * and asserts the report state and assignee.
     * @param status The expected status of the report.
     * @param assignee The expected assignee of the report.
     */
    private void performTask(String status, String assignee) {
        homePage.navigateToTaskPage().showAllTasks()
                .navigateToReportDetails()
                .assertReportState(getJson(testData, "reportStatus", status))
                .assertAssignedTo(getJson(testData, "assignTo", assignee));
    }

    /**
     * Performs the approval action, checks the required actions, clicks the Yes button,
     * asserts the toast message is displayed, the report state, and the assignee.
     * @param action The action to perform.
     * @param option1 The first option to check.
     * @param option2 The second option to check.
     * @param status The expected status of the report.
     * @param assignee The expected assignee of the report.
     */
    private void performApproval(String action, String option1, String option2, String status, String assignee) {
        reportDetailsPage.clickOnShowActionsBtn().selectSpecificAction(getJson(testData, "actions", action))
                .checkRequiredActions(getJson(testData, "actionOptions", option1))
                .checkRequiredActions(getJson(testData, "actionOptions", option2))
                .clickYesBtn()
                .assertToastMessageIsDisplayed()
                .assertReportState(getJson(testData, "reportStatus", status))
                .assertAssignedTo(getJson(testData, "assignTo", assignee));
    }

    /**
     * Logs out after the test class has finished executing all tests.
     */
    @AfterClass
    public void clickOnSignOut() {
        maradimCheckList.clickOnSuccessMsg();
        logoutTests.testLogout();
    }
}