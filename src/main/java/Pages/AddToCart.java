package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static constant.Home.*;

public class AddToCart {

    public static WebDriver driver;
    public static WebDriver chromeConfig;
    public static WebDriverWait webDriverWait;


    public static Random random;

    public AddToCart(WebDriver driver) {
        AddToCart.driver = driver;
        random = new Random();
    }

    public static void selectOneItem() {
        List<WebElement> buttons = driver.findElements(By.cssSelector(ADD_TO_CART_BTN));
        int buttonIndex = random.nextInt(buttons.size());
        buttons.get(buttonIndex).click();
    }

    public static List<String> equalName() {
        List<WebElement> productList = driver.findElements(By.cssSelector(BUTTON));
        List<String> newProd = productList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> addToCartItem = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (newProd.get(i).contains("Remove")) {
                addToCartItem.add(driver.findElements(By.cssSelector(INVENTORY_ITEM_NAME)).get(i).getText());
            }
        }
        addToCartItem.forEach(s -> System.out.println("Remaining remove item : " + s));
        return addToCartItem;
    }

    public static void clickRandomMultipleProducts() {
        List<WebElement> addToCartButton = driver.findElements(By.cssSelector(BUTTON));
        int random2 = ThreadLocalRandom.current().nextInt(0, addToCartButton.size());
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i <= random2; i++) {
            int random = ThreadLocalRandom.current().nextInt(0, addToCartButton.size());
            if (!randomNumbers.contains(random)) {
                addToCartButton.get(random).click();
                randomNumbers.add(random);
            } else {
                break;
            }
        }
    }

    public static void verifyButtonName() {
        String remove_name = driver.findElement(By.cssSelector(REMOVE_BTN)).getText();
        System.out.println(remove_name);
    }

    public static void clickAddToCartIcon() {
        WebElement addToCart = driver.findElement(By.xpath(ADD_TO_CART_ICON));
        addToCart.click();
    }

    public static void verifyNameInCartPage() {
        List<WebElement> addToCartList = driver.findElements(By.cssSelector(INVENTORY_ITEM_NAME));
        List<String> ListAddToCart = addToCartList.stream().map(s -> s.getText()).collect(Collectors.toList());
        ListAddToCart.forEach(s -> System.out.println(s));
    }

    public static void removeItemList() {
        List<WebElement> productList = driver.findElements(By.cssSelector(BUTTON));
        List<String> newProd = productList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<Integer> addToCartItem = new ArrayList<>();
        List<String> removeItems = new ArrayList<>();

        for (int i = 0; i < productList.size(); i++) {
            if (newProd.get(i).contains("Remove")) {
                addToCartItem.add(i);
            }
        }

        int random = ThreadLocalRandom.current().nextInt(1, addToCartItem.size());
        for (int i = 0; i < random; i++) {
            productList.get(addToCartItem.get(i)).click();
            removeItems.add(driver.findElements(By.cssSelector(INVENTORY_ITEM_NAME)).get(addToCartItem.get(i)).getText());
        }
        removeItems.forEach(s -> System.out.println("The item remove in home: " + s));
    }

    public static void clickContinueShopBtn() {
        WebElement continueShopBtn = driver.findElement(By.xpath(CONTINUE_SHOPPING_BTN));
        continueShopBtn.click();
    }

    public static void clickCheckOutBtn() {
        WebElement checkOutBtn = driver.findElement(By.xpath(CHECK_OUT_BTN));
        checkOutBtn.click();
    }

    public static void pageInformation() {
    String currentUrl = driver.getCurrentUrl();
        System.out.println("The Current Page navigate: " + currentUrl);
    }





}

