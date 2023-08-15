package Home;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import static Login.LoginSteps.driver;
import static constant.Login.TABLE_CONTAINER;

public class TableCheck {


    @Then("Products table is displaying")
    public void productsTable() {
        boolean products = driver.findElement(By.xpath(TABLE_CONTAINER)).isDisplayed();
        Assert.assertTrue(products);
        System.out.println("Welcome Page");
    }

}
