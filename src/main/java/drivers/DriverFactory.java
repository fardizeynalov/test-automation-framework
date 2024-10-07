package drivers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class DriverFactory {

    public static WebDriver createDriver(String browser){
        WebDriver driver;
        final Logger log = LogManager.getLogger(DriverFactory.class);
        log.info("Started to create driver...");
        switch (browser.toLowerCase()){

            case "chrome":
                driver = new ChromeDriver();
                log.info("Chrome driver created successfully!");
                break;

            case "safari":
                driver = new SafariDriver();
                log.info("Safari driver created successfully!");
                break;

            case "firefox":
                driver = new FirefoxDriver();
                log.info("Firefox driver created successfully!");
                break;

            default:
                throw new IllegalArgumentException("Browser type not supported: " + browser + ". Supported Browsers are chrome, safari and firefox.");
        }

        return driver;
    }

}