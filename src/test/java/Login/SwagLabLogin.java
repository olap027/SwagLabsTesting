package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static configuration.DriverConfig.getDriverWait;
import static constant.Login.*;
import static utils.AppUtil.getElementWithPolling;


public class SwagLabLogin {

    public static WebDriver driver;
    public static WebDriver chromeConfig;
    public static WebDriverWait webDriverWait;

    public SwagLabLogin(WebDriver driver) {
        this.driver = driver;
    }

//    public  static void credentials (){
//        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
//        usernameField.sendKeys("standard_user");
//
//        WebElement passwordField = driver.findElement(By.xpath(PASSWORD_FIELD));
//        passwordField.sendKeys("secret_sauce");
//
//        WebElement loginBtn = driver.findElement(By.xpath(LOGIN_BTN));
//        loginBtn.click();
//
//    }

    public static void enterValidUser() {
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
        usernameField.sendKeys("standard_user");
    }

    public static void enterInvalidUser() {
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
        usernameField.sendKeys("non_user");
    }

    public static void enterLockedUser() {
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_FIELD));
        usernameField.sendKeys("locked_out_user");
    }

    public static void enterValidPass() {
        WebElement passwordField = driver.findElement(By.xpath(PASSWORD_FIELD));
        passwordField.sendKeys("secret_sauce");
    }

    public static void clickLogin() {
        WebElement loginBtn = driver.findElement(By.xpath(LOGIN_BTN));
        loginBtn.click();
    }

    public static void productsPage() {
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current Url: " + currentURL);
    }

    public static void ErrorMessageNonUser() {
        webDriverWait = getDriverWait(driver);
        WebElement error_message = getElementWithPolling(webDriverWait, By.xpath(ERROR_MESSAGE));
        String actualError = error_message.getText();
        System.out.println("The Actual Error Message: " + actualError);
    }

    public static void ErrorMessageLockUser(){
        webDriverWait = getDriverWait(driver);
        WebElement error_message = getElementWithPolling(webDriverWait, By.xpath(ERROR_MESSAGE));
        String actualError = error_message.getText();
    }

}
