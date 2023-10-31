package Page;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


import static constant.Table.PRODUCT_NAME;

public class RemoveProducts{
    private static WebDriver driver;

    public RemoveProducts(WebDriver driver) {
        this.driver = driver;
    }

    public static List<String> clickRemove(String button, String productText) {
        List<WebElement> productList = driver.findElements(By.className(button));
        List<String> newProd = productList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<Integer> addToCartItem = new ArrayList<>();
        List<String> removeItems = new ArrayList<>();

        for (int i = 0; i < productList.size(); i++) {
            if(newProd.get(i).contains("Remove")){
                addToCartItem.add(i);
            }
        }
        int random = ThreadLocalRandom.current().nextInt(1, addToCartItem.size());
        for (int i = 0; i < random; i++) {
            productList.get(addToCartItem.get(i)).click();
            removeItems.add(driver.findElements(By.className(productText)).get(addToCartItem.get(i)).getText());
        }

        return removeItems;
    }

        public static List<String >checkProducts(){
        List<String> products = driver.findElements(By.className(PRODUCT_NAME)).stream().map(s->s.getText()).collect(Collectors.toList());
        return products;
        }

}





