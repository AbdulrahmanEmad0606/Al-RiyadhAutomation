package CoreElements;

import org.openqa.selenium.By;

/**
 * This class represents a CheckBox element in a web page.
 * It extends the Element class and inherits all its methods.
 * It provides a method to click the CheckBox and take a screenshot after clicking.
 */
public class CheckBox extends ClickableElements {
    /**
     * Constructor for the CheckBox class.
     * It sets the locator for the CheckBox element.
     *
     * @param checkBox The locator for the CheckBox element.
     */
    public CheckBox(By checkBox) {
        this.setLocator(checkBox);
    }

}