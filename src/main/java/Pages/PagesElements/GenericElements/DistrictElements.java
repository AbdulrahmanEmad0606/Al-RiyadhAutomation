package Pages.PagesElements.GenericElements;

import CoreElements.Button;
import CoreElements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DistrictElements {
    public WebDriver driver;
    public DistrictElements(WebDriver driver) {
        this.driver = driver;
    }

    public Label getDistrictName(String districtName){
        return new Label(By.xpath("//chk-tree-view/div/div[3]/div/div/div/span[text()='"+districtName+"']"));
    }
    public Button showStreets= new Button(By.xpath("//chk-tree-view/div/div[3]/div[1]/div/span"));
}
