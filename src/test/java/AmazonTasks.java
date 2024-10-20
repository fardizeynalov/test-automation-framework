import actions.ApiTest;
import actions.ElementActions;
import actions.WebDriverManager;
import base.BasePage;
import data.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AmazonTasks {
    WebDriverManager wdm = new WebDriverManager();
    WebDriver driver = wdm.setupDriver("chrome");
    ElementActions ea = new ElementActions(driver);
    ApiTest at = new ApiTest();
    TestData td = new TestData();
    BasePage bp = new BasePage(driver);


    @BeforeMethod
    public void setDriver(){

        bp.openUrl("https://www.amazon.com/");

    }

    @Test
    public void testAtLeastThreeResultForLaptop(){
        ea.sendKeys("twotabsearchtextbox","Laptop");
        ea.click("nav-search-submit-button");

    }

//    @DataProvider(name = "testDataProvider")
//    final public Object[][] testDataProvider() {
//        return new Object[][] {
//                { "user1" }
//        };
//    }


    @Test(dataProvider = "searchData", dataProviderClass = TestData.class)
    public void verifyHeaderIsMatch(String search){

        ea.sendKeys("twotabsearchtextbox", search);
        ea.click("nav-search-submit-button");
        String expectedText = ea.getText("(//h2[contains(@class,'a-size-mini')])[1]//span");
        ea.click("(//h2[contains(@class,'a-size-mini')])[1]//span");
        String actualText = ea.getText("//span[@id='productTitle']");
        ea.assertText("//span[@id='productTitle']",expectedText);
    }

    @Test
    public void apiTestEx(){
        Object body = "{ \"userName\": \"string\", \"password\": \"string\", \"otp\": \"string\" }";

        at.postApiRequest("//api.necpt.pro/api/Auth/Login", body);

    }

    @Test
    public void testCheckbox(){
        bp.openUrl("https://www.libraff.az/profiles-add-az/");
        ea.scrollToElement("//input[@id='profile_mailing_list_1']");
        ea.checkCheckbox("//input[@id='profile_mailing_list_1']");
        ea.click("wedwde");
        ea.uncheckCheckbox("//input[@id='profile_mailing_list_1']");
        ea.click("wedwde");


    }

    @AfterSuite
    public void tearDown(){
        wdm.tearDown();
    }


}
