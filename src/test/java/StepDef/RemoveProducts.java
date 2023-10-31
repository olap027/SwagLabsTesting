package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

import static Page.RemoveProducts.checkProducts;
import static Page.RemoveProducts.clickRemove;
import static constant.AddToCart.ADD_TO_CART_BUTTON;
import static constant.AddToCart.REMOVE_BUTTON;
import static constant.Table.PRODUCT_NAME;

public class RemoveProducts {
    static List<String> removedProductsInProductPage;
    static List<String> removedProductsInYourCartPage;

    @And("Remove Products in Products Page")
    public static void clickRemoveButtonInProductsPage(){
        removedProductsInProductPage =clickRemove(ADD_TO_CART_BUTTON, PRODUCT_NAME);
    }

    @Then("Products removed in Your Cart page should not be displayed in Your Cart Page")
    public static void checkRemovedProducts(){
        List<String> products = checkProducts();
        Assert.assertTrue(!removedProductsInProductPage.contains(products));
    }

    @Then("Removed products should not be displayed in my Cart")
    public static void checkRemovedProductsInMyCart(){
        List<String> products = checkProducts();
        Assert.assertTrue(!removedProductsInYourCartPage.contains(products));
    }

    @And("Remove Products in Your Cart Page")
    public static List<String> clickRemoveButtonInYourCartPage(){
        removedProductsInYourCartPage = clickRemove(REMOVE_BUTTON, PRODUCT_NAME);
        return removedProductsInYourCartPage;
    }
}
