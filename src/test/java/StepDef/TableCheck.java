package StepDef;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import static StepDef.LoginSteps.driver;
import static constant.Login.TABLE_CONTAINER;

public class TableCheck {


    @Then("Products table is displaying")
    public void productsTable() throws InterruptedException {
        boolean products = driver.findElement(By.xpath(TABLE_CONTAINER)).isDisplayed();
        Assert.assertTrue(products);
        Thread.sleep(3000);
        System.out.println("Welcome Page");
    }

}
