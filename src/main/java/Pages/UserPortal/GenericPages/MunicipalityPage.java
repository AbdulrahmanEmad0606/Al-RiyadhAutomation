package Pages.UserPortal.GenericPages;

import CoreElements.Element;
import Pages.PagesElements.GenericElements.MunicipalityElements;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the municipality page on a webpage.
 * It provides methods to interact with this page, such as selecting a municipality and navigating to the district page.
 */
public class MunicipalityPage {

    /**
     * WebDriver instance used to interact with the webpage.
     */
    private final WebDriver driver;

    /**
     * MunicipalityElements object representing the elements on the municipality page.
     */
    MunicipalityElements municipalityElements;

    /**
     * Constructor for the MunicipalityPage class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public MunicipalityPage(WebDriver driver) {
        this.driver = driver;
        this.municipalityElements = new MunicipalityElements(Element.getWebDriver());
    }

    /**
     * Selects a municipality from the dropdown on the municipality page.
     * If the municipality is not found, it prints "Municipality not found".
     * @param municipalityName The name of the municipality to select.
     * @return The current MunicipalityPage instance.
     */
    @Feature("Submit Form")
    @Step("Select Municipality")
    public MunicipalityPage selectMunicipality(String municipalityName){
        if(municipalityElements.getMunicipalityName(municipalityName).getLabel().equals(municipalityName))
            municipalityElements.showDistricts.click();
        else System.out.print("Municipality not found");
        return this;
    }

    /**
     * Clicks on the next button and navigates to the district page.
     * @return A new DistrictPage instance.
     */
    @Step("Navigate To District Page")
    public DistrictPage navigateToDistrictPage()  {
       return new DistrictPage(driver);
    }
}