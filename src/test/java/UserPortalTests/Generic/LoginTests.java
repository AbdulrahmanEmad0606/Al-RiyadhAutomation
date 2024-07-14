package UserPortalTests.Generic;

import CoreElements.Label;
import GlobalSetup.GlobalSetup;
import Pages.UserPortal.GenericPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class contains tests for the login functionality of the user portal.
 * It extends the GlobalSetup class to inherit its setup and teardown methods.
 */
public class LoginTests extends GlobalSetup {
    /**
     * The path to the JSON file containing the test data for the login tests.
     */
    String loginTestData = "TestData/Data/MaradimData.json";

    /**
     * LoginPage object representing the login page of the user portal.
     */
    LoginPage loginPage = new LoginPage(driver.getWebDriver());

    /**
     * Tests the login functionality for an inspector with valid credentials.
     * Asserts that the greeting message is displayed after successful login.
     */
    @Test
    public void testInspectorValidLogin() {
        boolean greetingMSG =
                loginPage.setUserName(getJson(loginTestData, "roles","inspector","inspectorUsername"))
                        .setPassword(getJson(loginTestData, "roles","inspector","inspectorPassword"))
                        .clickLoginBtn()
                        .getGreeting(getJson(loginTestData, "roles","inspector","InspectorName"));
        Assert.assertTrue(greetingMSG, "Login Failed");
    }

    /**
     * Tests the login functionality for a supervisor with valid credentials.
     * Asserts that the greeting message is displayed after successful login.
     */
    @Test
    public void testSupervisorValidLogin() {
        boolean greetingMSG =
                loginPage.setUserName(getJson(loginTestData, "roles","supervisor","supervisorUsername"))
                        .setPassword(getJson(loginTestData, "roles","supervisor","supervisorPassword"))
                        .clickLoginBtn()
                        .getGreeting(getJson(loginTestData, "roles","supervisor","supervisorName"));
        Assert.assertTrue(greetingMSG, "Login Failed");
    }

    /**
     * Tests the login functionality for a representative with valid credentials.
     * Asserts that the greeting message is displayed after successful login.
     */
    @Test
    public void testRepresentativeValidLogin() {
        boolean greetingMSG =
                loginPage.setUserName(getJson(loginTestData, "roles","representative","representativeUsername"))
                        .setPassword(getJson(loginTestData, "roles","representative","representativePassword"))
                        .clickLoginBtn()
                        .getGreeting(getJson(loginTestData, "roles","representative","representativeName"));
        Assert.assertTrue(greetingMSG, "Login Failed");
    }

    /**
     * Tests the login functionality with invalid credentials.
     * Asserts that an error message is displayed.
     */
    @Test
    public void testInValidLogin() {
        Label errorMsg =
                loginPage.setInvalidUserName(getJson(loginTestData, "roles","inspector","inspectorInvalidUsername"))
                        .setInvalidPassword(getJson(loginTestData, "roles","inspector","inspectorInvalidPassword"))
                        .clickOnLoginBTNForInvalidCred();
        Assert.assertTrue((errorMsg.isDisplayed()), "in valid login failed");
    }
}