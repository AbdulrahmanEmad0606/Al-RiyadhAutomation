package Pages.PagesElements.GenericElements;

import CoreElements.Button;
import CoreElements.Label;
import CoreElements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the elements of a login page on a webpage.
 * It provides methods to interact with these elements, such as getting the username input field, password input field, login button, and login error message.
 */
public class LoginElements {
    public WebDriver driver;

    /**
     * Constructor for the LoginElements class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public LoginElements(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * TextBox object representing the username input field on the login page.
     */
    public TextBox userNameInput=new TextBox(By.xpath("//chk-input-text/input"));

    /**
     * TextBox object representing the password input field on the login page.
     */
    public TextBox passwordInput=new TextBox(By.xpath("//chk-input-password/p-password/div/input"));

    /**
     * Button object representing the login button on the login page.
     */
    public Button loginBtn=new Button(By.xpath("//*[@id=\"login.button\"]/button"));

    /**
     * Label object representing the login error message on the login page.
     */
    public Label loginErrorMSG=new Label(By.cssSelector("p.error-text"));
}