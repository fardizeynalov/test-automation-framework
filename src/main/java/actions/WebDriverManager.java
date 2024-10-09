package actions;
import drivers.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class WebDriverManager {

    private static final Logger log = LogManager.getLogger(WebDriverManager.class);
    public WebDriver driver;

    public WebDriver setupDriver(String browserName) {
        driver = DriverFactory.createDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

//    public WebDriver getDriver() {
//        return driver;
//    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Driver successfully tear down!");
        }
    }
}
