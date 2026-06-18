package stepdefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.User;
import org.testng.Assert;
import utils.JsonReader;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("User launches the application")
    public void user_launches_the_application() {

        // If Hooks.java already opens the browser,
        // then this step does nothing.

        System.out.println("Application launched");

    }

    @When("User logs in using {string}")
    public void user_logs_in_using(String userType) {

        User user = JsonReader.getUser(userType);

        loginPage.enterUsername(user.getUsername());

        loginPage.enterPassword(user.getPassword());

        loginPage.clickLogin();

    }

    @Then("User should navigate to Home page")
    public void verifyHomePage() {

        Assert.assertTrue(homePage.isHomePageDisplayed());

    }

    @And("Product {string} should be displayed")
    public void productShouldBeDisplayed(String productName) {
        Assert.assertTrue(homePage.isProductDisplayed(productName));
    }

    @Then("User should see login error")
    public void userShouldSeeLoginError() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }
}
