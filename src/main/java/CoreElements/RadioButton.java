package CoreElements;

import org.openqa.selenium.By;

/**
 * This class represents a RadioButton element in a web page.
 * It extends the Element class and inherits all its methods.
 * It provides a method to click the RadioButton.
 */
public class RadioButton extends ClickableElements{
    /**
     * Constructor for the RadioButton class.
     * It sets the locator for the RadioButton element.
     * @param radioBtn The locator for the RadioButton element.
     */
    public RadioButton(By radioBtn){
        this.setLocator(radioBtn);
    }
}