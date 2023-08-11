package Login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constant.Login.*;


public class SwagLabLogin {

    private static WebDriver driver;
    public static WebDriver chromeConfig ;
    public static WebDriverWait webDriverWait ;
    public SwagLabLogin (WebDriver driver){
        this.driver = driver;
    }

    public  static void credentials (){
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
        usernameField.click();
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.xpath(PASSWORD_FIELD));
        passwordField.click();
        passwordField.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.xpath(LOGIN_BTN));
        loginBtn.click();

    }

    public static void productsPage(){
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

    }

}
