package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static constant.Home.*;

public class ProductsPage {

    public static WebDriver driver;
    public static WebDriver chromeConfig;
    public static WebDriverWait webDriverWait;

    public ProductsPage(WebDriver driver) {
        ProductsPage.driver = driver;
    }


    public static void dropdownField() {
        WebElement dropdownFilter = driver.findElement(By.xpath(FILTERS_DROPDOWN));
        dropdownFilter.click();
    }

    public static void descendingChar() {
        WebElement fromAtoZ = driver.findElement(By.xpath(NAME_Z_TO_A));
        fromAtoZ.click();
    }

    public static void fromLowToHigh() {
        WebElement lowHigh = driver.findElement(By.xpath(LOW_TO_HIGH));
        lowHigh.click();
    }

    public static void fromHighToLow() {
        WebElement HighLow = driver.findElement(By.xpath(HIGH_TO_LOW));
        HighLow.click();
    }

    public static void sortedList() {
        List<WebElement> nameList = driver.findElements(By.cssSelector(INVENTORY_ITEM_NAME));
        List<String> original = nameList.stream().map(n -> n.getText()).collect(Collectors.toList());
        List<String> sortedNames = original.stream().sorted().collect(Collectors.toList());
        Collections.sort(sortedNames);
        original.stream().forEach(s -> System.out.println(s));
        sortedNames.stream().forEach(s -> System.out.println(s));
//       Assert.assertEquals(original, sortedNames);
//        System.out.println(original);
//        System.out.println(sortedNames);
    }


    public static void lowToHigh() {
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

    public static void highToLow() {
        List<WebElement> listElement = driver.findElements(By.xpath(INVENTORY_ITEM_PRICE));
        List<String> originalProductPrice = listElement.stream().map(s -> s.getText()).collect(Collectors.toList());
        ArrayList<String> sortedPrice = new ArrayList<>();

        for (int i = 0; i < originalProductPrice.size(); i++) {
            String price = originalProductPrice.get(i);
            StringBuilder priceStr = new StringBuilder(price);
            String format = priceStr.deleteCharAt(0).toString();
            sortedPrice.add(format);
        }
        List<String> orginalPriceList = sortedPrice.stream().collect(Collectors.toList());
        Collections.sort(sortedPrice, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o2) - extractInt(o1);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });

        orginalPriceList.forEach(s -> System.out.println(s));
        sortedPrice.forEach(s -> System.out.println(s));

//        formattedPrice.forEach(s -> System.out.println(s));
//        Assert.assertNotEquals(formattedPrice, sortedList);
    }






}
