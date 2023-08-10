package Login;

import com.google.gson.stream.JsonToken;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static configuration.DriverConfig.getChromeConfig;

public class LoginSteps {

    public static SwagLabLogin swagLabLogin;
    public static WebDriver driver;


    @BeforeAll
    public static void setUp() {
        driver = getChromeConfig();
        swagLabLogin = new SwagLabLogin(driver);
    }

    @When("A registered user who entered a valid username and password")
    public void inputValidUsernameAndPassword() {
        swagLabLogin.credentials();
    }

    @Then("The user will navigate to the products page {string}")
    public void verifyProductsPageURL(String expectedURL){
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,expectedURL);
    }



}
