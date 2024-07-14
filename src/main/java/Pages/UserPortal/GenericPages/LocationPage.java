package Pages.UserPortal.GenericPages;

import CoreElements.Element;
import Pages.PagesElements.GenericElements.LocationPageElements;
import Pages.UserPortal.RoadComponentsCustomPages.RoadComponentsCheckList;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the location page on a webpage.
 * It provides methods to interact with this page, such as selecting a street and navigating to the checklist page.
 */
public class LocationPage {

    private final WebDriver driver;

    /**
     * LocationPageElements object representing the elements on the location page.
     */
    private final LocationPageElements locationPageElements;

    /**
     * Constructor for the LocationPage class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public LocationPage(WebDriver driver) {
        this.driver = driver;
        this.locationPageElements = new LocationPageElements(Element.getWebDriver());
    }

    /**
     * Selects a street from the radio button on the location page.
     * @return The current LocationPage instance.
     */
    @Feature("Submit Form")
    @Step("Select street")
    public LocationPage selectStreet()  {
       locationPageElements.selectedStreet.radioBtnClick();
        return this;
    }

    /**
     * Clicks on the next button and navigates to the checklist page.
     * @return A new RoadComponentsCheckList instance.
     */
    @Step("Click on Next Button")
    public RoadComponentsCheckList navigateToCheckList()  {
        locationPageElements.nextBtn.click();
        return new RoadComponentsCheckList(driver);
    }
}