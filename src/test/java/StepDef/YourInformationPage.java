package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.SQLOutput;

import static Util.SwagLabUtil.*;
import static constant.YourInformationPage.*;

public class YourInformationPage {

    @And("Enter first name {string}")
    public static void enterFirstName(String firstName){
        sendKeys(firstName, FIRST_NAME);
    }
    @And("Enter last name {string}")
    public static void enterLastName(String lastName){

        sendKeys(lastName, LAST_NAME);
    }
    @And("Enter zipcode {string}")
    public static void enterZipCode(String zipCode){
        sendKeys(zipCode,ZIPCODE);
    }
    @And("Click continue")
    public static void clickContinue(){
        clickElement(CONTINUE_BUTTON);
    }
    @Then("There should be an error message {string}")
    public static void checkErrorMessage(String expectedErrorMessage){
        String actualErrorMessage=getText(ERROR_MESSAGE);
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
