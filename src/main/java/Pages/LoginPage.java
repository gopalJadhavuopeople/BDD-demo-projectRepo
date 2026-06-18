package Pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Constructor
    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    // Locators
    private By txtUsername = By.id("user-name");
    private By txtPassword = By.id("password");
    private By btnLogin = By.id("login-button");

    // login error locator
    private By loginError = By.cssSelector("[data-test='error']");

    // Actions

    public void enterUsername(String username) {
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }

    // Verification

    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(loginError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
