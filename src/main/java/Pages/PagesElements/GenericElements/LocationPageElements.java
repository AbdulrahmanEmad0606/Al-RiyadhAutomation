package Pages.PagesElements.GenericElements;

import CoreElements.Button;
import CoreElements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationPageElements {
    public WebDriver driver;
    public LocationPageElements(WebDriver driver){
        this.driver=driver;
    }
    public RadioButton selectedStreet=new RadioButton(By.xpath("//div[contains(@class,'nodes-contaienr')]/div['"+ 1 +"']//span[contains(@class,'location-text')]"));
    public Button nextBtn=new Button(By.cssSelector("button.chk-btn.chk-primary-btn[title='التالي']"));
}
