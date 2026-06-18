package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // logger for diagnostic messages
    private static final Logger log = LogManager.getLogger(DriverFactory.class);

    public static void initDriver() {

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Debug: print resolved headless value
            log.info("[DriverFactory] headless => {}", isHeadless());

            if (isHeadless()) {

                // Use headless arg for compatibility with different Selenium versions
                options.addArguments(
                        "--headless=new",
                        "--remote-allow-origins=*",
                        "--no-sandbox",
                        "--disable-dev-shm-usage",
                        "--window-size=1920,1080",
                        "--disable-gpu"
                );

            }

            try {
                driver.set(new ChromeDriver(options));
            } catch (Exception e) {
                log.error("[DriverFactory] Failed to start ChromeDriver: {}", e.getMessage(), e);
                throw new RuntimeException(e);
            }

        } else {

            throw new RuntimeException("Browser not supported : " + browser);

        }

        if (!isHeadless()) {
            getDriver().manage().window().maximize();
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicitWait"))));
    }

    // Determines whether browser should run in headless mode.
    // Priority: 1. JVM Parameter (-Dheadless=true) 2. Environment Variable (HEADLESS=true) 3. config.properties
    private static boolean isHeadless() {

        String systemProperty = System.getProperty("headless");

        if (systemProperty != null) {
            return Boolean.parseBoolean(systemProperty);
        }

        String envVariable = System.getenv("HEADLESS");

        if (envVariable != null) {
            return Boolean.parseBoolean(envVariable);
        }

        return Boolean.parseBoolean(
                ConfigReader.getProperty("headless")
        );
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }

    }
}
