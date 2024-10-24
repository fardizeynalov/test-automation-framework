import actions.ElementActions;
import actions.WebDriverManager;
import base.BasePage;
import data.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LibraffUiScenarios {
    WebDriverManager wdm = new WebDriverManager();
    WebDriver driver = wdm.setupDriver("chrome");
    ElementActions ea = new ElementActions(driver);
    TestData td = new TestData();
    BasePage bp = new BasePage(driver);

    @BeforeMethod
    public void setDriver(){

        bp.openUrl("https://www.libraff.az/");

    }

    @Test
    public void testItemsStayCartAfterLogoutAndLogin(){
        ea.click("//div[@id='sw_dropdown_64']//div//a");
        ea.click("css=a[data-ca-target-id='login_block222']");
        ea.sendKeys("login_popup222", td.getTestData("mail"));
        ea.sendKeys("psw_popup222", td.getTestData("password"));
        ea.clickButton("psw_popup222", "enter");
        ea.click("//div[@style='height:270px']//a[@href]//img");
        ea.click("//span[text()='Səbətə əlavə et']");
        ea.click("//span[contains(@class, 'cm-notification-close')]");
        String cartCountExpected = ea.getText("//span[@class='ty-minicart-count']");
        ea.click("//div[@id='sw_dropdown_64']//div//a");
        ea.click("//a[text()='Çıxış']");
        ea.click("//div[@id='sw_dropdown_64']//div//a");
        ea.click("css=a[data-ca-target-id='login_block222']");
        ea.sendKeys("login_popup222", td.getTestData("mail"));
        ea.sendKeys("psw_popup222", td.getTestData("password"));
        ea.clickButton("psw_popup222", "enter");
        ea.assertText("//span[@class='ty-minicart-count']", cartCountExpected);
    }

    @Test(dataProvider = "addresses", dataProviderClass = TestData.class)
    public void testAddressUpdatedInOrderAfterChangeAddress(String address){
        ea.click("//div[@id='sw_dropdown_64']//div//a");
        ea.click("css=a[data-ca-target-id='login_block222']");
        ea.sendKeys("login_popup222", td.getTestData("mail"));
        ea.sendKeys("psw_popup222", td.getTestData("password"));
        ea.clickButton("psw_popup222", "enter");
        ea.click("//div[@id='sw_dropdown_64']//div//a");
        ea.click("//li[contains(@class,'dropdown')]//a[text()='Hesabım']");
        ea.scrollToElement("name=user_data[s_address]");
        ea.clearInput("name=user_data[s_address]");
        ea.sendKeys("name=user_data[s_address]", address);
        ea.click("save_profile_but");
        ea.click("//a[@href='https://www.libraff.az/']");
        ea.click("//div[@style='height:270px']//a[@href]//img");
        ea.click("//span[text()='Səbətə əlavə et']");
        ea.click("//span[contains(@class, 'cm-notification-close')]");
        ea.click("//span[@class='ty-minicart-count']");
        ea.click("//span[text()='Sifarişi təsdiqləmək']");
        Assert.assertEquals(ea.getAttributeOfElem("litecheckout_s_address","value"), address);
    }

    @Test
    public void testMoreProductThanStockImpossibleToAddCart(){
        ea.click("//div[@id='sw_dropdown_64']//div//a");
        ea.click("css=a[data-ca-target-id='login_block222']");
        ea.sendKeys("login_popup222", td.getTestData("mail"));
        ea.sendKeys("psw_popup222", td.getTestData("password"));
        ea.clickButton("psw_popup222", "enter");
        ea.click("psw_popup2223");
        ea.sendKeys("search_input", td.getTestData("bookName"));
        ea.clickButton("search_input", "enter");
        ea.click(".ut2-gl__image");
        ea.click("//span[text()='Səbətə əlavə et']");
        ea.click("//span[contains(@class, 'cm-notification-close')]");
        ea.click(".ty-minicart-count");
        ea.click("//a[text()='Səbət']");
        ea.clearInput("//input[@size='3']");
        ea.sendKeys("//input[@size='3']", "100");
        ea.clickButton("//input[@size='3']", "enter");
        ea.isDisplayed("//div[contains(@class,'warning')]");
    }

    @Test
    public void testCountChangeAfterChangingCountOfOrder(){
        ea.click("//div[@id='sw_dropdown_64']//div//a");
        ea.click("css=a[data-ca-target-id='login_block222']");
        ea.sendKeys("login_popup222", td.getTestData("mail"));
        ea.sendKeys("psw_popup222", td.getTestData("password"));
        ea.clickButton("psw_popup222", "enter");
        ea.click("psw_popup2223");
        ea.sendKeys("search_input", "yay mövsümü");
        ea.clickButton("search_input", "enter");
        ea.click(".ut2-gl__image");
        ea.click("//span[text()='Səbətə əlavə et']");
        ea.click("//span[contains(@class, 'cm-notification-close')]");
        ea.click(".ty-minicart-count");
        ea.click("//a[text()='Səbət']");
        ea.sendKeys("//input[@size='3']", "100");
        ea.click("//span[text()='Sifarişi təsdiqlə']");
        ea.assertText("//td[@data-ct-checkout-summary='items']//preceding-sibling::td","100 əd.");
    }

    @Test
    public void testUserNameIsPresentOnDropDown(){
        ea.click("//div[@id='sw_dropdown_64']//div//a");
        ea.click("css=a[data-ca-target-id='login_block222']");
        ea.sendKeys("login_popup222", td.getTestData("mail"));
        ea.sendKeys("psw_popup222", td.getTestData("password"));
        ea.clickButton("psw_popup222", "enter");
        ea.click("abcd");
        ea.click("//div[@id='sw_dropdown_64']//div");
        ea.assertText("//li[contains(@class,'ty-account-info__name')]", td.getTestData("username"));
    }

    @AfterMethod
    public void clearCartAndTearDown(){
        ea.click(".ty-minicart-count");
        ea.click("//a[text()='Səbət']");
        ea.click("//a[text()='Səbəti təmizlə']");
//        ea.click("abcd");
        wdm.tearDown();
    }
}
