package StepDef;

import Pages.AddToCart;
import Pages.CheckOutMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Pages.LoginMethods.driver;
import static constant.Home.CHECK_OUT_ERROR;

public class CheckOutCheck {

    @Given("Ready to checkout all orders in the cart")
    public void checkOutAllItemsInCart() throws InterruptedException {
        AddToCart.clickRandomMultipleProducts();
        AddToCart.clickAddToCartIcon();
        Thread.sleep(2000);
        AddToCart.clickCheckOutBtn();
        Thread.sleep(2000);
    }

    @When("I input the last name and zip code only")
    public void enterLastNameAndZip() throws InterruptedException {
        CheckOutMethods.inputLastName();
        CheckOutMethods.inputZipCode();
        Thread.sleep(2000);
    }

    @When("I input the first name and zip code only")
    public void enterFNameAndZip() throws InterruptedException {
        CheckOutMethods.inputFirstName();
        CheckOutMethods.inputZipCode();
        Thread.sleep(2000);
    }

    @When("I input the first name and last name only")
    public void enterFNameAndLName() throws InterruptedException {
        CheckOutMethods.inputFirstName();
        CheckOutMethods.inputLastName();
        Thread.sleep(2000);
    }

    @When("I input valid information for checkout")
    public void enterInformation() {
        CheckOutMethods.inputFirstName();
        CheckOutMethods.inputLastName();
        CheckOutMethods.inputZipCode();
    }

    @And("click continue")
    public void clickContinueBtn() {
        CheckOutMethods.clickContinue();
    }

    @Then("Error message will be displayed {string}")
    public void ErrorMessage(String expectedError) {
        WebElement error_message = driver.findElement(By.xpath(CHECK_OUT_ERROR));
        String actualError = error_message.getText();
        Assert.assertEquals(actualError, expectedError);
        System.out.println("Actual Error: " + actualError);
        System.out.println("Expected Error: " + expectedError);
    }

    @Then("User will be redirected to page {string}")
    public void overviewPage(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Page " + currentUrl);
        System.out.println("Expected Page " + expectedUrl);
        Assert.assertEquals(currentUrl, expectedUrl);

    }

    @Then("All the products I checked out should be listed in the page")
    public void listingProducts() throws InterruptedException {
        CheckOutMethods.listCheckOutProducts();
        Thread.sleep(2000);
    }

    @Then("Item total should display the sum of all products")
    public void itemTotalProducts() {
        CheckOutMethods.totalAmount();
    }

    @Then("Total should display the sum of item total and tax")
    public void totalItemAndTax() throws InterruptedException {
        CheckOutMethods.subTotalAmount();
        CheckOutMethods.tax();
        Thread.sleep(3000);
    }

    @And("click cancel")
    public void cancelCheckout() {
        CheckOutMethods.clickCancel();
    }

    @And("click finish")
    public void finishCheckout() {
        CheckOutMethods.clickFinish();
    }

    @And("click back to home")
    public void backToHomePage() {
        CheckOutMethods.clickBackHome();
    }


}
