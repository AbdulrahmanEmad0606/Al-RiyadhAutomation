package Pages.PagesElements.GenericElements;

import CoreElements.Button;
import CoreElements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MunicipalityElements {
    public WebDriver driver;
    public MunicipalityElements(WebDriver driver) {
        this.driver = driver;
    }

    public Label getMunicipalityName(String activityName){
        return new Label(By.xpath("//chk-tree-view/div/div[3]/div/div/div/span[text()='"+activityName+"']"));
    }
    public Button showDistricts= new Button(By.xpath("//chk-tree-view/div/div[3]/div[1]/div/span"));
    }