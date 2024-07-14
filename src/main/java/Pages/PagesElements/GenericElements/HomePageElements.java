package Pages.PagesElements.GenericElements;

import CoreElements.Button;
import CoreElements.Label;
import CoreElements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the elements of a home page on a webpage.
 * It provides methods to interact with these elements, such as getting the greeting message, plus icon, task icon, arrow down button, logout link, and logout button.
 */
public class HomePageElements {
    public WebDriver driver;

    /**
     * Constructor for the HomePageElements class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public HomePageElements(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Label object representing the greeting message on the home page.
     */
    public Label greetingMSG = new Label(By.xpath("//span[contains(@class,'greeting')]"));

    /**
     * Button object representing the plus icon on the home page.
     */
    public Button plusIcon = new Button(By.id("add.report.button"));

    /**
     * Link object representing the task icon on the home page.
     */
    public Link taskIcon = new Link(By.id("menu.item.tasks"));

    /**
     * Button object representing the arrow down button on the home page.
     */
    public Button arrowDownBTN = new Button(By.cssSelector("button.p-button-icon-only"));

    /**
     * Link object representing the logout link on the home page.
     */
    public Link logoutLink=new Link(By.xpath("//a/span[contains(text(),'تسجيل خروج')]"));

    /**
     * Link object representing the logout button on the home page.
     */
    public Link logoutButton=new Link(By.xpath("//modal-container/div[2]/div/div[3]/div/chk-button[2]/button/span"));
}