package Pages.PagesElements.GenericElements;

import CoreElements.Button;
import CoreElements.Label;
import CoreElements.RadioButton;
import CoreElements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the elements of a checklist on a webpage.
 * It provides methods to interact with these elements, such as getting specific question options, input for questions, and buttons for dropdowns.
 */
public class CheckListElements {
    public WebDriver driver;

    /**
     * Constructor for the CheckListElements class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public CheckListElements(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns a RadioButton object representing a specific question option with space.
     * @param question The text of the question.
     * @param option The text of the option.
     * @return A RadioButton object.
     */
    public RadioButton getSpecificQuestionOptionWithSpace(String question, String option) {
        return new RadioButton(By.xpath("//div[text()='" + " " + question + "  " + "']/parent::label/following-sibling::div//label[text()='" + option + "']")); // /preceding-sibling::input
    }

    /**
     * Returns a RadioButton object representing a specific question option.
     * @param question The text of the question.
     * @param option The text of the option.
     * @return A RadioButton object.
     */
    public RadioButton getSpecificQuestionOption(String question, String option) {
        return new RadioButton(By.xpath("//div[text()='" + " " + question + " " + "']/parent::label/following-sibling::div//label[text()='" + option + "']"));
    }

    /**
     * Returns a TextBox object representing the input for a specific question.
     * @param question The text of the question.
     * @return A TextBox object.
     */
    public TextBox getInputForQuestion(String question) {
        return new TextBox(By.xpath("//div[text()='" + " " + question + " " + "']/ancestor::label/following-sibling::div//input"));
    }

    /**
     * Returns a Button object representing the select button for a dropdown associated with a specific question.
     * @param question The text of the question.
     * @return A Button object.
     */
    public Button getSelectButtonForDropdown(String question) {
        return new Button(By.xpath("//div[text()='" + " " + question + " " + "']/ancestor::label/following-sibling::div//button[@class='ngx-dropdown-button']"));
    }

    /**
     * Returns a Button object representing an option from a dropdown.
     * @param index The index of the option in the dropdown.
     * @return A Button object.
     */
    public Button getOptionFromDropdown(String index) {
        return new Button(By.xpath("(//ul[@class='available-items']//li)[" + index + "]"));
    }

    // Button for attaching files
    public Button btnAttachment = new Button(By.xpath("//div[contains(@class, 'input-file-button')]//input[@type='file']"));
    // Button for submitting the form
    public Button btnSubmit = new Button(By.xpath("//chk-button[@title='root.global.submit']"));
    // Button for cancelling the form
    public Button btnCancel = new Button(By.xpath("//chk-button[@title='root.global.cancel']"));
    // Label for displaying success messages
    public Label txtSuccessMsg = new Label(By.xpath("//*[@id='toast-container']"));

}