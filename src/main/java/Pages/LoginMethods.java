package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static configuration.DriverConfig.getDriverWait;
import static constant.Login.*;
import static utils.AppUtil.getElementWithPolling;


public class LoginMethods {

    public static WebDriver driver;
    public static WebDriver chromeConfig;
    public static WebDriverWait webDriverWait;

    public LoginMethods(WebDriver driver) {
        LoginMethods.driver = driver;
    }

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

    public static void ErrorMessageLockUser() {
        webDriverWait = getDriverWait(driver);
        WebElement error_message = getElementWithPolling(webDriverWait, By.xpath(ERROR_MESSAGE));
        String actualError = error_message.getText();
    }

    public static void clickLogout() throws InterruptedException {
        WebElement clickBurgerIcon = driver.findElement(By.xpath(BURGER_ICON));
        clickBurgerIcon.click();
        Thread.sleep(2000);

        WebElement clickLogout = driver.findElement(By.xpath(LOG_OUT_BTN));
        clickLogout.click();
    }

    public static void clearField() throws InterruptedException {
        WebElement clickErrorButton = driver.findElement(By.cssSelector(ERROR_EXIT_BUTTON));
        clickErrorButton.click();
        Thread.sleep(2000);

        WebElement fieldUsername = driver.findElement(By.xpath(USERNAME_FIELD));
        fieldUsername.clear();

        WebElement fieldPassword = driver.findElement(By.xpath(PASSWORD_FIELD));
        fieldPassword.clear();
        Thread.sleep(2000);
    }

}
