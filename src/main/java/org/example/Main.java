package org.example;
import actions.ApiTest;
import actions.ElementActions;
import actions.WebDriverManager;
import base.BasePage;
import data.TestData;
import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager wdm = new WebDriverManager();
//        wdm.setupDriver("SafaRi");
//        WebDriver driver = wdm.getDriver();
//        BasePage bp = new BasePage(driver);
//        ElementActions ea = new ElementActions(driver);

//        bp.openUrl("https://jqueryui.com/selectmenu/");
//        ea.hover("//a[text()='Themes']");
        ApiTest at = new ApiTest();
        String body = "{\"title\": \"I think I should shift to the moon\"}";
//        at.getApiResponse("https://dummyjson.com/posts/1");
//        at.postApiRequest("https://dummyjson.com/posts/add", body);
        at.deleteApiRequest("https://dummyjson.com/posts/1");
//        at.putApiRequest("https://dummyjson.com/posts/1", body);
//        at.putApiRequest("https://jsonplaceholder.typicode.com/posts/1", body);
//        at.validateResponse(at.getApiResponse("https://httpbin.org/get"), 209);


//        wdm.tearDown();

//        ea.click("tagName=input");
//        ea.sendKeys("tagName=input","write something");
//        ea.getText("/html/body/div/div[2]/div/div[1]/p[1]");
//        ea.isDisplayed(".constrain");
//        ea.assertText("//div[@class='demo-list']//h2", "Examples");
//        ea.switchToFrame("tagName=iframe");
//        Boolean a = driver.findElement(By.xpath("//input[@name='checkbox-1']")).isSelected();
//        ea.checkCheckbox("//label[@for='checkbox-1']");
//        Thread.sleep(4000);
//        ea.click("//span[@id='files-button']");
//        ea.selectDropdown("name=files", "Some unknown file");


    }
}