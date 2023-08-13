package Login;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static configuration.DriverConfig.getChromeConfig;
import static constant.Login.ERROR_MESSAGE;

public class LoginSteps {

    public static SwagLabLogin swagLabLogin;
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = getChromeConfig();
        swagLabLogin = new SwagLabLogin(driver);
    }

    @AfterAll
    public static void exit() {
        driver.close();
    }

    @And("Click Login")
    public void clickLogin() {
        SwagLabLogin.clickLogin();
    }

    @When("Enter credentials")
    public void Enter_credentials() {
        SwagLabLogin.enterValidUser();
        SwagLabLogin.enterValidPass();
    }

    @Then("User will navigate to products page {string}")
    public void User_will_navigate_to_products_page(String expectedURL) {
        SwagLabLogin.productsPage();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL);
        System.out.println("Expected Url: " + expectedURL);
    }

    @When("I enter non credentials account")
    public void nonCredentialsAccount() {
        SwagLabLogin.enterInvalidUser();
        SwagLabLogin.enterValidPass();
    }

    @Then("Unable to login {string}")
    public void errorMessage(String expectedError) {
        SwagLabLogin.ErrorMessageNonUser();
        System.out.println("The Expected Error Message: " + expectedError);
    }

    @When("I enter locked credentials account")
    public void lockedAccount() {
        SwagLabLogin.enterLockedUser();
        SwagLabLogin.enterValidPass();
    }

    @Then("The account enable to login {string}")
    public void unableToLogin(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

    @When("I input only password field")
    public void passwordInputOnly() {
        SwagLabLogin.enterValidPass();
    }

    @Then("Show error message for required username field {string}")
    public void errorUserField(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

    @When("I input only username field")
    public void usernameInputOnly() {
        SwagLabLogin.enterValidUser();
    }

    @Then("Show error message for required password field {string}")
    public void errorPassField(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

    @Then("Show error message for required field {string}")
    public void errorField(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

}
