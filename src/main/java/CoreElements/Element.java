package CoreElements;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static CoreElements.Link.driver;

public class Element {
    @Getter
    public static WebDriver webDriver;
    protected static Faker faker = new Faker();
    @Setter
    public By locator;
    public SoftAssert softAssert = new SoftAssert();

    public static void setWebDriver(WebDriver webDriver) {
        Element.webDriver = webDriver;
    }

    public static String getFutureDate() {
        Date dt = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, 364);
        dt = calendar.getTime();
        return new SimpleDateFormat("dd/MM/yyyy").format(dt);
    }

    public static WebElement setElement(String source) {
        return webDriver.findElement(By.xpath("//*[@data-axis-test-id='" + source + "']"));
    }

    public static int generateRNumber() {
        return Integer.parseInt(String.valueOf(faker.number().numberBetween(10, 99)));
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("dd-MM-yyyy hh.mm.ss a").format(new Date());
    }

    public static String getDateFormat(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy | hh:mm a");
        Date date = new Date();
        System.out.println("Current Date : " + dateFormat.format(date));
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, -15);
        Date currentDatePlusOne = c.getTime();
        return String.valueOf(dateFormat.format(currentDatePlusOne)
                .toLowerCase());
    }

    public String getText() {
        return webDriver.findElement(locator).getText();
    }

    public void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(70));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementToBeDisplayed(By locator, String value) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(locator, "src", value));
    }

    public void waitElementToBePresent(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitWebElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @SneakyThrows
    public WebElement find(By locator) {
        waitElement(locator);
        scrollElement(locator);

        highlightElement();
        return webDriver.findElement(locator);
    }

    @SneakyThrows
    public List<WebElement> findElements(By locator) {
        waitElement(locator);
        scrollElement(locator);
        highlightElement();
        return webDriver.findElements(locator);
    }


    public void setKeys(By locator, Keys key) {
        waitElement(locator);
        find(locator).sendKeys(key);
    }

    public void sendKeys(By locator, Keys key, String val) {
        waitElement(locator);
        find(locator).sendKeys(key + val);
    }

    @SneakyThrows
    public void dbClick(By locator) {
        Actions actions = new Actions(webDriver);
        waitElement(locator);
        actions.doubleClick(find(locator)).perform();
    }

    public void clickUpload(By locator) {
        waitElement(locator);
        find(locator).click();
    }

    public void selectData(By locator, int index) {
        Select select;
        select = new Select(find(locator));
        select.selectByIndex(index);
    }

    public void ClickElementsByClass(By locator, int index) {
        waitElement(locator);
        WebElement element;
        element = webDriver.findElements(locator)
                .get(index);
        element.click();
    }

    public boolean isDisplayed() {
        return find(locator).isDisplayed();
    }
    public boolean isEnabled() {
        return find(locator).isEnabled();
    }

    public boolean hasClassAttribute(By locator, String attribute) {
        return find(locator).getAttribute("class").contains(attribute);
    }

    public String getContent(By locator) {
        waitElement(locator);
        return find(locator).getText();
    }

    public String getContentByValue(By locator) {
        waitElement(locator);
        return find(locator).getAttribute("value");
    }

    public String getContentBySrc(By locator) {
        waitElement(locator);
        return find(locator).getAttribute("src");
    }

    public String getContentByPlaceholder(By locator) {
        waitElement(locator);
        return find(locator).getAttribute("placeholder");
    }

    public String getAttributeValue(By locator) {
        waitElement(locator);
        return find(locator).getAttribute("style");
    }

    public String getPageUrl() {
        return webDriver.getCurrentUrl();
    }

    public void scrollDownToElement() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0, 1000)", "");
    }

    public void scrollUpToElement() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0, -1000)", "");
    }

    public void hover(By locator) {
        WebElement ele = webDriver.findElement(locator);
        Actions action = new Actions(webDriver);
        action.moveToElement(ele)
                .perform();
    }

    public String setXpathByDataID(String source) {
        return "//*[@data-axis-test-id='" + source + "']";
    }

    public String setXpathByClass(String cls) {
        return "//*[@class='" + cls + "']";
    }

    public String setXpathById(String id) {
        return "//*[@id='" + id + "']";
    }

    /**
     * public String setXpathByHref(String href) {
     * // return STR."//*[@href='\{href}']";
     * return STR + "//*[@href='" + href + "']";
     * }
     */
    public String setXpathByRole(String role) {
        return "//*[@role='" + role + "']";
    }

    public String setXpathByText(String source) {
        return "//*[text()='" + source + "']";
    }

    public String setXpathByContains(String source) {
        return "//*[contains(text(),'" + source + "')]";
    }

    public String setXpathByClassText(String source, String text) {
        return "//*[@class='" + source + "' and text()='" + text + "']";
    }

    public String setXpathByValue(By locator) {
        waitElement(locator);
        return find(locator).getAttribute("value");
    }

    public void clickByWebElement(String dataID) {
        WebElement element = webDriver.findElement(By.xpath("//*[@data-axis-test-id='" + dataID + "']"));
        waitWebElement(element);
        element.click();
    }

    public void clickByWebElementOne(WebElement element, String dataID) {
        waitWebElement(element);
        element = webDriver.findElement(By.xpath("//*[@data-axis-test-id='" + dataID + "']"));
        waitWebElement(element);
        element.click();
    }

    public boolean isDisabled(By locator) {
        waitElement(locator);
        WebElement element = (WebElement) webDriver.findElement(locator);
        if (element.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public IAssert<?> softAssertAll() {
        softAssert.assertAll();
        return null;
    }

    public void softAssertionImageSrc(By locator, String expected, String value) {
        waitElementToBeDisplayed(locator, value);
        softAssert.assertTrue(getContentBySrc(locator).contains(expected));
        if (getContent(locator).contains(expected)) {
            highlightAssertedElements(locator);
        } else {
            highlightUnAssertedElements(locator);
        }
    }

    public void softAssertionImageEqual(By locator, String expected, String value) {
        waitElementToBeDisplayed(locator, value);
        softAssert.assertEquals(getContentBySrc(locator), expected);
        if (getContentBySrc(locator).contains(expected)) {
            highlightAssertedElements(locator);
        } else {
            highlightUnAssertedElements(locator);
        }
    }

    public void softAssertionTrue(By locator) {
        waitElement(locator);
        softAssert.assertTrue(isDisabled(locator));
        if (getContent(locator).equals("True")) {
            highlightAssertedElements(locator);
        } else {
            highlightUnAssertedElements(locator);
        }
    }

    public void softAssertionContain(By locator, String expected) {
        waitElement(locator);
        softAssert.assertTrue(getContent(locator).contains(expected));
        if (getContent(locator).contains(expected)) {
            highlightAssertedElements(locator);
        } else {
            highlightUnAssertedElements(locator);
        }
    }

    public void softAssertionNotNull(By locator) {
        waitElement(locator);
        softAssert.assertNotNull(getContent(locator));
        highlightAssertedElements(locator);
    }

    public void uploadFile(By locator, String URL) throws AWTException, InterruptedException {
        clickUpload(locator);
        Robot robot = new Robot();
        StringSelection str = new StringSelection(URL);
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(str, null);
        // Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        // Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        // Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        // Thread.sleep(1500);
    }

    public void scrollElement(By locator) {
        WebElement element = webDriver.findElement(locator);
        int windowHeight = webDriver.manage()
                .window()
                .getSize()
                .getHeight();
        int elementLocation = element.getLocation()
                .getY();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, " + (elementLocation - windowHeight / 2) + ")");
    }

    public void highlightElement() {
        WebElement element = webDriver.findElement(this.locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].style.border='3px solid #3590C1'", element);
    }

    public void highlightAssertedElements(By locator) {
        WebElement element = webDriver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid blue'", element);
        jsExecutor.executeScript("arguments[0].style.backgroundColor = 'green';", element);
    }

    public void highlightUnAssertedElements(By locator) {
        WebElement element = webDriver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].style.border='2px solid blue'", element);
        jsExecutor.executeScript("arguments[0].style.backgroundColor = 'red';", element);
    }
    @SneakyThrows
    public void softAssertionEqual(String expected) {
        waitElement(locator);
        softAssert.assertEquals(getContent(locator).trim(), expected);
        if (getContent(locator).equals(expected)) {
            highlightAssertedElements(locator);
        } else {
            highlightUnAssertedElements(locator);
            String currentMethod = new Object() {
            }.getClass().getSimpleName();
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(
                    ".\\TestData\\ScreenShots\\SoftAssertions\\" + getClass().getName() + "\\" + currentMethod + "_" + getCurrentDate() + ".png"));
        }
    }

    public String setXpathForCells(int row, int col) {
        return "//table/tbody/tr[" + row + "]/td[" + col + "]";
    }
}
