package CoreElements;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

/**
 * This class represents a Label element in a web page.
 * It extends the Element class and inherits all its methods.
 * It provides methods to get the text of the Label and to click the Label.
 */
public class Label extends Element {
    /**
     * Constructor for the Label class.
     * It sets the locator for the Label element.
     * @param label The locator for the Label element.
     */
    public Label(By label) {
        this.setLocator(label);
    }

    /**
     * Returns the text of the Label element located by the locator.
     * Waits for the element to be visible before getting the text.
     * @return The text of the Label element.
     */
    public String getLabel() {
        waitElement(locator);
        return find(locator).getText();
    }
    public boolean containText(String text){
        waitElement(locator);
        return find(locator).getText().contains(text);
    }
    /**
     * Clicks on the Label element located by the locator.
     * Waits for the element to be visible before clicking.
     * Also takes a screenshot after clicking and saves it in the specified location.
     */
    public void click() {
        waitElement(locator);
        find(locator).click();
        try {
            TakesScreenshot screenshot = (TakesScreenshot) webDriver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(
                    ".\\TestData\\ScreenShots\\" + getClass().getSimpleName() + "\\" + new Throwable().getStackTrace()[0].getMethodName() + "_" + getCurrentDate() + ".png"));
        } catch (Exception ignored) {
        }
    }
}