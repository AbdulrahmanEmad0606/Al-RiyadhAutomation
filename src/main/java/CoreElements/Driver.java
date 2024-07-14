package CoreElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Arrays;

/**
 * This class represents a WebDriver instance.
 * It provides methods to interact with the WebDriver such as navigating to a URL, maximizing the window, and closing the browser.
 */
public class Driver {
    static WebDriver webDriver;

    /**
     * Constructor for the Driver class.
     * It initializes the WebDriver with ChromeDriver and sets the desired options.
     */
    public Driver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments
                (Arrays.asList
                        ("--disable-notifications--"
                                , "--remote-allow-origins=*"
                                , "--incognito"));
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        webDriver = new ChromeDriver(options);
    }

    /**
     * Returns the WebDriver instance.
     * @return The WebDriver instance.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Maximizes the browser window.
     */
    public void maximizeWindow() {
        webDriver.manage().window().maximize();
    }

    /**
     * Navigates to the specified URL.
     * @param url The URL to navigate to.
     */
    public void goTo(String url) {
        webDriver.get(url);
    }

    /**
     * Closes the browser and ends the WebDriver session.
     */
    public void tearDown() {
        webDriver.close();
    }
}