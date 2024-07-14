package CoreElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents a Link element in a web page.
 * It extends the Element class and inherits all its methods.
 * It provides a method to click the Link.
 */
public class Link extends ClickableElements {
    static WebDriver driver;

    /**
     * Constructor for the Link class.
     * It sets the locator for the Link element.
     *
     * @param link The locator for the Link element.
     */
    public Link(By link) {
        this.setLocator(link);
    }
}