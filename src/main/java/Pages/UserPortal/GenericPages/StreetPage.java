package Pages.UserPortal.GenericPages;

import CoreElements.Element;
import Pages.PagesElements.GenericElements.StreetElements;
import Pages.UserPortal.MaradimCustomPages.MaradimCheckList;
import Pages.UserPortal.RoadComponentsCustomPages.RoadComponentsCheckList;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the street page on a webpage.
 * It provides methods to interact with this page, such as selecting a street and navigating to the road component checklist or Maradim checklist.
 */
public class StreetPage {

    /**
     * WebDriver instance used to interact with the webpage.
     */
    private final WebDriver driver;

    /**
     * StreetElements object representing the elements on the street page.
     */
    StreetElements streetElements;

    /**
     * Constructor for the StreetPage class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public StreetPage(WebDriver driver) {
        this.driver = driver;
        this.streetElements = new StreetElements(Element.getWebDriver());
    }

    /**
     * Selects a street from the radio button on the street page.
     * @return The current StreetPage instance.
     */
    @Feature("Submit Form")
    @Step("Select Street")
    public StreetPage selectStreet(){
        streetElements.selectedStreet.radioBtnClick();
        return this;
    }

    /**
     * Clicks on the next button and navigates to the road component checklist page.
     * @return A new RoadComponentsCheckList instance.
     */
    @Step("Click on Next Button")
    public RoadComponentsCheckList navigateToRoadComponentCheckList()  {
        streetElements.nextButton.click();
        return new RoadComponentsCheckList(driver);
    }

    /**
     * Clicks on the next button and navigates to the Maradim checklist page.
     * @return A new MaradimCheckList instance.
     */
    @Step("navigate To Maradim CheckList")
    public MaradimCheckList navigateToMaradimCheckList()  {
        streetElements.nextButton.click();
        return new MaradimCheckList(driver);
    }
}