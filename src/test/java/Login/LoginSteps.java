package Login;

import Pages.LoginMethods;
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

    public static LoginMethods swagLoginMethods;
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = getChromeConfig();
        swagLoginMethods = new LoginMethods(driver);
    }

    @AfterAll
    public static void exit() {
        driver.close();
    }

    @And("Click Login")
    public void clickLogin() {
        LoginMethods.clickLogin();
    }


    // TC-001
    @When("Enter credentials")
    public void Enter_credentials() {
        LoginMethods.enterValidUser();
        LoginMethods.enterValidPass();
    }

    @Then("User will navigate to products page {string}")
    public void User_will_navigate_to_products_page(String expectedURL) {
        LoginMethods.productsPage();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL);
        System.out.println("Expected Url: " + expectedURL);
    }

    // TC-002
    @When("I enter non credentials account")
    public void nonCredentialsAccount() {
        LoginMethods.enterInvalidUser();
        LoginMethods.enterValidPass();
    }

    // TC-003
    @When("I enter locked credentials account")
    public void lockedAccount() {
        LoginMethods.enterLockedUser();
        LoginMethods.enterValidPass();
    }

    // TC-004
    @When("I input only password field")
    public void passwordInputOnly() {
        LoginMethods.enterValidPass();
    }

    // TC-005
    @When("I input only username field")
    public void usernameInputOnly() {
        LoginMethods.enterValidUser();
    }


    @Then("The user is unable to log in and show an error message {string}")
    public void unableToLogin(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

}
