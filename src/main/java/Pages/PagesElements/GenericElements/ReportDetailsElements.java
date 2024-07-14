package Pages.PagesElements.GenericElements;

import CoreElements.*;
import Pages.UserPortal.MaradimCustomPages.MaradimCheckList;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the elements of a report details page on a webpage.
 * It provides methods to interact with these elements, such as getting the report number, show actions button, report state, assigned to, specific action, required actions, notes, attachments, yes button, no button, and success message.
 */
public class ReportDetailsElements {
    public WebDriver driver;

    /**
     * Constructor for the ReportDetailsElements class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public ReportDetailsElements(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Label object representing the report number on the report details page.
     */
    public Label reportNumber = new Label(By.xpath("//*[@id=\"chk.report.details.reportId\"]/p"));

    /**
     * Button object representing the show actions button on the report details page.
     */
    public Button showActions = new Button(By.id("chk.report.details.actions.button"));

    /**
     * Label object representing the report state on the report details page.
     */
    public Label txtReportState = new Label(By.xpath("//div[@id='chk.report.details.reportState']//p"));

    /**
     * Label object representing the assigned to on the report details page.
     */
    public Label txtAssignedTo = new Label(By.xpath("//div[@id='chk.report.details.assignedTo']//p"));

    /**
     * Returns a Label object representing a specific action on the report details page.
     * @param actionName The name of the action.
     * @return A Label object.
     */
    public Label getSpecificAction(String actionName) {
        return new Label(By.xpath("//ul[@id='dropdown-basic']//li//a[text()='" + actionName + "']"));
    }

    /**
     * Returns a Label object representing the required actions on the report details page.
     * @param optionName The name of the option.
     * @return A Label object.
     */
    public Label checkTheRequiredActions(String optionName){
        return new Label(By.xpath("//*[@id=\"chk.report.details.actions.modal.note.textArea\"]//parent::div[1]//label[text()='"+optionName+"']"));
    }

    /**
     * TextBox object representing the notes on the report details page.
     */
    public TextBox notes= new TextBox(By.xpath("//*[@id=\"chk.report.details.actions.modal.note.textArea\"]//textarea"));

    /**
     * Button object representing the attachments on the report details page.
     */
    public Button attachments= new Button(By.id("file"));

    /**
     * Button object representing the yes button on the report details page.
     */
    public Button btnYes = new Button(By.xpath("//chk-button[@id='chk.report.details.actions.modal.submit.button']//button"));

    /**
     * Button object representing the no button on the report details page.
     */
    public Button btnNo = new Button(By.xpath("//chk-button[@id='chk.report.details.actions.modal.cancel.button']//button"));

    /**
     * Label object representing the success message on the report details page.
     */
    public Label txtSuccessMSG =new Label(By.xpath("//div[contains(@class, 'toast-title')]"));
}