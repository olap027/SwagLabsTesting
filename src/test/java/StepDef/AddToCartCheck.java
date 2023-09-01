package StepDef;

import Pages.AddToCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static Pages.LoginMethods.driver;

public class AddToCartCheck {

    static List<String> list;

    @Given("Select only 1 random item on product page")
    public void selectItems() throws InterruptedException {
        AddToCart.selectOneItem();
        Thread.sleep(2000);
    }

    @Given("Select multiple random item on product page")
    public void selectMoreItems() throws InterruptedException {
        AddToCart.clickRandomMultipleProducts();
        Thread.sleep(2000);
    }


    @When("I click the add to cart button")
    public void IconAddToCart() throws InterruptedException {
        AddToCart.clickAddToCartIcon();
        Thread.sleep(2000);

    }

    @And("Verify the button form add to cart change into remove")
    public static List<String> buttonVerify() {
        AddToCart.verifyButtonName();
        AddToCart.equalName();
        return list;
    }

    @Then("Go to Add to Cart Page to verify same item selected on the product page")
    public void addToCartPage() {
        AddToCart.verifyNameInCartPage();
    }

    @When("I remove an items in the home")
    public void removeItemInCart() throws InterruptedException {
        AddToCart.removeItemList();
        Thread.sleep(2000);
    }

    @Then("Will show a remove item in home")
    public List<String> showRemoveItemInHome() throws InterruptedException {
        AddToCart.equalName();
        return list;
    }

    @Then("The removed products should not be displayed in Your Cart page")
    public List<String> showRemoveItem() throws InterruptedException {
        AddToCart.equalName();
        Thread.sleep(2000);
        AddToCart.clickAddToCartIcon();
        Thread.sleep(2000);
        AddToCart.verifyNameInCartPage();
        return list;
    }

    @And("I click the continue shopping button")
    public void clickContinueShopping() {
        AddToCart.clickContinueShopBtn();
    }

    @Then("User should be redirected to Products page {string}")
    public void productPage(String url) {
        driver.get(url);
        System.out.println("The url navigating: " + url);
    }

    @And("I click the checkout button")
    public void clickCheckOutBtn() {
        AddToCart.clickCheckOutBtn();
    }

    @Then("User will be redirected to Checkout: Your Information page")
    public void pageInformation(){
        AddToCart.pageInformation();
    }

    @Then("User will not be able to proceed to checkout and a prompt message will be displayed")
    public void errorCheckOut (){
    }


}
