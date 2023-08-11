package Login;

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

    @And("Clicked Login")
    public void clickLoginButton() {
        swagLabLogin.clickLogin();
    }
    @And("User log out")
    public void loggingOut(){

    }

    //SL_TC_001
    @When("A registered user entered a valid {string} and {string}")
    public void loginRegisteredAccount(String username, String password) {
        swagLabLogin.inputRegisteredUsername(username);
        swagLabLogin.validPassword(password);
    }

    @Then("The user will navigate to the products page {string}")
    public void verifyProductsPageURL(String expectedURL) throws InterruptedException {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Thread.sleep(3000);
    }

    //SL_TC_002
    @When("An unregistered user entered username and password")
    public void loginUnregisteredAccount() {
        swagLabLogin.inputUnregisteredUsername();
        swagLabLogin.invalidPassword();
    }

    @Then("An error message for an unregistered account will be displayed {string}")
    public void verifyUnregisteredAccountErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.xpath(UNREGISTERED_ERROR_MESSAGE)).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    //SL_TC_003
    @When("A locked-out user entered {string} and {string}")
    public void loginLockedOutUser(String username, String password) {
        swagLabLogin.inputLockedOutUsername(username);
        swagLabLogin.validPassword(password);
    }

    @Then("An error message for locked-out users will be displayed {string}")
    public void verifyLockedOutAccountErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.xpath(UNREGISTERED_ERROR_MESSAGE)).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("The user entered a {string}")
    public void enterPasswordOnly(String password){
        swagLabLogin.validPassword(password);
    }
    @Then("An error message for an unfilled username will be displayed {string}")
    public void verifyUnfilledUsernameErrorMessage(String expectedErrorMessage){
        String actualErrorMessage = driver.findElement(By.xpath(UNREGISTERED_ERROR_MESSAGE)).getText();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }



}
