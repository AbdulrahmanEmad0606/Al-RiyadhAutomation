package CoreElements;

import org.openqa.selenium.By;

/**
 * This class represents a Button element in a web page.
 * It extends the Element class and inherits all its methods.
 * It provides a method to click the button and take a screenshot after clicking.
 */
public class Button extends ClickableElements{
    /**
     * Constructor for the Button class.
     * It sets the locator for the button element.
     * @param button The locator for the button element.
     */
    public Button(By button){
        this.setLocator(button);
    }
}