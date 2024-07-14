package Pages.PagesElements.GenericElements;

import CoreElements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the elements on the 'Add New Report' page.
 * It provides WebElements for the activity dropdown, report type selector, and the next button.
 */
public class ActivitiesElements {
    public WebDriver driver;
    /**
     * Constructor for the AddNewReportElements class.
     * It sets the WebDriver instance.
     * @param driver The WebDriver instance.
     */
    public ActivitiesElements(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * WebElement representing the activity dropdown on the 'Add New Report' page.
     */
    public Button activityDropdown2 = new Button(By.xpath("//chk-search-input[1]/ngx-select-dropdown/div/button"));
    public Button getActivityName(String activityName){
        return new Button(By.xpath("//ngx-select-dropdown/div/div/ul[2]/li[text()='"+activityName+"']"));
    }

    /**
     * WebElement representing the report type selector on the 'Add New Report' page.
     */
    public  Button selectReportType = new Button(By.xpath("//chk-search-input[2]/ngx-select-dropdown/div/button"));
    /**
     * WebElement representing the next button on the 'Add New Report' page.
     */
    public Button nextButton = new Button(By.cssSelector("button.chk-primary-btn[title='التالي']"));


}