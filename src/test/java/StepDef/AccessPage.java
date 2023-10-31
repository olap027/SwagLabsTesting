package StepDef;


import com.aventstack.extentreports.ExtentReports;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

import static StepDef.Login.driver;
import static constant.Login.ERROR_MESSAGE;


public class AccessPage {



    @When("User entered {string}")
    public void enterLink(String link){
        driver.get(link);
    }

    @Then("An error message should be displayed - {string}")
    public void checkErrorMessage(String expectedErrorMessage)  {
        String actualErrorMessage = driver.findElement(By.xpath(ERROR_MESSAGE)).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }

}
