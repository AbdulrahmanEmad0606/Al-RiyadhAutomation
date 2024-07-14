package Pages.UserPortal.GenericPages;

import CoreElements.Element;
import Pages.PagesElements.GenericElements.DistrictElements;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the district page on a webpage.
 * It provides methods to interact with this page, such as selecting a district and navigating to the street page.
 */
public class DistrictPage {

    private final WebDriver driver;

    /**
     * DistrictElements object representing the elements on the district page.
     */
    DistrictElements districtElements;

    /**
     * Constructor for the DistrictPage class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public DistrictPage(WebDriver driver) {
        this.driver = driver;
        this.districtElements = new DistrictElements(Element.getWebDriver());
    }

    /**
     * Selects a district from the dropdown on the district page.
     * If the district is not found, it prints "District not found".
     * @param districtName The name of the district to select.
     * @return The current DistrictPage instance.
     */
    @Feature("Submit Form")
    @Step("Select District")
    public DistrictPage selectDistrict(String districtName){
        if(districtElements.getDistrictName(districtName).getLabel().equals(districtName))
            districtElements.showStreets.click();
        else System.out.print("District not found");
        return this;
    }

    /**
     * Clicks on the next button and navigates to the street page.
     * @return A new StreetPage instance.
     */
    @Step("Navigate To Street Page")
    public StreetPage navigateToStreetPage()  {
         return new StreetPage(driver);
    }
}