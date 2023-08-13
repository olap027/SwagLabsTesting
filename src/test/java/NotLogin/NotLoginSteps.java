package NotLogin;

import Login.SwagLabLogin;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static configuration.DriverConfig.getChromeConfig;
import static constant.Login.ERROR_MESSAGE;

public class NotLoginSteps {

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

    //007
    @When("I access the Home page without login {string}")
    public void inventorySite(String url) {
        driver.get("http://www.saucedemo.com/inventory.html");
        System.out.println("The url navigating: " + url);
    }

    @Then("Show error message for accessing home site without login {string}")
    public void accessingInventoryPage(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

    ///008
    @When("I will access the add to cart page without login {string}")
    public void addToCartSite(String url) {
        driver.get("http://www.saucedemo.com/cart.html");
        System.out.println("The url navigating: " + url);
    }

    @Then("Show error message for accessing add to cart page without login {string}")
    public void accessingAddToCartPage(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

    //009
    @When("I will access the check out page step 1 page without login {string}")
    public void checkoutStep1Site(String url) {
        driver.get("http://www.saucedemo.com/checkout-step-one.html");
        System.out.println("The url navigating: " + url);
    }

    @Then("Show error message for accessing check out page step 1 page without login {string}")
    public void accessingCheckoutStep1Page(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

    //010
    @When("I will access the check out page step 2 without login {string}")
    public void step2CheckoutSite(String url) {
        driver.get("http://www.saucedemo.com/checkout-step-two.html");
        System.out.println("The url navigating: " + url);
    }

    @Then("Show error message for accessing check out page step 2 page without login {string}")
    public void accessingStep2CheckoutPage(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

    ///011
    @When("I will access the Complete Order page without login {string}")
    public void completeOrderSite(String url) {
        driver.get("http://www.saucedemo.com/checkout-complete.html");
        System.out.println("The url navigating: " + url);
    }

    @Then("Show error message for accessing Complete Order page without login {string}")
    public void accessingCompleteOrderPage(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }
}
