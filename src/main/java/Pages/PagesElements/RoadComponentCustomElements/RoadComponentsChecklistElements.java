package Pages.PagesElements.RoadComponentCustomElements;

import CoreElements.Button;
import CoreElements.Label;
import CoreElements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RoadComponentsChecklistElements {
    public WebDriver driver;

    public RoadComponentsChecklistElements(WebDriver driver) {
        this.driver = driver;
    }

    int mainFactorIndex = 2;
    public Button mainFactorBtn = new Button(By.cssSelector(".ngx-dropdown-container .ngx-dropdown-button"));
    public Label secondSection = new Label(By.xpath("//chk-form-builder/nav/div[2]/label[2]"));
    public TextBox length = new TextBox(By.id("feedback_min_accepted_value"));
    public Button importanceBtn = new Button(By.xpath("//div/div[3]/div/div/div[1]/chk-search-input/ngx-select-dropdown"));
    public Label importanceValue = new Label(By.xpath("//chk-search-input/ngx-select-dropdown/div/div/ul[2]/li[1]"));
    public Button submitButton = new Button(By.xpath("//chk-button[2]/button/span"));
    public TextBox attachmentButton = new TextBox(By.cssSelector("chk-attatchment input[type='file']"));
    public Button gpsField = new Button(By.cssSelector(".chk-map-leaflet.leaflet-container"));
    public Label mainFactorValue = new Label(By.xpath("//chk-search-input/ngx-select-dropdown/div/div/ul[2]/li['" + mainFactorIndex + "']"));

}
