package Pages.UserPortal.MaradimCustomPages;

import CoreElements.Element;
import Pages.PagesElements.GenericElements.CheckListElements;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class represents the Maradim checklist page on a webpage.
 * It provides methods to interact with this page, such as answering specific question options, answering inputs for questions, answering dropdowns, filling all attachments, clicking on the submit button, clicking on the cancel button, asserting the presence of the successful message, and clicking on the successful message.
 */
public class MaradimCheckList {

    /**
     * WebDriver instance used to interact with the webpage.
     */
    private WebDriver driver;

    /**
     * Constructor for the MaradimCheckList class.
     * @param driver The WebDriver instance used to interact with the webpage.
     */
    public MaradimCheckList(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * CheckListElements object representing the elements on the Maradim checklist page.
     */
    CheckListElements maradimElements = new CheckListElements(Element.getWebDriver());

    /**
     * Answers a specific question option with space.
     * @param question The question to answer.
     * @param option The option to select.
     * @return The current MaradimCheckList instance.
     */
    @Step("Answer question option with space")
    public MaradimCheckList answerSpecificQuestionOptionWithSpace(String question, String option){
       maradimElements.getSpecificQuestionOptionWithSpace(question, option).radioBtnClick();
        return this;
    }

    /**
     * Answers a specific question option.
     * @param question The question to answer.
     * @param option The option to select.
     * @return The current MaradimCheckList instance.
     */
    @Step("Answer specific question option")
    public MaradimCheckList answerSpecificQuestionOption(String question, String option){
        maradimElements.getSpecificQuestionOption(question, option).radioBtnClick();
        return this;
    }

    /**
     * Answers an input for a question.
     * @param question The question to answer.
     * @param value The value to input.
     * @return The current MaradimCheckList instance.
     */
    @Step("Answer question input")
    public MaradimCheckList answerInputForQuestion(String question, String value){
        maradimElements.getInputForQuestion(question).setText(value);
        return this;
    }

    /**
     * Answers a dropdown.
     * @param question The question to answer.
     * @param index The index of the option to select.
     * @return The current MaradimCheckList instance.
     */
    @Step("Answer dropdown")
    public MaradimCheckList answerDropdown(String question, String index){
        maradimElements.getSelectButtonForDropdown(question).click();
        maradimElements.getOptionFromDropdown(index).click();
        return this;
    }

    /**
     * Fills all attachments.
     * @param filePath The file path of the attachment to upload.
     * @return The current MaradimCheckList instance.
     */
    @Step("fill all attachments")
    public MaradimCheckList fillAllAttachments(String filePath){
        maradimElements.btnAttachment.uploadPhotoToAllElements(filePath);
        return this;
    }

    /**
     * Clicks on the submit button.
     * @return The current MaradimCheckList instance.
     */
    @Step("Click on the submit button")
    public MaradimCheckList clickSubmit(){
        driver.navigate().refresh();
        maradimElements.btnSubmit.click();
        return this;
    }

    /**
     * Clicks on the cancel button.
     * @return The current MaradimCheckList instance.
     */
    @Step("Click on the cancel button")
    public MaradimCheckList clickCancel(){
        maradimElements.btnCancel.click();
        return this;
    }

    /**
     * Asserts the presence of the successful message.
     * @return True if the successful message is displayed, false otherwise.
     */
    @Step("Assert the presence of the successful message")
    public boolean assertTheDisplayOfTheSuccessfulMsg(){
        return maradimElements.txtSuccessMsg.isDisplayed();
    }

    /**
     * Clicks on the successful message.
     */
    @Step("Click on the Successfull message")
    public void clickOnSuccessMsg(){
        maradimElements.txtSuccessMsg.click();
    }
}