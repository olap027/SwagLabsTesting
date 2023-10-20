package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.stream.Collectors;

import static constant.Home.*;
import static constant.Login.BURGER_ICON;
import static constant.Login.LOG_OUT_BTN;

public class CheckOutMethods {

    public static WebDriver driver;
    public static WebDriver chromeConfig;
    public static WebDriverWait webDriverWait;

    public static Random random;

    public CheckOutMethods(WebDriver driver) {
        CheckOutMethods.driver = driver;
        random = new Random();
    }

    public static String[] firstNames = {"John", "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Robin"};
    public static String[] lastNames = {"Doe", "Smith", "Johnson", "Williams", "Jones", "Brown", "Hood"};
    public static String[] zipcode = {"111", "222", "333", "444", "555", "666", "777"};


    public static void inputFirstName() {
        String randomFN = firstNames[random.nextInt(firstNames.length)];
        WebElement inputFN = driver.findElement(By.xpath(FIRST_NAME_INPUT));
        inputFN.sendKeys(randomFN);
    }

    public static void inputLastName() {
        String randomLN = lastNames[random.nextInt(lastNames.length)];
        WebElement inputLN = driver.findElement(By.xpath(LAST_NAME_INPUT));
        inputLN.sendKeys(randomLN);
    }

    public static void inputZipCode() {
        String randomZip = zipcode[random.nextInt(zipcode.length)];
        WebElement inputZC = driver.findElement(By.xpath(ZIP_CODE_INPUT));
        inputZC.sendKeys(randomZip);
    }

    public static void clickContinue() {
        WebElement continueBtn = driver.findElement(By.xpath(CONTINUE_BTN));
        continueBtn.click();
    }

    public static void itemPriceList() {
        List<WebElement> elementList = driver.findElements(By.xpath(INVENTORY_ITEM_PRICE));
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
        ArrayList<String> formattedPrice = new ArrayList<>();

        for (int i = 0; i < originalList.size(); i++) {
            String price = originalList.get(i);
            StringBuilder priceStr = new StringBuilder(price);
            String format = priceStr.deleteCharAt(0).toString();
            formattedPrice.add(format);
        }

        Collections.sort(formattedPrice, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });

        formattedPrice.forEach(s -> System.out.println(s));
    }

    public static void listCheckOutProducts() {
        List<WebElement> productList = driver.findElements(By.cssSelector(INVENTORY_ITEM_NAME));
        List<String> listedProducts = productList.stream().map(n -> n.getText()).collect(Collectors.toList());
        listedProducts.stream().forEach(s -> System.out.println(s));
    }

    public static void totalAmount() {
        String priceTotal = driver.findElement(By.xpath(TOTAL_PRICE)).getText();
//        priceTotal = priceTotal.replace("Total: $", "");
        System.out.println(priceTotal);

    }

    public static void subTotalAmount() {
        String itemTotal = driver.findElement(By.xpath(ITEM_TOTAL)).getText();
        System.out.println(itemTotal);
    }

    public static void tax() {
        String tax = driver.findElement(By.xpath(TAX)).getText();
        System.out.println(tax);
    }

    public static void clickCancel() {
        WebElement click_cancel = driver.findElement(By.xpath(CANCEL_BTN));
        click_cancel.click();
    }

    public static void clickFinish() {
        WebElement clickFinish = driver.findElement(By.xpath(FINISH_BTN));
        clickFinish.click();
    }

    public static void clickBackHome() {
        WebElement clickBackToHomeBtn = driver.findElement(By.xpath(BACK_TO_HOME));
        clickBackToHomeBtn.click();
    }

    public static void clickLogoutBtn () throws InterruptedException {
        WebElement iconBurger = driver.findElement(By.xpath(BURGER_ICON));
        iconBurger.click();
        Thread.sleep(2000);

        WebElement logout = driver.findElement(By.xpath(LOG_OUT_BTN));
        logout.click();
    }


}
