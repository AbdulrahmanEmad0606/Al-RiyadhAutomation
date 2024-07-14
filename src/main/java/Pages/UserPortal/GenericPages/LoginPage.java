package Pages.UserPortal.GenericPages;

import CoreElements.Element;
import CoreElements.Label;
import Pages.PagesElements.GenericElements.LoginElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the login page on a webpage.
 * It provides methods to interact with this page, such as setting the username, setting the password, clicking the login button, getting the greeting message, setting an invalid username, setting an invalid password, clicking the login button for invalid credentials, and filling data for invalid login.
 */
public class LoginPage {
    /**
     * LoginElements object representing the elements on the login page.
     */
    LoginElements loginElements = new LoginElements(Element.getWebDriver());

    /**
     * WebDriver instance used to interact with the webpage.
     */
    private WebDriver driver;

    /**
     * Constructor for the LoginPage class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * HomePage object representing the home page.
     */
    public HomePage homePage=new HomePage(driver);

    /**
     * Sets the username in the username input field.
     * @param userName The username to set.
     * @return The current LoginPage instance.
     */
    @Step("Set User Name")
    public LoginPage setUserName(String userName){
        loginElements.userNameInput.setText(userName);
        return this;
    }

    /**
     * Sets the password in the password input field.
     * @param password The password to set.
     * @return The current LoginPage instance.
     */
    @Step("Set Password")
    public LoginPage setPassword(String password){
        loginElements.passwordInput.setText(password);
        return this;
    }

    /**
     * Clicks the login button.
     * @return The current LoginPage instance.
     */
    @Step("Click on login button")
    public LoginPage clickLoginBtn(){
        loginElements.loginBtn.click();
        return this;
    }

    /**
     * Checks if the greeting message contains the specified text.
     * @param text The text to check for in the greeting message.
     * @return True if the greeting message contains the text, false otherwise.
     */
    @Step("Get greeting message")
    public boolean getGreeting(String text){
        return homePage.getGreetingLabel(text);
    }

    /**
     * Sets an invalid username in the username input field.
     * @param userName The invalid username to set.
     * @return The current LoginPage instance.
     */
    @Step("Set in valid username")
    public LoginPage setInvalidUserName(String userName){
        loginElements.userNameInput.setText(userName);
        return this;
    }

    /**
     * Sets an invalid password in the password input field.
     * @param password The invalid password to set.
     * @return The current LoginPage instance.
     */
    @Step("Set in valid password")
    public LoginPage setInvalidPassword(String password){
        loginElements.passwordInput.setText(password);
        return this;
    }

    /**
     * Clicks the login button for invalid credentials and returns the login error message.
     * @return The login error message.
     */
    @Step("Click on login button")
    public Label clickOnLoginBTNForInvalidCred(){
        loginElements.loginBtn.click();
        return loginElements.loginErrorMSG;
    }

    /**
     * Fills data for invalid login by clicking the login button.
     */
    public void fillDataForInvalidLogin() {
        loginElements.loginBtn.click();
    }
}