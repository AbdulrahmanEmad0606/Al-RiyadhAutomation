package UserPortalTests.RoadComponentWorkflow.Inspector;

import GlobalSetup.GlobalSetup;
import Pages.UserPortal.GenericPages.HomePage;
import UserPortalTests.Generic.LoginTests;
import org.testng.annotations.Test;

public class SubmitReport extends GlobalSetup {
    HomePage homePage=new HomePage(driver.getWebDriver());

    String testData = "TestData/Data/roadComponentsData.json";
    LoginTests loginTests;
    @Test
    public void submitReportTC() throws InterruptedException {
        homePage.navigateToActivitiesPage()
                .selectActivity(getJson(testData,"pages","Activities","ActivityName"))
                .selectReportType().NavigateToMunicipalityPage()
                .selectMunicipality(getJson(testData,"pages","Locations","municipalityName"))
                .navigateToDistrictPage().selectDistrict(getJson(testData,"pages","Locations","districtName"))
                .navigateToStreetPage().selectStreet().navigateToRoadComponentCheckList().fillForm();
    }

}