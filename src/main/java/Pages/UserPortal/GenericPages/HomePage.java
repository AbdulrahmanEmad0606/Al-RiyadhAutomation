package Pages.UserPortal.GenericPages;

import CoreElements.Element;
import Pages.PagesElements.GenericElements.HomePageElements;
import Pages.PagesElements.GenericElements.LoginElements;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    LoginElements loginElements=new LoginElements(Element.getWebDriver());

    HomePageElements homePageElements=new HomePageElements(Element.getWebDriver());

    public boolean getGreetingLabel(String text)  {
        return homePageElements.greetingMSG.containText(text);
    }

    @Feature("Submit Form")
    @Step("click on plus and navigate to location page")
    public ActivitiesPage navigateToActivitiesPage() {
        homePageElements.plusIcon.click();
        return new ActivitiesPage(driver);
    }

    public TasksPage navigateToTaskPage() {
        homePageElements.taskIcon.click();
        return new TasksPage(driver);
    }


    /*********************************************************************/

    @Feature("Logout")
    @Step("click on arrow button")
    public HomePage clickOnArrowBTN(){
        homePageElements.arrowDownBTN.click();
        return this;
    }
    @Step("click on Logout Link")
    public HomePage clickOnLogoutLink(){
        homePageElements.logoutLink.click();
        return this;
    }
    @Step("click on Logout Button")
    public boolean clickOnLogoutBTN(){
      homePageElements.logoutButton.click();
       return loginElements.loginBtn.isDisplayed();
    }
}
