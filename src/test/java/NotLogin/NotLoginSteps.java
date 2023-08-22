package NotLogin;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Pages.LoginMethods.driver;
import static constant.Login.ERROR_MESSAGE;

public class NotLoginSteps {

    @When("I will access the page without login {string}")
    public void inputTheSite(String url) {
        driver.get(url);
        System.out.println("The url navigating: " + url);
    }

    @Then("Show error message for accessing the site without login {string}")
    public void accessingThePage(String expectedError){
        WebElement error_message = driver.findElement(By.xpath(ERROR_MESSAGE));
        String actualLockedError = error_message.getText();
        Assert.assertEquals(actualLockedError, expectedError);
        System.out.println("Actual Error: " + actualLockedError);
        System.out.println("Expected Error: " + expectedError);
    }

}
