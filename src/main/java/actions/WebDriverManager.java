package actions;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class WebDriverManager {

    private WebDriver driver;

    public void setupDriver(String browserName) {
        driver = DriverFactory.createDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
