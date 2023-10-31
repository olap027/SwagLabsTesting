package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static Page.AddToCart.*;


public class AddToCart {

    static List<String> myCart;
    static List<String> list;

    @And("Add products to cart")
    public static void addProductsToMyCart(){
        clickRandomProducts();
    }
    @And("Get the name of the product that buttons is labeled as \"Remove\"")
    public static List<String> getTextOfTheProducts(){
        list=getProductName().stream().sorted().collect(Collectors.toList());
        return list;
    }
    @And("Click the cart icon")
    public static void clickCartIcon(){
        clickAddToCartIcon();
    }

    @Then("Products that have been added to my cart will be displayed on Your Cart page")
    public static void checkProductsAddedToMyCart(){
        myCart=checkProducts().stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(list,myCart);

    }

}
