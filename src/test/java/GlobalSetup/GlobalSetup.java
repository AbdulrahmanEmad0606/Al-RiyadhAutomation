package GlobalSetup;

import CoreElements.Driver;
import Pages.Utilities;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.io.IOException;

/**
 * This class is responsible for the global setup of the tests.
 * It includes methods for setting up the test environment, closing the site after tests, and reading JSON files.
 */
public class GlobalSetup {
    /**
     * Driver instance used for the tests.
     */
    public static Driver driver = new Driver();
    /**
     * Utilities instance used for the tests.
     */
    protected static Utilities utilities = new Utilities(driver);

    protected SoftAssert softAssert = new SoftAssert();
    /**
     * This method is executed before the test suite starts.
     * It opens the site and initializes the Utilities instance.
     */
    @BeforeTest
    public void setUp() {
        utilities.openSite();
        utilities = new Utilities(driver);
    }


    /**
     * This method is executed after the test suite ends.
     * It closes the site.
     */
    @AfterTest
    public void closeSite() {
        driver.tearDown();
    }

    /**
     * This method reads a JSON file and returns the value of the specified keys.
     * @param filePath The path of the JSON file.
     * @param keys The keys whose values are to be returned.
     * @return The value of the specified keys in the JSON file.
     * @throws RuntimeException If an error occurs while reading the file or parsing the JSON.
     */
    @SneakyThrows
    public static String getJson(String filePath, String... keys) {
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filePath));
            for (String key : keys) {
                Object value = jsonObject.get(key);
                if (value instanceof JSONObject) {
                    jsonObject = (JSONObject) value;
                } else {
                    return value.toString();
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}