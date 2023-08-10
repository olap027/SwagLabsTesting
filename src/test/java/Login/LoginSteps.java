package Login;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("Enter credentials")
    public void Enter_credentials() {
        swagLabLogin.credentials();
    }

//    @Then("User will navigate to products page")
//    public void User_will_navigate_to_products_page() {
//
//    }


}
