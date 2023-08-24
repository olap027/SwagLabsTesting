package StepDef;

import Pages.AddToCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddToCartCheck {


    @Given("Select only 1 random item on product page")
    public void selectItems () throws InterruptedException{
        AddToCart.selectOneItem();
        Thread.sleep(2000);
    }

    @Given("Select multiple random item on product page")
    public void selectMoreItems () throws InterruptedException{
        AddToCart.clickRandomMultipleProducts();
        Thread.sleep(2000);
    }


    @When("I click the add to cart button")
    public void IconAddToCart () throws InterruptedException{
        AddToCart.clickAddToCartIcon();
        Thread.sleep(2000);

    }

    @And("Verify the button form add to cart change into remove")
    public void buttonVerify(){
        AddToCart.verifyButtonName();
        AddToCart.equalName();
    }

    @Then("Go to Add to Cart Page to verify same item selected on the product page")
    public void addToCartPage (){
        AddToCart.verifyNameInCartPage();

    }

}
