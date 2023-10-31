package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static constant.AddToCart.ADD_TO_CART_BUTTON;
import static constant.AddToCart.CART_ICON;
import static constant.Table.PRODUCT_NAME;

public class AddToCart {
    private static WebDriver driver;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickRandomProducts() {
        List<WebElement> addToCartButton = driver.findElements(By.className(ADD_TO_CART_BUTTON));
        int random2 = ThreadLocalRandom.current().nextInt(1, addToCartButton.size());
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i <= random2; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, addToCartButton.size());
            if(!randomNumbers.contains(random)){
                addToCartButton.get(random).click();
                randomNumbers.add(random);
            }else {
                break;
            }

        }
    }

    public static void clickAddToCartIcon(){
        WebElement cartIcon = driver.findElement(By.className(CART_ICON));
        cartIcon.click();
    }

    public static List<String> getProductName(){
        List<WebElement> productList = driver.findElements(By.className(ADD_TO_CART_BUTTON));
        List<String> newProd = productList.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> addToCartItem = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if(newProd.get(i).contains("Remove")){
                addToCartItem.add(driver.findElements(By.className(PRODUCT_NAME)).get(i).getText());
            }
        }
        return addToCartItem;
    }

    public static List<String> checkProducts(){
        List<WebElement> products = driver.findElements(By.className(PRODUCT_NAME));
        List<String> productsAdded = products.stream().map(s->s.getText()).collect(Collectors.toList());
        return productsAdded;
    }
    }


