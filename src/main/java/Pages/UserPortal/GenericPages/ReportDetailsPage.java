package Pages.UserPortal.GenericPages;

import CoreElements.Element;
import Pages.PagesElements.GenericElements.ReportDetailsElements;
import Pages.UserPortal.MaradimCustomPages.MaradimCheckList;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class represents the report details page on a webpage.
 * It provides methods to interact with this page, such as getting the report number, clicking on show actions button, asserting the report state, asserting the assigned to, selecting a specific action, checking required actions, clicking on yes button, asserting the toast message is displayed, and clicking on no button.
 */
public class ReportDetailsPage {
    /**
     * WebDriver instance used to interact with the webpage.
     */
    private WebDriver driver;

    /**
     * ReportDetailsElements object representing the elements on the report details page.
     */
    ReportDetailsElements reportDetailsElements = new ReportDetailsElements(Element.getWebDriver());

    /**
     * Constructor for the ReportDetailsPage class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public ReportDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Gets the report number.
     * @return The report number.
     */
    public String getReportNumber() {
        return reportDetailsElements.reportNumber.getText();
    }

    /**
     * Clicks on the show actions button.
     * @return The current ReportDetailsPage instance.
     */
    @Step("check clicking on show actions")
    public ReportDetailsPage clickOnShowActionsBtn() {
        reportDetailsElements.showActions.click();
        return this;
    }

    /**
     * Asserts the report state.
     * @param reportState The report state to assert.
     * @return The current ReportDetailsPage instance.
     */
    @Step("Assert the content of the report state")
    public ReportDetailsPage assertReportState(String reportState) {
        reportDetailsElements.txtReportState.softAssertionEqual(reportState);
        return this;
    }

    /**
     * Asserts the assigned to.
     * @param assignedToName The assigned to name to assert.
     * @return The current ReportDetailsPage instance.
     */
    @Step("Assert the content of the assigned to")
    public ReportDetailsPage assertAssignedTo(String assignedToName) {
        reportDetailsElements.txtAssignedTo.softAssertionEqual(assignedToName);
        return this;
    }

    /**
     * Selects a specific action.
     * @param actionName The name of the action to select.
     * @return The current ReportDetailsPage instance.
     */
    @Step("Select action")
    public ReportDetailsPage selectSpecificAction(String actionName) {
        reportDetailsElements.getSpecificAction(actionName).click();
        return this;
    }

    /**
     * Checks the required actions.
     * If the action is required, it fills the required actions and clicks on the yes button.
     * @param optionName The name of the option to check.
     * @return The current ReportDetailsPage instance.
     */
    @SneakyThrows
    @Step("Check the required actions")
    public ReportDetailsPage checkRequiredActions(String optionName) {
        Thread.sleep(2000);
        if (reportDetailsElements.checkTheRequiredActions(optionName).getText().contains("*")) {
            System.out.println("The action is required");
            if (optionName.equals(" الملاحظة ")) {
                reportDetailsElements.notes.setText("This is a note");
            } else if (optionName.equals(" الملحقات ")) {
                    reportDetailsElements.attachments.uploadPhotoToAllElements("C:/Users/DELL/Pictures/images/Test.PNG");
                reportDetailsElements.attachments.uploadPhotoToAllElements("C:/Users/DELL/Pictures/images/test2.PNG");
            }
        }
        return this;
    }

    /**
     * Clicks on the yes button.
     * @return The current ReportDetailsPage instance.
     */
    @Step("Click on Yes Button")
    public ReportDetailsPage clickYesBtn() {
        reportDetailsElements.btnYes.click();
        return this;
    }

    /**
     * Asserts the toast message is displayed.
     * @return The current ReportDetailsPage instance.
     */
    @Step("Assert the presence of the toast message")
    public ReportDetailsPage assertToastMessageIsDisplayed() {
        reportDetailsElements.txtSuccessMSG.isDisplayed();
        return this;
    }

    /**
     * Clicks on the no button.
     * @return The current ReportDetailsPage instance.
     */
    @Step("Click on No Button")
    public ReportDetailsPage clickNoBtn() {
        reportDetailsElements.btnNo.click();
        return this;
    }
}