package Pages.PagesElements.GenericElements;

import CoreElements.Button;
import CoreElements.Label;
import CoreElements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StreetElements {
    public WebDriver driver;
    public StreetElements(WebDriver driver) {
        this.driver = driver;
    }

    public Label getStreetName(String streetName){
        return new Label(By.xpath("//chk-tree-view/div/div[3]/div/div/div/span[text()='"+streetName+"']"));
    }
    public RadioButton selectedStreet= new RadioButton(By.cssSelector(".node-radio-button.mx-1.position-relative:first-of-type"));
    public Button nextButton = new Button(By.cssSelector("button.chk-primary-btn[title='التالي']"));
}
