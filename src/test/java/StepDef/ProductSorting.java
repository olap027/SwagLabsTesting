package StepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

import static Page.ProductListing.*;
import static constant.Table.*;


public class ProductSorting {



    @And("Sort dropdown is clicked")
    public void selectDropDown() throws InterruptedException {
        clickSortDropdown();
    }

    @And("Select Name Z to A")
    public void selectOption2() throws InterruptedException {
        selectSort(OPTION_TWO);
        Thread.sleep(3000);
    }
    @And("Select Price Low to High")
    public void selectOption3() throws InterruptedException {
        selectSort(OPTION_THREE);
    }
    @And("Select High to Low")
    public void selectOption4() throws InterruptedException {
        selectSort(OPTION_FOUR);
    }

    @Then("Product name should be sorted from A to Z")
    public void checkNameAToZSort(){
        sortAscendingOrder(PRODUCT_NAME);
    }
    @Then ("Product name should be sorted from Z to A")
    public void checkNameZtoASort(){
        sortDescendingOrder(PRODUCT_NAME);
    }
    @Then("Product should be sorted from Lowest to Highest price")
    public void checkPriceLowestToHighest(){
        sortPriceAscendingOrder(PRODUCT_PRICE);
    }
    @Then("Product should be sorted from Highest to Lowest Price")
    public void checkPriceHighestToLowest(){
        sortPriceDescendingOrder(PRODUCT_PRICE);
    }
}
