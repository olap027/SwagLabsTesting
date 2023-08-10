package Login;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

public class LoginSteps {

    public static SwagLabLogin swagLabLogin;

    @BeforeAll
    public static void setUp() {
        swagLabLogin = new SwagLabLogin();

    }

    @Given("I will go to SwagLab")
    public void i_will_go_to_swag_lab()  {
        SwagLabLogin.gotoSwag();
    }

    @When("Enter credentials")
    public void Enter_credentials() {
        SwagLabLogin.credentials();
    }

   @Then("User will navigate to products page")
    public void User_will_navigate_to_products_page() {
        SwagLabLogin.productsPage();

    }


}
