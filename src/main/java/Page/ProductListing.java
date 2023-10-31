package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

import static constant.Table.*;
import static org.junit.Assert.*;


public class ProductListing {
    public static WebDriver driver;

    public ProductListing(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickSortDropdown() {
        WebElement dropdown = driver.findElement(By.xpath(DROPDOWN));
        dropdown.click();
    }

    public static void selectSort(String dropdownOption) throws InterruptedException {
        WebElement option = driver.findElement(By.cssSelector(dropdownOption));
        option.click();
        Thread.sleep(3000);
    }

    public static void sortAscendingOrder(String productList) {
        List<WebElement> elementList = driver.findElements(By.className(productList));
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().collect(Collectors.toList());
        Assert.assertEquals(sortedList, originalList);

    }

    public static void sortDescendingOrder(String productList) {
        List<WebElement> elementList = driver.findElements(By.className(productList));
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());
        Assert.assertEquals(sortedList, originalList);
    }


    public static void sortPriceAscendingOrder(String productList) {
        List<WebElement> priceList = driver.findElements(By.className(productList));
        List<String> productListText = priceList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = new ArrayList<>();

        for (int i = 0; i < productListText.size(); i++) {
            String price = productListText.get(i);
            StringBuilder priceStr = new StringBuilder(price);
            String format = priceStr.deleteCharAt(0).toString();
            sortedList.add(format);
        }

        List<String> originalList = sortedList.stream().collect(Collectors.toList());

        Collections.sort(sortedList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });
        Assert.assertEquals(originalList, sortedList);
    }

    public static void sortPriceDescendingOrder(String productList) {
        List<WebElement> elementList = driver.findElements(By.className(productList));
        List<String> productListText = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
        ArrayList<String> sortedList = new ArrayList<>();

        for (int i = 0; i < productListText.size(); i++) {
            String price = productListText.get(i);
            StringBuilder priceStr = new StringBuilder(price);
            String format = priceStr.deleteCharAt(0).toString();
            sortedList.add(format);
        }
        List<String> originalList = sortedList.stream().collect(Collectors.toList());
        Collections.sort(sortedList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o2) - extractInt(o1);
            }
            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });
        Assert.assertEquals(sortedList, originalList);

    }
}