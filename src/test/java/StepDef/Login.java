package StepDef;

import Page.AddToCart;
import Page.LoginMethods;
import Page.ProductListing;
import Page.RemoveProducts;
import Util.SwagLabUtil;
import configuration.DriverConfig;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static configuration.DriverConfig.getChromeConfig;
import static constant.Login.*;

public class Login {


    public static LoginMethods swagLabLogin;
    public static WebDriver driver;


    @BeforeAll
    public static void setUp() {
        driver = getChromeConfig();
        swagLabLogin = new LoginMethods(driver);
        new ProductListing(driver);
        new AddToCart(driver);
        new RemoveProducts(driver);
        new SwagLabUtil(driver);
    }

    @AfterAll
    public static void exit() {
        driver.close();

    }

    @And("Clicked Login")
    public void clickLoginButton() {
        swagLabLogin.clickLogin();
    }

    @When("Login is Clicked")
    public void LoginButton() {
        swagLabLogin.clickLogin();
    }


    //When
    @When("A registered user entered a valid {string} and {string}")
    public void loginRegisteredAccount(String username, String password) throws InterruptedException {
        swagLabLogin.inputRegisteredUsername(username);
        Thread.sleep(3000);
        swagLabLogin.validPassword(password);
        Thread.sleep(3000);
    }

    @When("An unregistered user entered username and password")
    public void loginUnregisteredAccount() {
        swagLabLogin.inputUnregisteredUsername();
        swagLabLogin.invalidPassword();
    }

    @When("A locked-out user entered {string} and {string}")
    public void loginLockedOutUser(String username, String password) {
        swagLabLogin.inputLockedOutUsername(username);
        swagLabLogin.validPassword(password);
    }

    @When("The user entered a password {string}")
    public void enterPasswordOnly(String password) {
        swagLabLogin.validPassword(password);
    }

    @When("The user entered a username {string}")
    public void enterUsernameOnly(String username) {
        swagLabLogin.inputRegisteredUsername(username);
    }

    //Then
    @Then("The user will navigate to the products page {string}")
    public void verifyProductsPageURL(String expectedURL) throws InterruptedException {
        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Then("An Error message should be displayed - {string}")
    public void verifyUnregisteredAccountErrorMessage(String expectedErrorMessage) throws InterruptedException {
        String actualErrorMessage = driver.findElement(By.xpath(ERROR_MESSAGE)).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


}
