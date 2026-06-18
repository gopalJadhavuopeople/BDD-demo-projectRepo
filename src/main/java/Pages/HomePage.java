package Pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = DriverFactory.getDriver();
    }

    // Locators

    private By lblProducts = By.className("title");

    private By backpack =
            By.xpath("//div[text()='Sauce Labs Backpack']");

    // Verification

    public boolean isHomePageDisplayed() {

        return driver.findElement(lblProducts).isDisplayed();

    }

    public boolean isProductDisplayed(String productName) {

        By product = By.xpath("//div[text()='" + productName + "']");

        return driver.findElement(product).isDisplayed();

    }

}
