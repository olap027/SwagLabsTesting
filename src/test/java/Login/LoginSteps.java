package Login;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static configuration.DriverConfig.getChromeConfig;

public class LoginSteps {

    public static SwagLabLogin swagLabLogin;
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = getChromeConfig ();
        swagLabLogin = new SwagLabLogin(driver);

    }

//    @Given("I will go to SwagLab")
//    public void i_will_go_to_swag_lab()  {
//        SwagLabLogin.gotoSwag();
//    }

    @When("Enter credentials")
    public void Enter_credentials() {
        swagLabLogin.credentials();
    }

   @Then("User will navigate to products page {string}")
    public void User_will_navigate_to_products_page(String expectedURL) {
        swagLabLogin.productsPage();
       String currentURL = driver.getCurrentUrl();
       Assert.assertEquals(currentURL,expectedURL);
       System.out.println(currentURL);


    }


}
