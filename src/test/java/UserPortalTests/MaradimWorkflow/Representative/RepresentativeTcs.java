package UserPortalTests.MaradimWorkflow.Representative;

import Pages.UserPortal.GenericPages.HomePage;
import Pages.UserPortal.GenericPages.ReportDetailsPage;
import UserPortalTests.Generic.LoginTests;
import GlobalSetup.GlobalSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This class contains tests for the representative role in the Maradim workflow.
 * It extends the GlobalSetup class to inherit its setup and teardown methods.
 */
public class RepresentativeTcs extends GlobalSetup {
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
     * The path to the JSON file containing the test data for the representative tests.
     */
    String testData;

    /**
     * Sets up the test environment by initializing the HomePage, ReportDetailsPage, and LoginTests objects,
     * setting the path to the test data, and logging in as a representative.
     */
    @BeforeClass
    public void setup() {
        homePage = new HomePage(driver.getWebDriver());
        reportDetailsPage = new ReportDetailsPage(driver.getWebDriver());
        loginTests = new LoginTests();
        testData = "TestData/Data/MaradimData.json";
        loginTests.testRepresentativeValidLogin();
    }

    /**
     * Tests that the representative can navigate to the currently submitted report.
     * The test is performed by calling the private method performTask.
     */
    @Test(priority = 1, description = "Check that the representative can navigate to tasks")
    public void checkThatTheRepresentativeCanNavigateToTheCurrentlySubmittedReportTC() {
        performTask("status3", "assignee2");
    }

    /**
     * Tests that the representative can approve the report.
     * The test is performed by calling the private method performApproval.
     * This test depends on the successful execution of the checkThatTheRepresentativeCanNavigateToTheCurrentlySubmittedReportTC test.
     */
    @Test(priority = 2, description = "Check that the representative can approve the report", dependsOnMethods = "checkThatTheRepresentativeCanNavigateToTheCurrentlySubmittedReportTC")
    public void checkThatTheRepresentativeCanApproveTheReportTC() {
        performApproval("action3", "option1", "option2", "status4", "assignee2", "action4");
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
     * @param action2 The second action to perform.
     */
    private void performApproval(String action, String option1, String option2, String status, String assignee, String action2) {
        reportDetailsPage.clickOnShowActionsBtn()
                .selectSpecificAction(getJson(testData, "actions", action))
                .checkRequiredActions(getJson(testData, "actionOptions", option1))
                .checkRequiredActions(getJson(testData, "actionOptions", option2))
                .clickYesBtn()
                .assertToastMessageIsDisplayed()
                .assertReportState(getJson(testData, "reportStatus", status))
                .assertAssignedTo(getJson(testData, "assignTo", assignee))
                .clickOnShowActionsBtn().selectSpecificAction(getJson(testData, "actions", action2))
                .checkRequiredActions(getJson(testData,"actionOptions", option1))
                .checkRequiredActions(getJson(testData, "actionOptions", option2))
                .clickYesBtn()
                .assertToastMessageIsDisplayed();
    }
}