package Pages.UserPortal.GenericPages;

import CoreElements.Element;
import Pages.PagesElements.GenericElements.ActivitiesElements;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the activities page on a webpage.
 * It provides methods to interact with this page, such as selecting an activity, selecting a report type, and navigating to the municipality or district page.
 */
public class ActivitiesPage {
    private WebDriver driver;

    /**
     * Constructor for the ActivitiesPage class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public ActivitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * ActivitiesElements object representing the elements on the activities page.
     */
    ActivitiesElements activitiesElements=new ActivitiesElements(Element.getWebDriver());

    /**
     * Selects an activity from the dropdown on the activities page.
     * @param activityName The name of the activity to select.
     * @return The current ActivitiesPage instance.
     */
    @Feature("Submit Form")
    @Step("select activity")
    public ActivitiesPage selectActivity(String activityName) {
        activitiesElements.activityDropdown2.click();
        activitiesElements.getActivityName(activityName).click();
        return this;
    }

    /**
     * Selects a report type from the dropdown on the activities page.
     * @return The current ActivitiesPage instance.
     */
    @Step("select report type")
    public ActivitiesPage selectReportType(){
        activitiesElements.selectReportType.click();
        return this;
    }

    /**
     * Clicks on the next button and navigates to the municipality page.
     * @return A new MunicipalityPage instance.
     */
    @Step("click on next button and navigate to location page")
    public MunicipalityPage NavigateToMunicipalityPage() {
        activitiesElements.nextButton.click();
        return new MunicipalityPage(driver);
    }

    /**
     * Clicks on the next button and navigates to the district page.
     * @return A new DistrictPage instance.
     */
    @Step("click on next button and navigate to District page")
    public DistrictPage navigateToDistrictPage() {
        activitiesElements.nextButton.click();
        return new DistrictPage(driver);
    }
}