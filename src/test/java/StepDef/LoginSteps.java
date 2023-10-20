package StepDef;

import Pages.AddToCart;
import Pages.CheckOutMethods;
import Pages.LoginMethods;
import Pages.ProductsPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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
        new ProductsPage(driver);
        new AddToCart(driver);
        new CheckOutMethods(driver);
    }

    @AfterAll
    public static void exit() {
        driver.close();
    }

    @And("Click Login")
    public void clickLogin() {
        LoginMethods.clickLogin();
    }

    @Given("I clear the username and password field")
    public void clear_field() throws InterruptedException {
        LoginMethods.clearField();
        Thread.sleep(2000);
    }

    // TC-001
    @When("Enter credentials")
    public void Enter_credentials() {
        LoginMethods.enterValidUser();
        LoginMethods.enterValidPass();
    }

    @Then("User will navigate to products page {string}")
    public void User_will_navigate_to_products_page(String expectedURL) throws InterruptedException {
        LoginMethods.productsPage();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL);
        System.out.println("Expected Url: " + expectedURL);
        LoginMethods.clickLogout();
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
    public void unableToLogin(String expectedError) throws InterruptedException {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualError = error_message.getText();
        Assert.assertEquals(expectedError, actualError);
        System.out.println("Actual Error: " + actualError);
        System.out.println("Expected Error: " + expectedError);
        Thread.sleep(2000);
    }
}
