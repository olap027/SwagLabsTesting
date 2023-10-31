package StepDef;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import static StepDef.Login.driver;
import static constant.Table.PRODUCT_TABLE;

public class ProductTable {
    @Then("A product table should be displayed")
    public void checkProductTable(){
        boolean table = driver.findElement(By.className(PRODUCT_TABLE)).isDisplayed();
        Assert.assertTrue(table);
    }
}
