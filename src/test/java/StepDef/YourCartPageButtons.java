package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

import static StepDef.Login.driver;
import static Util.SwagLabUtil.clickElement;
import static Util.SwagLabUtil.getText;
import static constant.YourCartPage.*;

public class YourCartPageButtons {


    @And("Click continue shopping button")
    public static void clickContinueShopping() {
        clickElement(CONTINUE_SHOPPING);
    }

    @And("Click checkout button")
    public static void clickCheckOutButton() {
        clickElement(CHECK_OUT);
    }

    @Then("User should be redirected to products page and has a title {string}")
    public static void checkProductPageRedirection(String expectedTitle) {
        String title = getText(TITLE);
        Assert.assertEquals(expectedTitle, title);
    }

    @Then("User should be redirected to Check Out page and has a title {string}")
    public static void checkCheckOutPageRedirection(String expectedTitle) {
        String title = getText(TITLE);
        Assert.assertEquals(expectedTitle, title);
    }

}
