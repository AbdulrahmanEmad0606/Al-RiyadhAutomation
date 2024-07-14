package Pages.UserPortal.RoadComponentsCustomPages;

import CoreElements.Element;
import Pages.PagesElements.RoadComponentCustomElements.RoadComponentsChecklistElements;
import Pages.UserPortal.GenericPages.ReportDetailsPage;
import org.openqa.selenium.WebDriver;

public class RoadComponentsCheckList {


    private WebDriver driver;

    public RoadComponentsCheckList(WebDriver driver) {
        this.driver = driver;
    }

    RoadComponentsChecklistElements checkListElements = new RoadComponentsChecklistElements(Element.getWebDriver());

    public ReportDetailsPage fillForm() throws InterruptedException {

        checkListElements.mainFactorBtn.click();
        checkListElements.mainFactorValue.click();
        checkListElements.secondSection.click();
        checkListElements.length.setText("10");
        checkListElements.gpsField.click();
        checkListElements.importanceBtn.click();
        checkListElements.importanceValue.click();
        checkListElements.attachmentButton.setText("C:/Users/DELL/Pictures/images/Test.PNG");
        checkListElements.attachmentButton.setText("C:/Users/DELL/Pictures/images/Test2.PNG");
        Thread.sleep(70000);
        checkListElements.submitButton.click();
        return new ReportDetailsPage(driver);
    }
}
