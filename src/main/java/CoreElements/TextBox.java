package CoreElements;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 * This class represents a TextBox element in a web page.
 * It extends the Element class and inherits all its methods.
 * It provides methods to set and clear the text of the TextBox.
 */
public class TextBox extends Element {
    /**
     * Constructor for the TextBox class.
     * It sets the locator for the TextBox element.
     * @param typedElement The locator for the TextBox element.
     */
    public TextBox(By typedElement) {
        this.setLocator(typedElement);
    }

    /**
     * Sets the text of the TextBox element located by the locator.
     * Waits for the element to be visible and enabled before setting the text.
     * @param data The text to be set in the TextBox.
     */
    @SneakyThrows
    public void setText(String data) {
        waitElement(locator);
        find(locator).isEnabled();
        find(locator).sendKeys(data);
    }

    /**
     * Clears the text of the TextBox element located by the locator.
     * Waits for the element to be visible and enabled before clearing the text.
     */
    public void clearText(){
        waitElement(locator);
        find(locator).isEnabled();
        find(locator).clear();
        find(locator).clear();
    }
}