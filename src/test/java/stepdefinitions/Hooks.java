package stepdefinitions;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ScreenshotUtils;

public class Hooks {
    @Before
    public void setUp() {

        DriverFactory.initDriver();

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url")
        );

    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            scenario.attach(
                    ScreenshotUtils.takeScreenshot(),
                    "image/png",
                    scenario.getName()
            );

        }

        DriverFactory.quitDriver();

}}
