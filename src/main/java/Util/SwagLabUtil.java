package Util;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SwagLabUtil {
    public static WebDriver driver;

    public SwagLabUtil(WebDriver driver) {
        this.driver = driver;
    }
    public static void clickElement(String element){
        driver.findElement(By.className(element)).click();
    }
    public static String getText(String element){
        return driver.findElement(By.className(element)).getText();
    }
    public static void sendKeys(String text, String element){
        driver.findElement(By.cssSelector(element)).sendKeys(text);
    }
    public static void extentReport(){


    }
}
