package Home;

import Pages.LoginMethods;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterCheck {

    @Given("The user is logged in")
    public void LoggedInAccount() {
        LoginMethods.enterValidUser();
        LoginMethods.enterValidPass();
    }

    @When("Choose the dropdown sorted from Z to A")
    public void chooseDescendingChar() {
        ProductsPage.dropdownField();
        ProductsPage.descendingChar();
    }

    @Then("Table is sorted from {string}")
    public void sorting(String sortNames) {
        System.out.println("Dropdown selected " + sortNames);
        ProductsPage.sortedList();
    }

    @When("Choose the dropdown sorted from low to high")
    public void chooseHighToLow() {
        ProductsPage.dropdownField();
        ProductsPage.fromLowToHigh();
    }

    @Then("Table Price is sorted from Low to High")
    public void SortingPrice() {
        System.out.println("Low to High");
        ProductsPage.lowToHigh();
    }

    @When("Choose the dropdown sorted from high to low")
    public void chooseLowToHigh() {
        ProductsPage.dropdownField();
        ProductsPage.fromHighToLow();
    }

    @Then("Table Price is sorted from High to Low")
    public void notSortingPrice() {
        System.out.println("High to Low");
        ProductsPage.highToLow();
    }


}
