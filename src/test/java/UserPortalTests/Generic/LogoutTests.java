package UserPortalTests.Generic;

import GlobalSetup.GlobalSetup;
import Pages.UserPortal.GenericPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class contains tests for the logout functionality of the user portal.
 * It extends the GlobalSetup class to inherit its setup and teardown methods.
 */
public class LogoutTests extends GlobalSetup {
    /**
     * HomePage object representing the home page of the user portal.
     */
    HomePage homePage=new HomePage(driver.getWebDriver());

    /**
     * Tests the logout functionality.
     * Asserts that the login button is displayed after successful logout.
     */
    @Test
    public void testLogout() {
        boolean loginBTNIsExist=
                homePage.clickOnArrowBTN()
                        .clickOnLogoutLink()
                        .clickOnLogoutBTN();
        Assert.assertTrue(loginBTNIsExist,"user can not be able to logout");
    }
}