package driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {


    // ThreadLocal makes the framework ready for parallel execution later.
    // Even if we're not running in parallel now, this is an industry best practice.
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Creates a new Chrome browser instance.
     */
    public static void initDriver() {

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver.set(new ChromeDriver());

        } else {

            throw new RuntimeException("Browser not supported : " + browser);

        }

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty("implicitWait")
                        )
                )
        );

    }

    /**
     * Returns the WebDriver for the current thread.
     */
    public static WebDriver getDriver() {

        return driver.get();
    }

    /**
     * Closes the browser and removes the driver instance.
     */
    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();

        }

    }

}
