package Pages.PagesElements.GenericElements;

import CoreElements.Button;
import CoreElements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TasksElements {

    public WebDriver driver;
    public TasksElements(WebDriver driver){
        this.driver=driver;
    }
    public Button showAllBTN = new Button(By.cssSelector(".see-all a"));
    public Label task = new Label(By.xpath("//datatable-body-cell[1]/div/a"));
}
