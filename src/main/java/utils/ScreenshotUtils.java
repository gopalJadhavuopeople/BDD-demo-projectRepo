package utils;

import driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {
    public static byte[] takeScreenshot() {

        TakesScreenshot ts =
                (TakesScreenshot) DriverFactory.getDriver();

        return ts.getScreenshotAs(OutputType.BYTES);

    }
}
