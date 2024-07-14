package Pages.UserPortal.GenericPages;

import CoreElements.Element;
import Pages.PagesElements.GenericElements.TasksElements;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static CoreElements.Element.webDriver;

/**
 * This class represents the tasks page on a webpage.
 * It provides methods to interact with this page, such as showing all tasks and navigating to report details.
 */
public class TasksPage {
    /**
     * WebDriver instance used to interact with the webpage.
     */
    private WebDriver driver;

    /**
     * ReportDetailsPage object representing the report details page.
     */
    ReportDetailsPage reportDetailsPage = new ReportDetailsPage(Element.getWebDriver());

    /**
     * TasksElements object representing the elements on the tasks page.
     */
    TasksElements tasksElements=new TasksElements(Element.getWebDriver());

    /**
     * Constructor for the TasksPage class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public TasksPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Shows all tasks on the tasks page.
     * @return The current TasksPage instance.
     */
    @Step("show all tasks")
    public TasksPage showAllTasks() {
        tasksElements.showAllBTN.click();
        return this;
    }

    /**
     * Navigates to the report details page by clicking on a task.
     * If there are more than two tabs open, it switches to the third tab.
     * Otherwise, it switches to the second tab.
     * @return A new ReportDetailsPage instance.
     */
    @Step("Select Task")
    public ReportDetailsPage navigateToReportDetails(){
        tasksElements.task.click();
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());

        if(tabs.size()>2){
            webDriver.switchTo().window(tabs.get(2));
        }
        else{
            webDriver.switchTo().window(tabs.get(1));
        }
        return reportDetailsPage;
    }
}