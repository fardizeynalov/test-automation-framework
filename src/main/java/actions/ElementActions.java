package actions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ElementActions {
    private static final Logger log = LogManager.getLogger(ElementActions.class);
    public WebDriver driver;
    public ElementActions(WebDriver driver){
        this.driver = driver;
    }

    public void click(String locator) {
        log.info("Started to click element '{}'", locator);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        try {
            WebElement element = driver.findElement(getType(locator));
            element.click();
            log.info("Clicked to element: {}", locator);
        } catch (org.openqa.selenium.StaleElementReferenceException e){
            WebElement element = driver.findElement(getType(locator));
            element.click();
            log.info("Clicked to element: {}", locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available for locator: {}", locator);
        } catch (org.openqa.selenium.ElementClickInterceptedException e){
            log.error("Element click intercepted for locator: {}", locator);
        } catch (Exception e){
            log.error("An error occurred: {}", e.getMessage());
        }

    }

    public void sendKeys(String locator, String text){
        log.info("Started to send '{}' to the element '{}'...",text,locator);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        try {
            WebElement element = driver.findElement(getType(locator));
            element.sendKeys(text);
            log.info("'{}' sent successfully to the element: {}",text, locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("An error occurred: {}", e.getMessage());
        }
    }

    public String getText(String locator){
        log.info("Started to find text of element: {}", locator);
        WebElement element = driver.findElement(getType(locator));
        String textOfElem = "";
        try {
            textOfElem = element.getText();
            if (!textOfElem.isEmpty()){
                log.info("Text of '{}' is '{}'", locator, textOfElem);
            } else {
                log.info("Element is not contains any text!");
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("Unable to get text of element: {}", locator + " error message is " + e.getMessage());
        }
        return textOfElem;
    }

    public void isDisplayed(String locator){
        try {
            WebElement element = driver.findElement(getType(locator));
            if (element.isDisplayed()){
                log.info("Element is displayed for given locator: {}", locator);
            } else {
                log.info("Element is not displayed for given locator: {}", locator);
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("Unable to get info about element display: {}", locator + " error message is " + e.getMessage());
        }
    }

    public void assertText(String locator, String expectedText){
        WebElement element = driver.findElement(getType(locator));

        try {
            String actualText = element.getText();
            if (actualText.equals(expectedText)){
                log.info("'{}' and '{}' is equal", expectedText, actualText);
            } else {
                log.error("Expected '{}' but is '{}'", expectedText, actualText);
            }
        } catch (org.openqa.selenium.NoSuchElementException e){
            log.error("Unable to assert text, the reason is {}", e.getMessage());
        } catch (Exception e){
            log.error("An error occurred! Reason is {}", e.getMessage());
        }

    }

    public void selectDropdown(String locator, int index){
        try {
            WebElement selectElem = driver.findElement(getType(locator));
            Select objSelect = new Select(selectElem);
            objSelect.selectByIndex(index);
            log.info("Element selected successfully");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("Selecting from dropdown is failed, possible cause is {}", e.getMessage());
        }

    }

    public void selectDropdown(String locator, String visibleText){
        try {
            WebElement selectElem = driver.findElement(getType(locator));
            Select objSelect = new Select(selectElem);
            objSelect.selectByVisibleText(visibleText);
            log.info("Element selected successfully");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("Selecting from dropdown is failed, possible cause is {}", e.getMessage());
        }
    }

    public void checkCheckbox(String locator){
        WebElement element = driver.findElement(getType(locator));
        try {
            if (!element.isSelected()){
                element.click();
                log.info("{} checked successfully!", locator);
            } else {
                log.info("{} is already checked!", locator);
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("Checking checkbox is failed, error is {}", e.getMessage());
        }

    }

    public void checkCheckboxNotInputElement(String locator){
        WebElement element = driver.findElement(getType(locator));
        try {
            if (element.getAttribute("checked") == null){
                element.click();
                log.info("{} checked successfully!", locator);
            } else {
                log.info("{} is already checked!", locator);
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("Checking checkbox is failed, error is {}", e.getMessage());
        }

    }

    public void uncheckCheckbox(String locator){
        WebElement element = driver.findElement(getType(locator));
        try {
            if (element.isSelected()){
                element.click();
                log.info("{} unchecked successfully!", locator);
            } else {
                log.info("{} is already unchecked!", locator);
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("Unchecking checkbox is failed, error is {}", e.getMessage());
        }

    }

    public void uncheckCheckboxNotInputElement(String locator){
        WebElement element = driver.findElement(getType(locator));
        try {
            if (element.getAttribute("checked") != null){
                element.click();
                log.info("{} unchecked successfully!", locator);
            } else {
                log.info("{} is already unchecked!", locator);
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("Unchecking checkbox is failed, error is {}", e.getMessage());
        }

    }

    public void hover(String locator){
        Actions action = new Actions(driver);
        try {
            WebElement element = driver.findElement(getType(locator));
            action.scrollToElement(element);
            action.moveToElement(element).build().perform();
            log.info("Successfully hovered to the '{}'", locator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (Exception e){
            log.error("Failed to hover element, error is {}", e.getMessage());
        }
    }

    public void switchToFrame(String locator){
        log.info("Trying to switch frame located in {}", locator);
        try {
            driver.switchTo().frame(driver.findElement(getType(locator)));
            log.info("Successfully switched to frame");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for locator: {}", locator);
        } catch (org.openqa.selenium.NoSuchFrameException e){
            log.error("Switching to frame is failed! Reason is {}", e.getMessage());
        } catch (Exception e){
            log.error("Switching to frame is failed! Reason is {}", e.getMessage());
        }
    }

    public void switchToFrame(int index){
        log.info("Trying to switch frame located in index {}", index);
        try {
            driver.switchTo().frame(index);
            log.info("Successfully switched to frame");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.error("Element is not available in the page for index: {}", index);
        } catch (org.openqa.selenium.NoSuchFrameException e){
            log.error("Switching to frame is failed! Reason is {}", e.getMessage());
        } catch (Exception e){
            log.error("Switching to frame is failed! Reason is {}", e.getMessage());
        }
    }

    public void scrollToElement(String locator) {

        WebElement element = driver.findElement(getType(locator));

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Scrolling to element failed! Reason: " + e.getMessage());
        }
    }


    private By getType(String locator) {
        if (locator.startsWith("/") || locator.startsWith("(")) {
            return By.xpath(locator);
        } else if (locator.startsWith("#")) {
            return By.cssSelector(locator);
        } else if (locator.startsWith(".")) {
            return By.className(locator.substring(1));
        } else if (locator.startsWith("name=")) {
            return By.name(locator.substring(5));
        } else if (locator.startsWith("linkText=")) {
            return By.linkText(locator.substring(9));
        } else if (locator.startsWith("partialLinkText=")) {
            return By.partialLinkText(locator.substring(16));
        } else if (locator.startsWith("css=")) {
            return By.cssSelector(locator.substring(4));
        } else if (locator.startsWith("tagName=")) {
            return By.tagName(locator.substring(8));
        } else if (locator.startsWith("id=")) {
            return By.id(locator.substring(3));
        } else {
            return By.id(locator);
        }
    }

}