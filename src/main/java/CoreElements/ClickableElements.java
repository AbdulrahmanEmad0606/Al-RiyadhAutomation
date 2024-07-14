package CoreElements;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class ClickableElements extends Element{
    /**
     * Clicks on the button element located by the locator.
     * Waits for the element to be visible before clicking.
     * Also takes a screenshot after clicking and saves it in the specified location.
     */
    @SneakyThrows
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
    public void uploadPhotoToAllElements(String filePath) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        List<WebElement> elements = webDriver.findElements(locator);

        for (WebElement element : elements) {
            element.sendKeys(filePath);
        }
    }
}
