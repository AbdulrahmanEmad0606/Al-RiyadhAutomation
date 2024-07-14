package Pages.PagesElements.GenericElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataTableElements {
    public WebDriver driver;

    public DataTableElements(WebDriver driver) {
        this.driver = driver;
    }

    public By dataTable = By.cssSelector("ngx-datatable");

}
